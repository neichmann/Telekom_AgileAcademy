import React, { Component } from 'react';
import {booksController} from '../../BooksContext'
class BookSearchComponent extends Component{
  state = {
    fields: {
      isbn: ''
    }
  }

  handleClick = async (event) => {
    let book = await booksController.findBookByIsbn(this.state.fields.isbn)
    this.setState({...this.state, ...{book: book.title}})
    

  }
  handleChange = (event) => {
    let target = event.target
    let result = this.state.fields
    result[target.name] = target.value
    this.setState({fields: result})
  }
  render(){
    return (
      <>
      <input placeholder="ISBN" name="isbn" value={this.state.fields.isbn} onChange={this.handleChange}></input>
      <button onClick={this.handleClick}>Search</button>
      <p>{this.state.book}</p>
      </>
    )
  }

}

export default BookSearchComponent 