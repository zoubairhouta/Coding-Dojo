function like(id) {
    console.log("like ♥", document.querySelector(`#${id}`).innerText);
  
    var like = parseInt(document.querySelector(`#${id}`).innerText);
    like++;
    console.log(like);
    document.querySelector(`#${id}`).innerText = like;
  }