import React, { useEffect, useState } from 'react'
import { deleteProduct, getAllProductsByUserId } from '../services/ProductService'
import { useNavigate } from 'react-router-dom'
import { isAdminUser } from '../services/AuthService'

const ListProductComponent = () => {

    const [products, setProducts] = useState([])

    const navigate = useNavigate()


    useEffect(() => {
        listProducts();
    }, [])

    const isAdmin= isAdminUser();
    
    const userId = sessionStorage.getItem("userId");
    
    function listProducts(){
        getAllProductsByUserId(userId).then((response) => {
            setProducts(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewProduct(){
        navigate('/add-product')

    }

    function updateProduct(id){
        console.log(id)
        navigate(`/update-product/${id}`)
    }
    
    function removeProduct(id){
        deleteProduct(id).then((response) => {
            listProducts();
        }).catch(error => {
            console.error(error)
        })
    }

    // function updateQuantity(id){
    //     updateQuantity(id).then((response) => {
    //         listProducts()
    //     }).catch(error => {
    //         console.error(error)
    //     })
    // }
    // function markCompleteProduct(id){
    //     completeProduct(id).then((response) => {
    //         listProducts()
    //     }).catch(error => {
    //         console.error(error)
    //     })
    // }

    // function markInCompleteProduct(id){
    //     inCompleteProduct(id).then((response) => {
    //         listProducts();
    //     }).catch(error => {
    //         console.error(error)
    //     })
    // }

  return (
    <div className='container'>
        <h2 className='text-center'>List of Products</h2>
        <button className='btn btn-primary mb-2' onClick={addNewProduct}>Add Product</button>
        <div>
            <table className='table table-bordered table-striped'>
                <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Product Price</th>
                        <th>Product Quantity</th>
                        <th>User Name</th>
                        {
                            isAdmin && <th>Actions</th>
                        }
                       
                    </tr>
                </thead>
                <tbody>
                    {
                        products.map(product => 
                            <tr key={product.id}>
                                <td>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.quantity}</td>
                                <td>{product.user.name}</td>
                                <td>
                                    {
                                        isAdmin && <button className='btn btn-info' onClick={() => updateProduct(product.id)}>Update</button>
                                    }
                                    {
                                        isAdmin && <button className='btn btn-danger' onClick={() => removeProduct(product.id)} style={ { marginLeft: "10px" }} >Delete</button>
                                    }
                                    
                                    {/* <button className='btn btn-success' onClick={() => updateQuantity(product.id)} style={ { marginLeft: "10px" }} >Update Quantity</button> */}
                                </td>
                            </tr>
                        )
                    }

                </tbody>
            </table>
        </div>

    </div>
  )
}

export default ListProductComponent