import React, { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const AddProduct = (props) => {
    const navigate = useNavigate()
    const [product, setProduct] = useState({ title: "", description: "", price: 1 })
    const fromHandler = (e) => {
        e.preventDefault()
        console.log("SUBMITTED Product : ", product);
        axios.post("http://localhost:8000/api/product", product)
            .then(serverResponse => {
                console.log(serverResponse.data,"*************")
                props.setProducts([...props.products, serverResponse.data])
              navigate('/')
            })
            .catch(serverError => console.log(serverError))
        setProduct({ title: "", description: "", price: 1 })
    }
    
    return (
        <fieldset>
            <legend> <h2>AddProduct</h2></legend>
            <h4>
                Product FROM STATE {JSON.stringify(product)}
            </h4>
            <form onSubmit={fromHandler}>
                <p>title  : <input type="text"
                    onChange={(e) => setProduct({ ...product, title: e.target.value })}
                    value={product.title}
                /></p>
                <p>description : <input type="text"
                    onChange={(e) => setProduct({ ...product, description: e.target.value })}
                    value={product.description}
                /></p>
                <p>price  : <input type="number"
                    onChange={(e) => setProduct({ ...product, price: e.target.value })}
                    value={product.price}
                /></p>
                
                <button>Submit</button>
            </form>
        </fieldset>

    )
}

export default AddProduct