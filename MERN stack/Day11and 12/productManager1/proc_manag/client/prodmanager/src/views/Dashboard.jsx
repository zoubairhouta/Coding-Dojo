import React, { useState,useEffect } from 'react'
import AddProduct from '../components/AddProduct'
import AllProduct from '../components/AllProduct'
import axios from 'axios'
const Dashboard = (q) => {
    const [products, setProducts] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:8000/api/product")
            .then(serverResponse => {
                console.log(serverResponse.data, "✅✅✅");
                setProducts(serverResponse.data);
                console.log({ products });

                
            })
            .catch(serverError => console.log(serverError, "❌❌❌"));
    }, []);
    return (
        <div>
            <AddProduct products={products} setProducts={setProducts}/>
            <hr />
            <AllProduct products={products} setProducts={setProducts}/>
        </div>
    )
}

export default Dashboard