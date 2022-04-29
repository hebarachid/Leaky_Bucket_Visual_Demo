function sendData(){
let n=document.getElementById('txt-input1').value
console.log(n);
let op_rate=document.getElementById('txt-input2').value;
let bsize=document.getElementById('txt-input3').value;
let spkt=document.getElementById('txt-input4').value;
const obj = {'n':n ,'op_rate':op_rate,'bsize':bsize,'spkt':spkt};
console.log(obj);
fetch('http://localhost:8080/api/leakyparameters', {
  method: 'POST',
  headers: {
    'Access-Control-Allow-Origin': '*',
    'Accept': 'application/json, text/plain, */*',
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(obj)
}).then(res => res.json())
  .then(res => console.log(res));
};
