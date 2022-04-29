function sendData(){
let n=document.getElementById('txt-input1').value
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

function fetchandstart(){
 var xmlHttp = new XMLHttpRequest();
   xmlHttp.open( "GET", 'http://localhost:8080/api/getresult', false ); // false for synchronous request
   xmlHttp.send( null );
   const leaky = JSON.parse(xmlHttp.responseText);
   drawtable(leaky);
}
function drawtable(leaky){
        var col = [];
        for (var i = 0; i < leaky.length; i++) {
            for (var key in leaky[i]) {
                if (col.indexOf(key) === -1) {
                    col.push(key);
                }
            }
        }

        // CREATE DYNAMIC TABLE.
        var table = document.createElement("table");
        var tr = table.insertRow(-1);                   // TABLE ROW.
        for (var i = 0; i < col.length; i++) {
            var th = document.createElement("th");      // TABLE HEADER.
            th.innerHTML = col[i];
            tr.appendChild(th);
        }

        // ADD JSON DATA TO THE TABLE AS ROWS.
        for (var i = 0; i < leaky.length; i++) {
            tr = table.insertRow(-1);
            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML =leaky[i][col[j]];
            }
        }
        var divContainer = document.getElementById("showData");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    }
let wave = document.querySelector(".wave");
console.log(wave)
var bottom=-400;

window.addEventListener('load',function () {
  move();
});
function move(){
var id=setInterval(frame,2000);
function frame(){
  wave.style.bottom=120;
  bottom=bottom-25;
  console.log(bottom);
}
}