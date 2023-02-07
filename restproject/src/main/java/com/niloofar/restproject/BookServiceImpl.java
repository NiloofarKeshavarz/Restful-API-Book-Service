package com.niloofar.restproject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.niloofar.restproject.model.Book;

@Service
public class BookServiceImpl implements BookService {
	Map<Long, Book> books = new HashMap<>();
	long currentId = 101;

	// constructor
	public BookServiceImpl() {
		init();
	}

	void init() {
		Book book = new Book();
		book.setId(currentId);
		book.setTitle("Strangers");
		books.put(book.getId(), book);
	}

	@Override
	public List<Book> getBooks() {
		Collection<Book> results = books.values();
		List<Book> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Book getBook(Long id) {
		return books.get(id);
	}

	@Override
	public Response createBook(Book book) {
		book.setId(++currentId);
		books.put(book.getId(), book);
		return Response.ok(book).build();
	}

	@Override
	public Response updateBook(Book book) {
		Book currentBook = books.get(book.getId());

		Response response;
		if (currentBook != null) {
			books.put(book.getId(), book);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteBook(Long id) {
		Book book = books.get(id);

		Response response;
		if (book != null) {
			books.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;

	}

}
