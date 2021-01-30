import React, {useState} from "react";

function NewShopForm({onFormSubmit}) {

    const [name, setName] = useState("");
    const [address, setAddress] = useState("");
    const [postCode, setPostCode] = useState("");
    const [town, setTown] = useState("");
    const [openingHour, setOpeningHour] = useState("");
    const [closingHour, setClosingHour] = useState("");
    const [telephoneNumber, setTelephoneNumber] = useState("");
    const [email, setEmail] = useState("");
    const [image, setImage] = useState("");
    const [categories, setCategories] = useState("");
    const [services, setServices] = useState("");

    const handleNameChange = (evt) => {
        setName(evt.target.value);
    }

    const handleAddressChange = (evt) => {
        setAddress(evt.target.value);
    }

    const handlePostCodeChange = (evt) => {
        setPostCode(evt.target.value);
    }

    const handleTownChange = (evt) => {
        setTown(evt.target.value);
    }

    const handleOpeningHourChange = (evt) => {
        setOpeningHour(evt.target.value);
    }

    const handleClosingHourChange = (evt) => {
        setClosingHour(evt.target.value);
    }

    const handleTelephoneNumberChange = (evt) => {
        setTelephoneNumber(evt.target.value);
    }

    const handleEmailChange = (evt) => {
        setEmail(evt.target.value);
    }

    const handleImageChange = (evt) => {
        setImage(evt.target.value);
    }

    const handleCategoriesChange = (evt) => {
        setCategories(evt.target.value);
    }

    const handleServicesChange = (evt) => {
        setServices(evt.target.value);        
    }

    const handleSubmit = (evt) => {
        evt.preventDefault();
        const nameToSubmit = name.trim();
        const addressToSubmit = address.trim();
        const postCodeToSubmit = postCode.trim();
        const townToSubmit = town.trim();
        const openingHourToSubmit = openingHour.trim();
        const closingHourToSubmit = closingHour.trim();
        const telephoneNumberToSubmit = telephoneNumber.trim();
        const emailToSubmit = email.trim();
        const imageToSubmit = image.trim();
        const categoriesToSubmit = categories.trim();
        const servicesToSubmit = services.trim();

        if(!nameToSubmit || !addressToSubmit || !postCodeToSubmit 
            || !townToSubmit || !openingHourToSubmit || !closingHourToSubmit 
            || !telephoneNumberToSubmit || !emailToSubmit || !imageToSubmit 
            || !categoriesToSubmit || !servicesToSubmit) {
                return;
            }
            onFormSubmit({
                name: nameToSubmit,
                address: addressToSubmit,
                postCode: postCodeToSubmit,
                town: townToSubmit,
                openingHour: openingHourToSubmit,
                closingHour: closingHourToSubmit,
                telephoneNumber: telephoneNumberToSubmit,
                email: emailToSubmit,
                image: imageToSubmit,
                categories: categoriesToSubmit,
                services: servicesToSubmit
            })
            setName("");
            setAddress("");
            setPostCode("");
            setTown("");
            setOpeningHour("");
            setClosingHour("");
            setTelephoneNumber("");
            setEmail("");
            setImage("");
            setCategories("");
            setServices("");
    }

    return(
        <div>
            <h3>Create New Profile</h3>
            <form className="new-shop-form" onSubmit={handleSubmit}>

                <input type="text"
                placeholder="Name"
                value={name}
                onChange={handleNameChange}/>

                <input type="text"
                placeholder="Address"
                value={address}
                onChange={handleAddressChange}/>

                <input type="text"
                placeholder="Post Code"
                value={postCode}
                onChange={handlePostCodeChange}/>

                <input type="text"
                placeholder="Town"
                value={town}
                onChange={handleTownChange}/>

                <input type="number"
                placeholder="Opening Hour"
                value={openingHour}
                onChange={handleOpeningHourChange}/>

                <input type="number"
                placeholder="Closing Hour"
                value={closingHour}
                onChange={handleClosingHourChange}/>

                <input type="number"
                placeholder="Telephone Number"
                value={telephoneNumber}
                onChange={handleTelephoneNumberChange}/>

                <input type="text"
                placeholder="Email"
                value={email}
                onChange={handleEmailChange}/>

                <input type="url"
                placeholder="Image"
                value={image}
                onChange={handleImageChange}/>

                <input type="text"
                placeholder="Categories"
                value={categories}
                onChange={handleCategoriesChange}/>

                <input type="text"
                placeholder="Services"
                value={services}
                onChange={handleServicesChange}/>

                <input type="submit"
                value="submit"/>
            </form>
            
        </div>
    )
}

export default NewShopForm;