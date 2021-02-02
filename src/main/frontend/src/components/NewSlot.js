import React, {useState} from "react";

function NewSlot() {
    const [formData, setFormData] = useState({
        startTime: '',
        endTime: ''
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
        fetch("http://localhost:8080/slots/", {
            method: 'POST',
            body: JSON.stringify(formData),
            headers: {
              'Content-Type': 'application/json'
            }
        })
        // .then(() => window.location = "/slot")
    }
    
    return(
        <div>
            <h3>Create New Time Slot</h3>
            <form>
                <div className="form_wrap">
                    <label htmlFor="startTime">Start Time:</label>
                    <input 
                    onChange={handleChange}
                    type="time"
                    name="startTime"
                    id="startTime"
                    value={formData.startTime}
                    required/>
                </div>

                <div className="form_wrap">
                    <label htmlFor="endTime">End Time:</label>
                    <input 
                    onChange={handleChange}
                    type="time"
                    name="endTime"
                    id="endTime"
                    value={formData.endTime}
                    required/>
                </div>

                <input onClick={handleSubmit} type="submit" value="submit" />
            </form>
        </div>
    )
    
}

export default NewSlot;