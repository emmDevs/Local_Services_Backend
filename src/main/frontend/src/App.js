import './app.css';
import React from 'react';
import {Route, Switch, BrowserRouter as Router} from 'react-router-dom';
import NavBar from "./components/NavBar";
import Search from "./components/Search";
import About from "./components/About";
import Home from "./components/Home";
import User from "./components/User";
import UserDetails from "./components/UserDetails";
import Shop from "./components/Shop";
import ShopDetails from "./components/ShopDetails";
import NewUser from "./components/NewUser";
import NewShop from "./components/NewShop";
import Basket from "./components/Basket";
import Footer from "./components/Footer";


import Categories from "./components/Categories";
import NewCategory from "./components/NewCategory";



function App() {

  
  

  return (
    <div id="app">
    <Router>
        
          <NavBar/>

      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/search" component={Search}/>
        <Route path="/about" component={About}/>
        <Route path="/user" component={User} exact/>
        <Route path="/user/:userId" component={UserDetails}/>
        <Route path="/shop" component={Shop} exact/>
        <Route path="/shop/:shopId" component={ShopDetails}/>
        <Route path="/category" component={Categories}/>
        <Route path="/new-user" component={NewUser}/>
        <Route path="/new-shop" component={NewShop}/>
        <Route path="/new-category" component={NewCategory}/>
        <Route path="/basket" component={Basket}/>
        
        
      </Switch>
      <Footer/> 
	  </Router>
    </div>




  );
}

export default App;
