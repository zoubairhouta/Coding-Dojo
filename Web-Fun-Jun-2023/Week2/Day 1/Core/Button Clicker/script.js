function custom() {

    console.log("this message is coming from script.js");
}
function hide(element)
{
element.remove();
}
function changeButtonValue() {
    var button = document.getElementById("myButton");
    button.value = "Logout";
  }