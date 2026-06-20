document
.querySelector("button")

.onclick=()=>{

alert(
"Dashboard Coming Soon"
);

};
function addCitizen(){

let name =
document
.getElementById("name")
.value;

let city =
document
.getElementById("city")
.value;

if(
name===""
||
city===""

){

alert(
"Fill fields"
);

return;

}

let row=
`
<tr>

<td>${name}</td>

<td>${city}</td>

</tr>
`;

document
.getElementById("table")

.innerHTML += row;

}