import '../app.css';
import React from "react";
import { Link } from "react-router-dom";
import styled from 'styled-components';
import basket from "../assets/shopping-basket.png"



function NavBar() {

    const Header = styled.div`
    background-color: pink;
        display: flex;
        flex-direction: row;
        flex-grow: 1;
    `;

    const Li = styled.li`
        position: relative;
        text-decoration: none;
        list-style-type: none;
        list-style: none;
        padding: 10px;
        color: white;

        :hover {
            color: red;
        }
    `;

    const Img = styled.img`
        height: 25px;
        width: auto;
    `;

    const Ul = styled.ul`
        display: flex;
        flex-direction: row;
        margin-left: auto;
    `;


    return(
        <Header>
            <Link to="/">Site Name/Logo</Link>

            <Ul>
                <Li>
                    <Link to="/about">About</Link>
                </Li>
                <Li>
                    <Link to="/shop">Shop</Link>
                </Li>
                <Li>
                    <Link to="/basket"><Img src={basket} onClick="" alt="basket"></Img></Link>
                </Li>
            </Ul>
        </Header>
    )
}

export default NavBar;