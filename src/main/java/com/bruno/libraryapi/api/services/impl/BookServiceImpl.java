package com.bruno.libraryapi.api.services.impl;

import com.bruno.libraryapi.api.repositories.BookRepository;
import com.bruno.libraryapi.api.services.BookService;
import com.bruno.libraryapi.exceptions.BusinessException;
import com.bruno.libraryapi.model.entities.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        if(bookRepository.existsByIsbn(book.getIsbn())) {
            throw new BusinessException("isbn duplicado");
        }
        return bookRepository.save(book);
    }
}
