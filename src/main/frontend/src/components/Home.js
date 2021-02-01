
import React from "react";
import Search from "./Search";
import Categories from "./Categories";
import style from 'styled-components';

function Home() {

    const Title = style.h1`
        color: green;
        text-align: center;
    `;


    return(
        <div>
            <Search/>
            <Categories/>
            <Title>Home</Title>
        </div>
    )
}

export default Home;