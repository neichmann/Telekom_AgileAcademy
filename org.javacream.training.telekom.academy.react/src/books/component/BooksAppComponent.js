import React from 'react'
import './Books.css'
import PeopleContentComponent from './content/BooksContentComponent'
import BooksHeaderComponent from './BooksHeaderComponent'
import BooksFooterComponent from './BooksFooterComponent'
function BooksAppComponent(){
    return (
        <>
            <BooksHeaderComponent />
            <PeopleContentComponent />
            <BooksFooterComponent />

        </>
    )
}

export default BooksAppComponent