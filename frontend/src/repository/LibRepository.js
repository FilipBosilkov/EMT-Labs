import axios from '../custom_axios/axios';

const LibService = {
    fetchBooks: () =>
    {
        return axios.get("http://localhost:8080/books/list");
    },
    fetchCategories: () =>
    {
        return axios.get("http://localhost:8080/categories");
    },
    fetchAuthors: () =>
    {
        return axios.get("http://localhost:8080/authors/list");
    },
    deleteBook: (id) => {
        return axios.delete(`http://localhost:8080/books/delete/${id}`);
    },
    addBook: (name,category,author,availableCopies) => {
        return axios.post("http://localhost:8080/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },
    editBook: (id,name,category,author,availableCopies) => {
      return axios.put(`http://localhost:8080/books/edit/${id}`, {
          "name" : name,
          "category" : category,
          "author" : author,
          "availableCopies" : availableCopies
      });
    },
    getBook: (id)=>
    {
        return axios.get(`http://localhost:8080/books/${id}`);
    },
    markBook: (id)=>
    {
        return axios.put(`http://localhost:8080/books/mark/${id}`)
    }
}

export default LibService;
