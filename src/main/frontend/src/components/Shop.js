import React, {useState, useEffect} from 'react';
import { Link } from "react-router-dom";
import axios from 'axios';
import NewShopForm from "./NewShopForm";
// import ShopDetails from "./ShopDetails";



const Shop = () => {

  const [shopList, setShopList] = useState([]);

  // const [shopProfile, setShopProfile] = useState({});
  // const [selectedShopId, setSelectedShopId] = useState({});
  

  // useEffect(() => {
  //   getShopProfile();
  // }, [selectedShopId]);

  const getShopList = () => {
    axios.get(`http://localhost:8080/shops/`)
    .then(res => {
      console.log(res);
      setShopList(res.data)
    });
  };

  useEffect(() => {
    getShopList();
  }, []);

  // const displayShopForm = () => {
  //   setNewForm(true);
  //   }
  
  

  return (
    <div>
      <h3>Shop Component</h3>
      {shopList
        ? shopList.map((shop, index) => {
          return(
            <div key={index}>
              <h5>Id {shop.id}. {shop.name}</h5>
            </div>
          );
        })
        : "Loading..."}
        <Link to="/new-form"><button className="btn">Create New Profile</button></Link>
    </div>
  );
  

  // const getShopProfile = () => {
  //   console.log("getting shop data");

  //   fetch(`http://localhost:8080/shops/${selectedShopId}`)
  //     .then(res => res.json())
  //     .then(data => setShopProfile(data))
  //     .then(() => setLoad(true))
  // }
  

  // return(
  //   <div>
  //       <h3>Shop Component</h3>
  //       <h4> Create New Profile or Log In</h4>
  //       <h4></h4>
        
  //       {/* <ShopDetails 
  //       shopProfile={shopProfile}
  //       load={load}
  //       /> */}
  //       <NewShopForm />
  //   </div>
  // )
}

export default Shop;