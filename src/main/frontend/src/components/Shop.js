import React, {useState, useEffect} from 'react';
import axios from 'axios';
import NewShopForm from "./NewShopForm";



function Shop() {

  const [shopProfileList, setShopProfileList] = useState([]);
  const [shopProfile, setShopProfile] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/shops/')
      .then(res => res.json())
      .then((data) => {
        const promises = data.map((id))
      });
  })

  // const ShopProfiles = () => {
  //   const [shopProfile, setShopProfile] = useState([]);
  
  //   const fetchShopProfiles = () => {
  //     axios.get('https://jsonplaceholder.typicode.com/users/')
  //     .then(res => {
  //       console.log(res);
  //     });
  //   }
  
  //   useEffect(() => {
  //     fetchShopProfiles();
  //   }, []);
  
  //   return <p>Fetch Test</p>
  //   }

  return(
    <div>
        <h3>Shop Component</h3>
        <h4> Create New Profile or Log In</h4>
        {/* <ShopProfiles /> */}
        <NewShopForm />
    </div>
  )
}

export default Shop;