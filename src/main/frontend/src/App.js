import './app.css';
import React, {useState, useEffect} from 'react';
import {Route, Switch, BrowserRouter as Router} from 'react-router-dom';
import axios from 'axios';
import NavBar from "./components/NavBar";
import Search from "./components/Search";
import About from "./components/About";
import Home from "./components/Home";
import Shop from "./components/Shop";
import Basket from "./components/Basket";
import Footer from "./components/Footer";
import NewShopForm from "./components/NewShopForm";
import ShopDetails from './components/ShopDetails';



function App() {

  
  

  return (
    <div id="app">
    <Router>
        
          <NavBar/>

      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/search" component={Search}/>
        <Route path="/about" component={About}/>  
        <Route path="/shop" component={Shop} exact/>
        <Route path="/new-form" component={NewShopForm}/>
        <Route path="/basket" component={Basket}/>
        <Route path="/shop/:shopId" component={ShopDetails}/>
      </Switch>
      <Footer/> 
	  </Router>
    </div>




  );
}

export default App;
