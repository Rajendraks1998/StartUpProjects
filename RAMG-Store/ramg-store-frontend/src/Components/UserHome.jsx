// src/App.js
import React, { useState } from 'react';
import ProductTable from './components/ProductTable';
import ProductSearchBar from './components/ProductSearchBar'
import axios from 'axios'; // Assuming you have axios installed

function UserHome() {
  const [products, setProducts] = useState([]);

  const searchProductsByUsername = async (username) => {
    try {
      const response = await axios.get(`http://localhost:8080/api/products/search?username=${username}`);
      setProducts(response.data);
    } catch (error) {
      console.error('Error fetching products:', error);
    }
  };

  return (
    <div>
      <h1>Products</h1>
      <ProductSearchBar onSearch={searchProductsByUsername} />
      <ProductTable products={products} />
    </div>
  );
}

export default UserHome;
