
import React from "react";
import Search from "./Search";
import Categories from "./Categories";
import styled from 'styled-components';

function Home() {

    const HomeContainer = styled.div`
        display: flex;
        flex-direction: row;
        width: 100%;
        flex-grow: 1;
        margin: 5px;
        position: relative;
        top: 40px;
    `;

    


    return(
        <HomeContainer>
            <Search/>
            <Categories/>
        </HomeContainer>
    )
}

export default Home;