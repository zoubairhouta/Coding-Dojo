package com.ahmedbelhout.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmedbelhout.mvc.models.Book;
import com.ahmedbelhout.mvc.services.BookService;

@Controller
public class BookController {
	  private BookService bookService;
	    public BookController(BookService bookService){
	        this.bookService = bookService;
	    }

//Read One
	 @RequestMapping("/books/{bookId}")
	 public String index(Model model,@PathVariable("bookId") Long bookId)
	 
	 {
		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
		System.out.println(book);
		model.addAttribute("book",book);
		 return "show.jsp";
	 }
	 
	 
	 //Read All
	 @RequestMapping("/books")
	 public String mouka(Model model) {
		 List<Book> books  = bookService.allBooks();
		 model.addAttribute("books",books);
		 
		return "/books/index.jsp";
		 
	 }
	
	
}
