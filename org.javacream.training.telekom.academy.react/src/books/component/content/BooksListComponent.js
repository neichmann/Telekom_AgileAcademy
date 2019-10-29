import React from 'react';
import BookComponent from './BookComponent'

let BooksListComponent = (props) => {
    let booksHtml = props.booksList.map((b) =>
    <BookComponent key={b.isbn} book={b} detail={true}/>)
    return (
          <div>
            <h3>Books List</h3>
            <div><ol>{booksHtml}</ol></div>
          </div>
        )
} 

export default BooksListComponent