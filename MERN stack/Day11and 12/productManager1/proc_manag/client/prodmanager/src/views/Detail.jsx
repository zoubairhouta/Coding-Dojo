import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, Link, Navigate } from 'react-router-dom';
import { useNavigate } from 'react-router-dom'
const Detail = (props) => {
    const navigate = useNavigate()
    const [product, setProduct] = useState({});
    const [isEditing, setIsEditing] = useState(false); // State to track edit mode
    const { id } = useParams();

    useEffect(() => {
        axios
            .get('http://localhost:8000/api/product/' + id)
            .then((res) => setProduct(res.data))
            .catch((err) => console.error(err));
    }, [id]);

    const handleEditClick = () => {
        // Toggle edit mode when the "Edit" button is clicked
        setIsEditing(!isEditing);
    };


    const updateProduct = (e) => {
        e.preventDefault()
        axios.put('http://localhost:8000/api/product/' +  id,product)
            .then(serverResponse => {
                console.log(serverResponse);
                // Update the products state to reflect the deletion
                navigate('/')
            })
            .catch(serverError => {
                console.log(serverError);
            });
            
    };

    return (
        <div>
            {isEditing ? ( // Render input fields in edit mode
                <><form onSubmit={updateProduct}>

                    <label htmlFor="title">Title:</label>
                    <input type="text" id="title" value={product.title} onChange={(e) => setProduct({ ...product, title: e.target.value })} />
                    <br />

                    <label htmlFor="description">Description:</label>
                    <input
                        type="text"
                        id="description"
                        value={product.description}
                        onChange={(e) => setProduct({ ...product, description: e.target.value })}
                    />
                    <br />

                    <label htmlFor="price">Price:</label>
                    <input type="number" id="price" value={product.price} onChange={(e) => setProduct({ ...product, price: e.target.value })} />
                    <br />
                    <button>update</button>
                </form>

                </>
            )























                : (
                    // Render text elements when not in edit mode
                    <>
                        <p>Title: {product.title}</p>
                        <p>Description: {product.description}</p>
                        <p>Price: {product.price}</p>
                    </>
                )}

            <button onClick={handleEditClick}>{isEditing ? 'Save' : 'Edit'}</button>
            <p>
                <Link to="/">Back home</Link>
            </p>
        </div>
    );
};

export default Detail;