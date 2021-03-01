/*
 * Copyright (C) 2021  Karan Kumar
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.  See the GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package com.karankumar.booksapi.datafetchers;

import com.karankumar.booksapi.model.Book;
import com.karankumar.booksapi.service.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class BookDataFetcher {
    private final BookService bookService;

    public BookDataFetcher(BookService bookService) {
        this.bookService = bookService;
    }

    @DgsData(parentType = "Query", field = "findAllBooks")
    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    @DgsData(parentType = "Query", field = "findBookByIsbn13")
    public Book findBookByIsbn13(@InputArgument("isbn13") String isbn13) {
        return bookService.findBookByIsbn13(isbn13);
    }

    @DgsData(parentType = "Query", field = "findByAuthor")
    public List<Book> findByAuthor(@InputArgument("firstName") String firstName,
                                   @InputArgument("lastName") String lastName) {
        return bookService.findByAuthor(firstName, lastName);
    }

    @DgsData(parentType = "Query", field = "findByTitleIgnoreCase")
    public Book findByTitle(@InputArgument("title") String title) {
        return bookService.findByTitle(title);
    }
}
