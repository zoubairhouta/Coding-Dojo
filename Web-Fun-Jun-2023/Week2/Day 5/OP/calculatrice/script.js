var input = '';
var isOperatorAllowed = true;
var isCalculationDone = false;

function press(value) {
  if (isCalculationDone) {
    clr();
    isCalculationDone = false;
  }
  
  if (isOperatorAllowed || !isNaN(value)) {
    input += value;
    updateResult();
    isOperatorAllowed = true;
  }
}

function setOP(operator) {
  if (isOperatorAllowed) {
    input += operator;
    updateResult();
    isOperatorAllowed = false;
  }
}

function clr() {
  input = '';
  updateResult();
  isOperatorAllowed = true;
}

function calculate() {
  if (isOperatorAllowed && !isCalculationDone) {
    var result = eval(input);
    document.getElementById('display').textContent = result;
    input = result.toString();
    isOperatorAllowed = true;
    isCalculationDone = true;
  }
}

function updateResult() {
  document.getElementById('display').textContent = input;
}