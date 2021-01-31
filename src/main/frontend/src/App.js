
import React, {useState, useEffect} from 'react';
import {Route, Switch, BrowserRouter as Router} from 'react-router-dom';
import NavBar from "./components/NavBar";
import Search from "./components/Search";
import About from "./components/About";
import Home from "./components/Home";
import Shop from "./components/Shop";
import Basket from "./components/Basket"
import Footer from "./components/Footer";



function App() {

  

  return (
    <div id="app">
    <Router>
        
          <NavBar/>

      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/search" component={Search}/>
        <Route path="/about" component={About}/>  
        <Route path="/shop" component={Shop}/>
        <Route path="/basket" component={Basket}/>

      </Switch>
      <Footer/> 
	  </Router>
    </div>




  );
}

export default App;
