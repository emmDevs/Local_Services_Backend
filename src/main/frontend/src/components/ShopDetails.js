import React from "react";

const ShopDetails = ({shopProfile, load}) => {

    if (!load){
        return <p>Loading...</p>
    }

    return (
        <div>
            <h3>{shopProfile.name}</h3>
            <h5>{shopProfile.address}</h5>
            <h5>{shopProfile.postcode}</h5>
            <h5>{shopProfile.town}</h5>
            <h5>{shopProfile.opening_hour}</h5>
            <h5>{shopProfile.closing_hour}</h5>
            <h5>{shopProfile.telephone_number}</h5>
            <h5>{shopProfile.email}</h5>  
            <h5><img src={shopProfile.image} alt="no image"/></h5>
            <h5>{shopProfile.services[0].name}</h5>
            <h5>{shopProfile.categories[0].name}</h5>
        </div>
    )

}

export default ShopDetails;