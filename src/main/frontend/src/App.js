import './app.css';
import React from 'react';
import {Route, Switch, BrowserRouter as Router} from 'react-router-dom';
import NavBar from "./components/NavBar";
import Search from "./components/Search";
import About from "./components/About";
import Home from "./components/Home";
import Shop from "./components/Shop";
import Basket from "./components/Basket";
import Footer from "./components/Footer";
import NewShopForm from "./components/NewShopForm";
import ShopDetails from './components/ShopDetails';
import styled from 'styled-components';



function App() {

  
  const AppStyle = styled.div`
    height: 100vh;
    width: 100vw;
    background-color: #e3e3e3;
  `;

  return (
    <AppStyle>
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
    </AppStyle>




  );
}

export default App;
