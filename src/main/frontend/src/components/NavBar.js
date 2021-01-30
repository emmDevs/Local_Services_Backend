import React from "react";
import { Link } from "react-router-dom";

function NavBar() {
    return(
        <div>
            <Link to="/">Site Name/Logo</Link>

            <ul>
                <li>
                    <Link to="/about">About</Link>
                </li>
                <li>
                    <Link to="/business">Business</Link>
                </li>
                <li>
                    <Link to="/basket">Basket</Link>
                </li>
            </ul>
        </div>
    )
}

export default NavBar;