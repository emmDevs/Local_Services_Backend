import React from "react";
import styled from 'styled-components';

function Footer() {

    const Footer = styled.footer`
    height: 100px;
    width: 100%;
    display: flex;
    flex-direction: row;
    flex-grow: 1;
    background-image: linear-gradient(white, aqua);
    position: absolute;
    bottom: 0;
    `;

    const FooterList = styled.a`
        padding: 20px;
        margin: auto;
    `;


    return(
        <Footer>
            <FooterList href="/">Contact</FooterList>
            <FooterList href="/">Project Brief</FooterList>

        </Footer>
    )
}

export default Footer;