import React, {useState} from "react";
// import axios from "axios";

function NewShopForm() {
    const [formData, setFormData] = useState({
        name: '',
        address: '',
        postCode: '',
        town: '',
        openingHour: '',
        closingHour: '',
        telephoneNumber: '',
        email: '',
        image: ''
        // category: '',
        // services: ''
    });

    const handleChange = (evt) => {
        const newState = {...formData};
        newState[evt.target.name] = evt.target.value;
        setFormData(newState);
    }

    const handleSubmit = (evt) => {
        evt.preventDefault();
        onFormSubmit(formData);
    }

    const onFormSubmit = function(){
        fetch("http://localhost:8080/shops/", {
            method: 'POST',
            body: JSON.stringify(formData),
            headers: {
              'Content-Type': 'application/json'
            }
        })
        // const request = new Request();
        // request.post("http://localhost:8080/shops/", formData)
        // .then(() => window.location = '/shops')
      }

    return(
        <div>
            <h3>Create New Profile</h3>
            <form>
                <div className="form_wrap">
                    <label htmlFor="name">Name:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="name"
                    id="name"
                    placeholder="Name"
                    value={formData.name}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="address">Address:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="address"
                    id="address"
                    placeholder="Address"
                    value={formData.address}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="postCode">Post Code:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="postCode"
                    id="postCode"
                    placeholder="Post Code"
                    value={formData.postCode}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="town">Town:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="town"
                    id="town"
                    placeholder="Town"
                    value={formData.town}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="openingHour">Opening Hour:</label>
                    <input
                    onChange={handleChange}
                    type="datetime-local"
                    name="openingHour"
                    id="openingHour"
                    value={formData.openingHour}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="closingHour">Closing Hour:</label>
                    <input
                    onChange={handleChange}
                    type="datetime-local"
                    name="closingHour"
                    id="closingHour"
                    value={formData.closingHour}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="telephoneNumber">Telephone Number:</label>
                    <input
                    onChange={handleChange}
                    type="number"
                    name="telephoneNumber"
                    id="telephoneNumber"
                    placeholder="Telephone Number"
                    value={formData.telephoneNumber}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="email">Email address:</label>
                    <input
                    onChange={handleChange}
                    type="email"
                    name="email"
                    id="email"
                    placeholder="Email"
                    value={formData.email}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="image">Image Link:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="image"
                    id="image"
                    placeholder="Image Link"
                    value={formData.image}
                    required/>
                </div>

                {/* <div className="form_wrap">
                    <label htmlFor="category">Category:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="category"
                    id="category"
                    placeholder="Category:"
                    value={formData.category}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="services">Services:</label>
                    <input
                    onChange={handleChange}
                    type="text"
                    name="services"
                    id="services"
                    placeholder="Services"
                    value={formData.services}
                    required/>
                </div> */}

                <input onClick={handleSubmit} type="submit" value="submit" />
            </form>
        </div>
    );

    // const [name, setName] = useState("");
    // const [address, setAddress] = useState("");
    // const [postCode, setPostCode] = useState("");
    // const [town, setTown] = useState("");
    // const [openingHour, setOpeningHour] = useState("");
    // const [closingHour, setClosingHour] = useState("");
    // const [telephoneNumber, setTelephoneNumber] = useState("");
    // const [email, setEmail] = useState("");
    // const [image, setImage] = useState("");
    // const [categories, setCategories] = useState("");
    // const [services, setServices] = useState("");

    // const handleNameChange = (evt) => {
    //     setName(evt.target.value);
    // }

    // const handleAddressChange = (evt) => {
    //     setAddress(evt.target.value);
    // }

    // const handlePostCodeChange = (evt) => {
    //     setPostCode(evt.target.value);
    // }

    // const handleTownChange = (evt) => {
    //     setTown(evt.target.value);
    // }

    // const handleOpeningHourChange = (evt) => {
    //     setOpeningHour(evt.target.value);
    // }

    // const handleClosingHourChange = (evt) => {
    //     setClosingHour(evt.target.value);
    // }

    // const handleTelephoneNumberChange = (evt) => {
    //     setTelephoneNumber(evt.target.value);
    // }

    // const handleEmailChange = (evt) => {
    //     setEmail(evt.target.value);
    // }

    // const handleImageChange = (evt) => {
    //     setImage(evt.target.value);
    // }

    // const handleCategoriesChange = (evt) => {
    //     setCategories(evt.target.value);
    // }

    // const handleServicesChange = (evt) => {
    //     setServices(evt.target.value);        
    // }

    // const handleSubmit = (evt) => {
    //     evt.preventDefault();
    //     const nameToSubmit = name.trim();
    //     const addressToSubmit = address.trim();
    //     const postCodeToSubmit = postCode.trim();
    //     const townToSubmit = town.trim();
    //     const openingHourToSubmit = openingHour.trim();
    //     const closingHourToSubmit = closingHour.trim();
    //     const telephoneNumberToSubmit = telephoneNumber.trim();
    //     const emailToSubmit = email.trim();
    //     const imageToSubmit = image.trim();
    //     const categoriesToSubmit = categories.trim();
    //     const servicesToSubmit = services.trim();

    //     if(!nameToSubmit || !addressToSubmit || !postCodeToSubmit 
    //         || !townToSubmit || !openingHourToSubmit || !closingHourToSubmit 
    //         || !telephoneNumberToSubmit || !emailToSubmit || !imageToSubmit 
    //         || !categoriesToSubmit || !servicesToSubmit) {
    //             return;
    //         }
    //         onFormSubmit({
    //             name: nameToSubmit,
    //             address: addressToSubmit,
    //             postCode: postCodeToSubmit,
    //             town: townToSubmit,
    //             openingHour: openingHourToSubmit,
    //             closingHour: closingHourToSubmit,
    //             telephoneNumber: telephoneNumberToSubmit,
    //             email: emailToSubmit,
    //             image: imageToSubmit,
    //             categories: categoriesToSubmit,
    //             services: servicesToSubmit
    //         })
    //         setName("");
    //         setAddress("");
    //         setPostCode("");
    //         setTown("");
    //         setOpeningHour("");
    //         setClosingHour("");
    //         setTelephoneNumber("");
    //         setEmail("");
    //         setImage("");
    //         setCategories("");
    //         setServices("");
    // }

    // return(
    //     <div>
    //         <h3>Create New Profile</h3>
    //         <form className="new-shop-form" onSubmit={handleSubmit}>

    //             <input type="text"
    //             placeholder="Name"
    //             value={name}
    //             onChange={handleNameChange}/>

    //             <input type="text"
    //             placeholder="Address"
    //             value={address}
    //             onChange={handleAddressChange}/>

    //             <input type="text"
    //             placeholder="Post Code"
    //             value={postCode}
    //             onChange={handlePostCodeChange}/>

    //             <input type="text"
    //             placeholder="Town"
    //             value={town}
    //             onChange={handleTownChange}/>

    //             <label>Opening Hour</label>
    //             <input type="time"
    //             value={openingHour}
    //             onChange={handleOpeningHourChange}/>

    //             <label>Closing Hour</label>
    //             <input type="time"
    //             value={closingHour}
    //             onChange={handleClosingHourChange}/>

    //             <input type="number"
    //             placeholder="Telephone Number"
    //             value={telephoneNumber}
    //             onChange={handleTelephoneNumberChange}/>

    //             <input type="text"
    //             placeholder="Email"
    //             value={email}
    //             onChange={handleEmailChange}/>

    //             <input type="text"
    //             placeholder="Image"
    //             value={image}
    //             onChange={handleImageChange}/>

    //             <input type="text"
    //             placeholder="Categories"
    //             value={categories}
    //             onChange={handleCategoriesChange}/>

    //             <input type="text"
    //             placeholder="Services"
    //             value={services}
    //             onChange={handleServicesChange}/>

    //             <input type="submit"
    //             value="submit"/>
    //         </form>
            
    //     </div>
    // )
}

export default NewShopForm;