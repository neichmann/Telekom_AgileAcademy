import React from 'react';

let BookComponent = (props) => {
    if (props.detail){
        return (
            <div>
                <p className={props.className}>ISBN: {props.book.isbn}, Title:  {props.book.title}, Price: {props.book.price}, Available: {props.book.available?'yes':'no'}</p>
            </div>
        );
    }
    else{
        return (
            <p className={props.className}>{props.book.isbn}={props.book.title}</p>
        );
    }
}

export default BookComponent 