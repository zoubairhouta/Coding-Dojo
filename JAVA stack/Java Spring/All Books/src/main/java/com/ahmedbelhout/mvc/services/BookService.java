package com.ahmedbelhout.mvc.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ahmedbelhout.mvc.models.Book;
import com.ahmedbelhout.mvc.repositories.BookRepository;

@Service
public class BookService {
	 private final BookRepository bookRepository;
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    // update a book 
public Book updateBook(Book book, Long id) {
	Book depDB = bookRepository.findById(id).get();
	 if (Objects.nonNull(book.getTitle()) && !"".equalsIgnoreCase(book.getTitle())) {
         depDB.setTitle(book.getTitle());
     }

	 if (Objects.nonNull(book.getDescription()) && !"".equalsIgnoreCase(book.getDescription())) {
         depDB.setDescription(book.getDescription());
     }


	 if (Objects.nonNull(book.getLanguage()) && !"".equalsIgnoreCase(book.getLanguage())) {
         depDB.setLanguage(book.getLanguage());
     }

	 if (Objects.nonNull(book.getNumberOfPages()) ) {
         depDB.setNumberOfPages(book.getNumberOfPages());
     }


     return bookRepository.save(depDB);
			
		}

// delete operation

public void deleteBook(Long id) {
    bookRepository.deleteById(id);
}
}
