import '../app.css';
import React from "react";
import { Link } from "react-router-dom";
import styled from 'styled-components';
import basket from "../assets/shopping-basket.png"
import Logo from "../assets/ShLogo.png"



function NavBar() {

    const Header = styled.div`
        display: flex;
        flex-direction: row;
        flex-grow: 1;
        height: 110px;
        background-image: linear-gradient(aqua, transparent);
    `;

    const Text = styled.p`
        color: grey;
        text-decoration: none;

        :hover {
            color: blue;
        }
    `;

    const Li = styled.li`
        list-style-type: none;
        list-style: none;
        padding: 15px;
        text-decoration: none;
        font-family: sans-serif;
        font-size: 25px;
    `;

    const Img = styled.img`
        padding: 15px;
        position: relative;
        top: 10px;
        height: 25px;
        width: auto;
        margin-right: 50px;
    `;

    const Img_2 = styled.img`
    height: 200px;
    width: auto;
    position: absolute;
    `;

    const Ul = styled.ul`
        display: flex;
        flex-direction: row;
        margin-left: auto;
    `;


    return(
        <Header>
            <Link style={{Text}} to="/"><Img_2 src={Logo} alt="logo"></Img_2></Link>

            <Ul>
                <Li>
                    <Link to="/about"><Text>About</Text></Link>
                </Li>
                <Li>
                    <Link to="/shop"><Text>Shop</Text></Link>
                </Li>
                <Li>
                    <Link to="/basket"><Img src={basket} alt="basket"></Img></Link>
                </Li>
            </Ul>
        </Header>
    )
}

export default NavBar;