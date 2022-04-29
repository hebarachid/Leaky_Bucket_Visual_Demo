package com.heba.rachid.Heba.controller;

import com.heba.rachid.Heba.leaky.Bucket;
import com.heba.rachid.Heba.leaky.LeakyBucket;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Stack;

@Controller
public class BucketController {
    Stack<String> stack = new Stack<>();
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/leakyparameters")
    public void calculateLeaky(@RequestBody Bucket bucket){
        String result = LeakyBucket.calculateBucketResponse(bucket);
        System.out.println(result);
        stack.add(result);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/api/getresult")
    public @ResponseBody String getResult(){
        return stack.pop();
    }
}
