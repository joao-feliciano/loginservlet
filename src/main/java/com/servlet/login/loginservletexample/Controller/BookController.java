package com.servlet.login.loginservletexample.Controller;

import com.servlet.login.loginservletexample.DAO.BookDAO;
import com.servlet.login.loginservletexample.Model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet({"/book", "/books", "/addBook", "/editBook", "/deleteBook"})
public class BookController extends HttpServlet {
    private BookDAO bookDAO;

    public void init() {
        bookDAO = new BookDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/addBook":
                addBook(request, response);
                break;
            case "/editBook":
                editBook(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/books":
                listBooks(request, response);
                break;
            case "/deleteBook":
                deleteBook(request, response);
                break;
        }
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Double price = Double.parseDouble(request.getParameter("price"));

        Book newBook = new Book(title, author, price);
        bookDAO.save(newBook);
        response.sendRedirect("books");
    }

    private void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        Double price = Double.parseDouble(request.getParameter("price"));

        Book book = new Book(id, title, author, price);
        bookDAO.update(book);
        response.sendRedirect("books");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Book book = bookDAO.findById(id.intValue());
        bookDAO.delete(book);
        response.sendRedirect("books");
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookDAO.findAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("listBooks.jsp").forward(request, response);
    }
}
