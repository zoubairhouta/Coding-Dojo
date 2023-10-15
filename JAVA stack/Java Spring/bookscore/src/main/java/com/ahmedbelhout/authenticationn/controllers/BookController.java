package com.ahmedbelhout.authenticationn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ahmedbelhout.authenticationn.models.Book;
import com.ahmedbelhout.authenticationn.models.Publisher;
import com.ahmedbelhout.authenticationn.models.User;
import com.ahmedbelhout.authenticationn.services.BookService;
import com.ahmedbelhout.authenticationn.services.PublisherService;
import com.ahmedbelhout.authenticationn.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private PublisherService pubServ;
	@Autowired
	private UserService userServ;

	// View Route - Show all the Books
	@GetMapping("/books")
	public String allBooks(Model model, @ModelAttribute("book") Book book) {
		// grab all the books from db
		List<Book> allBooks = bookService.findAll();
		model.addAttribute("listOfBooks", allBooks);
		// grab all the publishers from db
		List<Publisher> allPubs = pubServ.findAll();
		model.addAttribute("allPubs", allPubs);
		return "book/books.jsp";
	}

	// Action Route - Create a Book
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			// grab all the books from db
			List<Book> allBooks = bookService.findAll();
			model.addAttribute("listOfBooks", allBooks);
			// grab all the publishers from db
			List<Publisher> allPubs = pubServ.findAll();
			model.addAttribute("allPubs", allPubs);
			return "book/books.jsp";
		} else {
			// Grab the user id from the session
			Long userID = (Long) session.getAttribute("user_id");
			// fetch the user by id from db
			User loggedInUser = userServ.findById(userID);
			// set the current user a the author
			book.setAuthor(loggedInUser);
			// save the book to DB
			bookService.createBook(book);
			return "redirect:/books";
		}

	}

	// View Route - Edit a Book
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		// find the book with the provided id
		Book thisBook = bookService.findBook(id);
		model.addAttribute("book", thisBook);
//		System.out.println(thisBook.getId());
		return "book/edit.jsp";
	}

	// Action Route -- EDIT a BOOK
	@PutMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "book/edit.jsp";
		} else {
			// grab the book from DB
			Book oldBook = bookService.findBook(book.getId());
			// set the old Publisher to the new updated book
			book.setPublisher(oldBook.getPublisher());
			
			// Grab the user id from the session
//			Long userID = (Long) session.getAttribute("user_id");
//			// fetch the user by id from db
//			User loggedInUser = userServ.findById(userID);
			// set the current user a the author
			book.setAuthor(oldBook.getAuthor());
			// if there are no errors, update the book
			bookService.updateBook(book);
			return "redirect:/books";
		}

	}

	// Action Route - DELETE
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

	// View Route - Display One Book
	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		// grab the specified book object
		Book selectedBook = bookService.findBook(id);
		model.addAttribute("book", selectedBook);
		return "book/oneBook.jsp";
	}

}