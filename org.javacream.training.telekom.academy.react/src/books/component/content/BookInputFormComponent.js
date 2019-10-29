import React, { Component } from 'react';

class BookInputFormComponent extends Component{
  state = {
    fields: {
      title: '',
      price: ''
    }
  }

  handleFormSubmit = (event) => {
    event.preventDefault();
    this.props.handleCreateBook(this.state.fields)
  }
  handleChange = (event) => {
    let target = event.target
    let result = this.state.fields
    result[target.name] = target.value
    this.setState({fields: result})
  }
  render(){
    return (
      <form onSubmit={this.handleFormSubmit}>
      <input placeholder="Title" name="title" value={this.state.fields.title} onChange={this.handleChange}></input>
      <input placeholder="Price" name="price" value={this.state.fields.price} onChange={this.handleChange}></input>
      <input type="submit" value="Create Book"/>
      </form>
    )
  }

}

export default BookInputFormComponent 