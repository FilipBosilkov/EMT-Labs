import React from 'react';
import {Link} from "react-router-dom";
const header = (props) => {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark d-flex justify-content-center">
                <div className="d-flex">
                    <a className="navbar-brand" href="/books">Library Application</a>
                </div>
                <ul className="navbar-nav">
                    <li className="nav-item active">
                        <Link className="nav-link" to={"/books"}>Books</Link>
                    </li>
                    <li className="nav-item active">
                        <Link className="nav-link" to={"/categories"}>Categories</Link>
                    </li>
                </ul>
            </nav>
        </header>
    );
}

export default header;