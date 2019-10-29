import PubSub from 'pubsub-js'
export default class BooksController{
    async allBooks() {
        try{
          let result = await fetch('http://localhost:8080/api/books')
          let books = await result.json()
          return books
        }
        catch(err){
          alert("Something went wrong: " + err)
        }
      
    }

    async findBookByIsbn(isbn)  {
        const url = `http://localhost:8080/api/books/${isbn}`
        let result = await fetch (url)
        let bookData = await result.json()
        PubSub.publish("books.search", `searched for book ${isbn}`)
        return bookData
      }
      async createBook(title, price)  {
        const url = `http://localhost:8080/api/books/${title}?price=${price}`
        let response = await fetch (url, {method:'POST'})
        let isbn = await response.text()
        PubSub.publish("books.create", `created book ${isbn}`)

      }
    
}