import React, { useEffect } from 'react'
import { useState } from 'react'
import { getProduct, saveProduct, updateProduct } from '../services/ProductService'
import { useNavigate, useParams } from 'react-router-dom'

const ProductComponent = () => {

    const [name, setName] = useState('')
    const [user, setUser] = useState({})
    const [quantity, setQuantity] = useState(0)
    const [price, setPrice] = useState(0)
    const navigate = useNavigate()
    const { id } = useParams()


    function saveOrUpdateProduct(e){
        e.preventDefault()

        const product = {name, quantity, price}
        console.log(product);

        if(id){

            updateProduct(id, product).then((response) => {
                navigate('/products')
            }).catch(error => {
                console.error(error);
            })

        }else{
            saveProduct(product).then((response) => {
                console.log(response.data)
                navigate('/products')
            }).catch(error => {
                console.error(error);
            })
        }
    }

    function pageTitle(){
        if(id) {
            return <h2 className='text-center'>Update Product</h2>
        }else {
            return <h2 className='text-center'>Add Product</h2>
        }
    }

    useEffect( () => {

        if(id){
            getProduct(id).then((response) => {
                console.log(response.data)
                setName(response.data.name)
                setQuantity(response.data.quantity)
                setPrice(response.data.price)
            }).catch(error => {
                console.error(error);
            })
        }

    }, [id])

  return (
    <div className='container'>
        <br /> <br />
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                { pageTitle() }
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Product Name:</label>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Product Title'
                                name='name'
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Product Description:</label>
                            <input
                                type='text'
                                className='form-control'
                                placeholder='Enter Product Quantity'
                                name='quantity'
                                value={quantity}
                                onChange={(e) => setQuantity(e.target.value)}
                            >
                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'>Product Completed:</label>
                            <select
                                className='form-control'
                                value={price}
                                onChange={(e) => setPrice(e.target.value)}
                            >
                                <option value="false">No</option>
                                <option value="true">Yes</option>

                            </select>
                        </div>

                        <button className='btn btn-success' onClick={ (e) => saveOrUpdateProduct(e)}>Submit</button>
                    </form>

                </div>
            </div>

        </div>
    </div>
  )
}

export default ProductComponent