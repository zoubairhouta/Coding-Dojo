import { useState } from 'react';
import './App.css';
import UserForm from './components/hooks1';
import UserView from './components/hooks2';

function App() {
  const [user, setUser] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    confirmPassword: "",
  });

  return (
    <div className="App">
      <UserForm user={user} setUser={setUser} />
      <UserView user={user} />
    </div>
  );
}

export default App;