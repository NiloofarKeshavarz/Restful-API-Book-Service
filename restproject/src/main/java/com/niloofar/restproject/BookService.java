package com.niloofar.restproject;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.niloofar.restproject.model.Book;

// all the CRUD operations come here.
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/bookservice")
public interface BookService {
	
	// map it to URL pattern
	@Path("/books")
	@GET //HTTP method
	public List<Book> getBooks(); //shows a list of books with all values got by getBook method
	
	@Path("/books/{id}")
	@GET
	Book getBook(@PathParam("id") Long id);
	
	
	@Path("/books")
	@POST
	Response createBook(Book book);
	
	@Path("/books")
	@PUT
	Response updateBook(Book book);
	
	@Path("/books/{id}")
	@DELETE
	Response deleteBook(@PathParam("id") Long id);
	
	
	
}
