package com.bruno.libraryapi.model;

import com.bruno.libraryapi.api.repositories.BookRepository;
import com.bruno.libraryapi.model.entities.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("Deve retornar verdadeiro quando existir um livro no BD com o isbn informado")
    public void returnTrueWhenIsbnExists() {
        //cenario
        String isbn = "123";

        //execucao
        boolean exists = bookRepository.existsByIsbn(isbn);

        //verificacao
        Assertions.assertThat(exists).isFalse();
    }

    @Test
    @DisplayName("Deve retornar falso quando não existir um livro no BD com o isbn infromado")
    public void returnFalseWhenIsbnDoesntExists() {

    }
}
