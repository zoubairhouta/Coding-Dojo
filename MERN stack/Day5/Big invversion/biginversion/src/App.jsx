import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import PersonCard from './components/PersonCard'

function App() {
  
  return (
    <>
      <PersonCard firstName="John" lastName="Smith" age={ 38 } hairColor="Brown" /> 
      <PersonCard firstName="Mounir" lastName="Smith" age={28 } hairColor="Blue" /> 
      <PersonCard firstName="Maria" lastName="Smith" age={ 18 } hairColor="Blond" /> 
      <PersonCard firstName="Slim" lastName="Smith" age={ 58 } hairColor="Red" /> 
    </>
  )
}

export default App
