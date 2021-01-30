import React from 'react';
import {Route, Switch, BrowserRouter as Router} from 'react-router-dom';
import NavBar from "./components/NavBar";
import Search from "./components/Search";
import About from "./components/About";
import Home from "./components/Home";
import Business from "./components/Business";
import Basket from "./components/Basket"
import Footer from "./components/Footer";

function App() {
  return (
    <Router>        
        <NavBar/>
        
              
      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/search" component={Search}/>
        <Route path="/about" component={About}/>  
        <Route path="/business" component={Business}/>
        <Route path="/basket" component={Basket}/>

      </Switch>
      <Footer/> 
	  </Router>




  );
}

export default App;
