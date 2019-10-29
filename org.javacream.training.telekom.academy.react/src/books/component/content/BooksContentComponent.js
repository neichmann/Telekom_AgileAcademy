import React, {Component} from 'react';
import {booksController} from '../../BooksContext' 
import BooksListComponent from './BooksListComponent'
import BookInputFormComponent from './BookInputFormComponent'
import BookSearchComponent from './BookSearchComponent';
import NavigationComponent from './NavigationComponent'
import {BrowserRouter, Switch, Route} from 'react-router-dom'

class BooksContentComponent extends Component{
    state = {books: []}
    createBookCallback = async (bookData) => {
        await booksController.createBook(bookData.title, bookData.price)
        this.updateBooksList()
    }
    componentDidMount = async () => {
        this.updateBooksList()
    }
    updateBooksList = async () => {
        let books = await booksController.allBooks()
        this.setState({books: books})
    }

    render (){
    return (<BrowserRouter>
            <NavigationComponent />
            <hr />       
            <Switch>
                    <Route path='/books' render={(props) => <BooksListComponent {...props} booksList={this.state.books} />} />    
                    <Route path='/bookInput' render={(props) => <BookInputFormComponent {...props} handleCreateBook={this.createBookCallback} />}/>    
                    <Route path='/bookSearch' component={BookSearchComponent}/>    
                </Switch>
           </BrowserRouter>
        )
    
}

}

export default BooksContentComponent