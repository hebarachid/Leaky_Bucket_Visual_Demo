package com.heba.rachid.Heba.leaky;

import com.google.gson.Gson;

import java.util.ArrayList;

public class LeakyBucket {
    public static String calculateBucketResponse(Bucket bucket){
        Gson gson = new Gson();
        String[] sr = bucket.getSpkt().split(",");
        int[] arr = new int[sr.length];
        for(int i = 0; i < arr.length;i++) {
            arr[i] = Integer.parseInt(sr[i]);
        }
        ArrayList<State> list = calculateBucketResponseHelper(bucket.getN(), bucket.getOp_rate(), bucket.getBsize(),arr);
        return gson.toJson(list);
    }
    private static ArrayList<State> calculateBucketResponseHelper(int n, int op_rate, int bsize, int[] pkt) {
        int bucket = 0;
        int i;
        ArrayList<State> list = new ArrayList<>();

        for (i = 0; i < n; i++) {
            State output = new State();
            output.setArrivingTime(i + 1);
            output.setPkt_size(pkt[i]);

            if (bucket + pkt[i] <= bsize) {
                bucket += pkt[i];
                output.setBkt_size(bucket);
                output.setAccepted(true);
                output.setPkt_sent(min(bucket, op_rate));

            } else {
                output.setBkt_size(bucket);
                output.setAccepted(false);
                output.setPkt_sent(min(bsize, op_rate));
                bucket = bsize;

            }
            bucket = sub(bucket, op_rate);
            list.add(output);

        }

        while (bucket != 0) {
            State output = new State(bucket, 0, true, min(bucket, op_rate), ++i);
            list.add(output);
            bucket = sub(bucket, op_rate);

        }
        return list;
    }

    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    static int sub(int a, int b) {
        return (a - b) > 0 ? (a - b) : 0;
    }
}
