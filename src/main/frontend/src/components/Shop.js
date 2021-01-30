import React, {useState, useEffect} from 'react';
import axios from 'axios';
import NewShopForm from "./NewShopForm";


const ShopProfiles = () => {
    const fetchShopProfiles = () => {
      axios.get("http://localhost:8080/shops")
      .then(res => {
        console.log(res)
      })
    }
  
    useEffect(() => {
      fetchShopProfiles();
    }, []);
  
    return <p>Fetch Test</p>
  }

function Shop() {


    return(
        <div>
            <h3>Shop Component</h3>
            <h4> Create New Profile or Log In</h4>
            <ShopProfiles/>
            <NewShopForm />
        </div>
    )
}

export default Shop;