function doA(){
  alert('누름');
}
var heading = document.querySelector("#heading");
var btn = document.querySelector("#btn");

// alert(heading);

// heading.onclick = doA;

heading.onclick = function(){
  heading.style.color = "black";
  heading.innerHTML = "글자도 바꿈";
  heading.style.backgroundColor = "greenyellow";
  heading.style.textAlign = "center";
  heading.style.fontSize = "100px";
};

btn.onclick = function(){
  var name = prompt('당신의 이름은?','이름');
  alert(name);
}