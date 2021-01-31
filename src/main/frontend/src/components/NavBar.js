import '../app.css';
import React from "react";
import { Link } from "react-router-dom";
import styled from 'styled-components';
import basket from "../assets/shopping-basket.png"



function NavBar() {

    const Header = styled.div`
        display: flex;
        flex-direction: row;
    `;

    const Li = styled.li`
        position: relative;
        text-decoration: none;
    `;

    const Img = styled.img`
        height: 25px;
        width: auto;
    `;


    return(
        <Header>
            <Link to="/">Site Name/Logo</Link>

            <ul>
                <li>
                    <Link to="/about">About</Link>
                </li>
                <li>
                    <Link to="/shop">Shop</Link>
                </li>
                <li>
                    <Link to="/basket"><Img src={basket} onClick="" alt="basket"></Img></Link>
                </li>
            </ul>
        </Header>
    )
}

export default NavBar;