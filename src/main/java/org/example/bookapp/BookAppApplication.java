package org.example.bookapp;

import java.math.BigDecimal;
import org.example.bookapp.model.Book;
import org.example.bookapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookAppApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = new Book();
                book.setTitle("Ракета на чотирьох лапах ");
                book.setAuthor("Джеремі Стронґ");
                book.setDescription("книга про пригоди");
                book.setPrice(BigDecimal.valueOf(45));
                book.setCoverImage("");
                book.setIsbn("");

                bookService.save(book);
                System.out.println(bookService.findAll());
            }
        };
    }
}
