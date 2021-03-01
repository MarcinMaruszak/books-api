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

package com.karankumar.booksapi;

import com.karankumar.booksapi.model.Author;
import com.karankumar.booksapi.model.Book;
import com.karankumar.booksapi.model.BookFormat;
import com.karankumar.booksapi.model.BookGenre;
import com.karankumar.booksapi.model.Language;
import com.karankumar.booksapi.model.PublisherName;
import com.karankumar.booksapi.repository.AuthorRepository;
import com.karankumar.booksapi.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BooksApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner populateData(AuthorRepository authorRepository,
                                          BookRepository bookRepository) {
        return args -> {
            Author author = new Author("J.K.", "Rowling");
            author.setAbout("A fantastic author");
            authorRepository.save(author);

            Book book1 = new Book(
                    "Harry Potter and the Philosopher's stone",
                    new Author[] {author},
                    Language.ENGLISH,
                    "Sample blurb value",
                    BookGenre.FANTASY,
                    BookFormat.PAPERBACK
            );
            book1.setYearOfPublication(1997);
            book1.setIsbn13("9781408810545");
            book1.setPublisher(PublisherName.BLOOMSBURY);
            bookRepository.save(book1);

            Book book2 = new Book(
                    "Harry Potter and the Chamber of Secrets",
                    new Author[] {author},
                    Language.ENGLISH,
                    "Sample blurb value",
                    BookGenre.FANTASY,
                    BookFormat.PAPERBACK
            );
            book2.setIsbn13("1234567898765");
            book2.setGenre(BookGenre.FANTASY);
            book2.setPublisher(PublisherName.BLOOMSBURY);
            book2.setFormat(BookFormat.PAPERBACK);
            bookRepository.save(book2);

            Author author2 = new Author("J.R.R.", "Tolkien");
            author2.setAbout("Another fantastic author");
            authorRepository.save(author2);
            Book book3 = new Book(
                    "The Hobbit",
                    new Author[] {author, author2},
                    Language.ENGLISH,
                    "Sample blurb value",
                    BookGenre.FANTASY,
                    BookFormat.PAPERBACK
            );
            book3.setYearOfPublication(1937);
            book3.setPublisher(PublisherName.HARPER_COLLINS);
            bookRepository.save(book3);
        };
    }
}
