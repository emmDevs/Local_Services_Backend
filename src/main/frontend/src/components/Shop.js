import React, {useState, useEffect} from 'react';
import axios from 'axios';
import NewShopForm from "./NewShopForm";
import ShopDetails from "./ShopDetails";



function Shop() {

  const [shopProfile, setShopProfile] = useState({});
  const [selectedShopId, setSelectedShopId] = useState({});
  const [load, setLoad] = useState(false);

  useEffect(() => {
    getShopProfile();
  }, [selectedShopId]);

  const getShopProfile = () => {
    console.log("getting shop data");

    fetch(`http://localhost:8080/shops/${selectedShopId}`)
      .then(res => res.json())
      .then(data => setShopProfile(data))
      .then(() => setLoad(true))
      
  }

  return(
    <div>
        <h3>Shop Component</h3>
        <h4> Create New Profile or Log In</h4>
        <ShopDetails 
        shopProfile={shopProfile}
        load={load}
        />
        <NewShopForm />
    </div>
  )
}

export default Shop;