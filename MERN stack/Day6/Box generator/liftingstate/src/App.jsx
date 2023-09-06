import { useState } from 'react';
import './App.css';
import BoxesView from './Components/BoxesView';
import InputForm from './Components/InputForm';

function App() {
  const [boxes, setBoxes] = useState([]);

  const addBox = (data) => {
    const newBoxes = [...boxes];
    newBoxes.push(data);
    setBoxes(newBoxes);
  }

  return (
    <div className="App">
      <InputForm addBox={ addBox } />
      <BoxesView boxes={ boxes } />
    </div>
  );
}

export default App;