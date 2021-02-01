import React from "react";
import styled from 'styled-components';

function Categories() {

    const CategoryLabel = styled.label`
        font-family: sans-serif;
        font-size: 24px;
        margin: 10px;
        padding: 0;
        position: relative;
        left: 0;
    `;


    return(
        <CategoryLabel>List of Categories</CategoryLabel>
    )
}

export default Categories;