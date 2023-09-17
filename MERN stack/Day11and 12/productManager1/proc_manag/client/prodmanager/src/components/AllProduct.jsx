import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

const AllProduct = ({products, setProducts}) => {
  // const [products, setProducts] = useState([]);

  // useEffect(() => {
  //   axios.get("http://localhost:8000/api/product")
  //     .then(serverResponse => {
  //       console.log(serverResponse.data, "✅✅✅");
  //       setProducts(serverResponse.data);
  //       console.log({ products });
  //     })
  //     .catch(serverError => console.log(serverError, "❌❌❌"));
  // }, [setProducts]);

  const deleteProduct = (productId) => {
    axios.delete('http://localhost:8000/api/product/' + productId)
      .then(serverResponse => {
        console.log(serverResponse);
        // Update the products state to reflect the deletion
        setProducts(prevProducts => prevProducts.filter(product => product._id !== productId));
      })
      .catch(serverError => {
        console.log(serverError);
      });
  };

  return (
    <fieldset>
      {/* {JSON.stringify(props)} */}
      <legend><h2>AllProduct</h2></legend>
      {products.map(product => (
        <div key={product._id}>
          <h4><Link to={`/product/${product._id}`}>Title : {product.title}</Link></h4>
          <p>description : {product.description}</p>
          <h5>price : {product.price}</h5>
          <button onClick={() => deleteProduct(product._id)}>Delete this product</button>
        </div>
      ))}
    </fieldset>
  );
}

export default AllProduct;
