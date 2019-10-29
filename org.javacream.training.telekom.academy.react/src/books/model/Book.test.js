import {Book} from  './Person'
test('create book and check title', () => {
    const expected_title = "Spring"
    let book = new Book("ISBN1", expected_title, 19.99, true)
    expect(book.title).toBe(expected_title);
})