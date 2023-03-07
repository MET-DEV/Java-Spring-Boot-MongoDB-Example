package com.metsoft.myapp.service.interfaces;

import com.metsoft.myapp.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Book> findBooks();
    Book findById(String id) throws Exception;
    Book save(Book book);
    List<Book> findByCategoryAndPrice(String category, double minPrice,double maxPrice);
    Page<Book> findAllBookWithPage(int page, int offset);

    Page<Book> findAllMongo(int page, int offset);
}
