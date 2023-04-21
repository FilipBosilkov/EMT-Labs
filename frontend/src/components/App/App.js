import './App.css';
import React, { Component } from 'react';
import Books from '../Books/BookList/books';
import Categories from '../Categories/categories';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from '../Header/header';
import BookAdd from '../Books/BookAdd/BookAdd'
import BookEdit from '../Books/BookEdit/BookEdit'
import LibService from '../../repository/LibRepository';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        };
    }

    render() {
        return (
            <Router>
                <Header />
                <main>
                    <div className='container'>
                        <Routes>
                            <Route path='/books' element={<Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.getBook} onMark={this.markBook}/>} />
                            <Route path='/categories' element={<Categories categories={this.state.categories} />} />
                            <Route path={"/books/add"} element={<BookAdd categories={this.state.categories}
                                                     authors={this.state.authors}
                                                     onAddBook={this.addBook}/>} exact/>
                            <Route path={"/books/edit/:id"} element={<BookEdit categories={this.state.categories}
                                                                         authors={this.state.authors}
                                                                         onEditBook={this.editBook}
                                                                         book={this.state.selectedBook}/>} exact/>


                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }

    loadBooks = () => {
        LibService.fetchBooks().then((data) => {
            this.setState({
                books: data.data,
            });
        });
    };

    loadCategories = () => {
        LibService.fetchCategories().then((data) => {
            this.setState({
                categories: data.data,
            });
        });
    };


    loadAuthors = () => {
        LibService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    };

    deleteBook = (id) => {
        LibService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, category, author, availableCopies) => {
        LibService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }
    getBook = (id) =>
    {
        LibService.getBook(id).then((data)=>{
            this.setState({
                selectedBook: data.data
            })
        })
    }
    editBook = (id,name,category,author,availableCopies) => {
        LibService.editBook(id,name,category,author,availableCopies).then(()=>{this.loadBooks();});
    }
    markBook = (id) => {
        LibService.markBook(id)
            .then(() => {
                this.loadBooks();
            });
    }
    componentDidMount() {
        this.loadBooks();
        this.loadCategories();
        this.loadAuthors()
    }
}

export default App;
