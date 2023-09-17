import { useState } from 'react'
import { Routes, Route } from 'react-router-dom'
import AddProduct from './components/AddProduct'
import AllProduct from './components/AllProduct'
import Detail from './views/Detail'
import Dashboard from './views/Dashboard'
function App() {

  return (
    <>
      <Routes>
        <Route path='/' element={
          <>
            {/* <AddProduct />
            <AllProduct /> */}
            <Dashboard/>
           
          </>
        } />
         <Route element={<Detail/>} path="/product/:id" /> 
      </Routes>
    </>
  )
}

export default App