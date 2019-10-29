import React from 'react'
import {Link} from 'react-router-dom'

const NavigationComponent = (props) => {
    return (
        <>
            <div><Link to="/">Home</Link></div>
            <div><Link to="/books">Books List</Link></div>
            <div><Link to="/bookInput">Create new Book</Link></div>   
            <div><Link to="/bookSearch">Search Book</Link></div>
        </>
        )
}

export default NavigationComponent