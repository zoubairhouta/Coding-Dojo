
  
  function closeRequest(userId) {
    var listItem = document.getElementById(userId);
    listItem.remove();
  }
  function changeName(newName) {
    var userNameElement = document.getElementById('userName');
    userNameElement.textContent = newName;
  }
  function acceptRequest(userId) {
    var listItem = document.getElementById(userId);
    listItem.remove();
  
    // Decrease connection requests count
    var requestsCount = document.getElementById('requestsCount');
    requestsCount.textContent = parseInt(requestsCount.textContent) - 1;
  
    // Increase your connections count
    var connectionsCount = document.getElementById('connectionsCount');
    var count = connectionsCount.textContent;
    if (count.includes('+')) {
      connectionsCount.textContent = count.replace('+', ''); // Remove the "+" sign
    }
    connectionsCount.textContent = parseInt(connectionsCount.textContent) + 1;
  }
  
  function closeRequest(userId) {
    var listItem = document.getElementById(userId);
    listItem.remove();
  
    // Decrease connection requests count
    var requestsCount = document.getElementById('requestsCount');
    requestsCount.textContent = parseInt(requestsCount.textContent) - 1;
  }