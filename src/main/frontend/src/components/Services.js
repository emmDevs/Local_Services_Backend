import React, {useState, useEffect} from 'react';
import { Link } from "react-router-dom";
import axios from 'axios';

function Services() {

    const [serviceList, setServiceList] = useState([]);

    const getServiceList = () => {
        axios.get(`http://localhost:8080/services/`)
        .then(res => {
          console.log(res);
          setServiceList(res.data)
        });
      };
    
      useEffect(() => {
        getServiceList();
      }, []);


    return(
        <div>
            <h3>Service Component</h3>
            <Link to="/new-service"><button className="btn">Add Service</button></Link>
            {serviceList
                ? serviceList.map((service, index) => {
                return(
                    <div key={index}>
                    <Link to={`/service/${service.id}`}><button>{service.name}</button></Link>
                    </div>
                );
                })
                : "Loading..."}
        </div>
    )
}

export default Services;