import React from "react";

const ShopDetails = ({shop}) => {



    if (!shop){
        return <p>Loading...</p>
    }
    return (
        <div>
            <h4>{shop.name}</h4>
            <p>{shop.address}</p>
            <p>{shop.postcode}</p>
            <p>{shop.town}</p>
            <p>{shop.opening_hour}</p>
            <p>{shop.closing_hour}</p>
            <p>{shop.telephone_number}</p>
            <p>{shop.email}</p>  
            <img src={shop.image} alt="no available"/>
            <p>{shop.services[0].name}</p>
            <p>{shop.categories[0].name}</p>
        </div>
    )

}

export default ShopDetails;