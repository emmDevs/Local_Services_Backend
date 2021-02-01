import React from "react";
import styled from 'styled-components';

function Search() {

    const SearchLabel = styled.label`
        font-family: sans-serif;
        font-size: 24px;
    `;


    return(
        <>
        <SearchLabel for="search">Search Services</SearchLabel>>
        <input type="text" id="search" placeholder="Look for a service"></input>
        </>
    )
}

export default Search;