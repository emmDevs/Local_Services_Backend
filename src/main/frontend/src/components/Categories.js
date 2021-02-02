import React, {useState, useEffect} from 'react';
import { Link } from "react-router-dom";
import axios from 'axios';

function Categories() {

    const [categoryList, setCategoryList] = useState([]);

    const getCategoryList = () => {
        axios.get(`http://localhost:8080/categories/`)
        .then(res => {
          console.log(res);
          setCategoryList(res.data)
        });
      };
    
      useEffect(() => {
        getCategoryList();
      }, []);


    return(
        <div>
            <h3>Category Component</h3>
            <Link to="/new-category"><button className="btn">Add Category</button></Link>
            {categoryList
                ? categoryList.map((category, index) => {
                return(
                    <div key={index}>
                    <Link to={`/category/${category.id}`}><button>{category.name}</button></Link>
                    </div>
                );
                })
                : "Loading..."}
        </div>
    )
}

export default Categories;