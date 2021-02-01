import React from "react";
import styled from 'styled-components';

function Search() {

    const SearchLabel = styled.label`
        font-family: sans-serif;
        font-size: 24px;
        margin: 10px;
        padding: 0;
        position: relative;
        left: 0;
    `;

    const SearchInput = styled.input`
        border-radius: 20px;
        height: 30px;
        width: 15rem;
        margin-top: 8px;

        ::placeholder {
            color: blue;
        }
    `;


    return(
        <>
        <SearchLabel for="search">Search Services:</SearchLabel>
        <SearchInput type="text" id="search" placeholder="Look for a service"></SearchInput>
        </>
    )
}

export default Search;