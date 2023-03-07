package com.metsoft.myapp.repository;

import com.metsoft.myapp.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookRepositoryCustom {
    List<Book> findByCategoryAndPrice(String category,double minPrice,double maxPrice);
    Page<Book> findAllWithMongoTemplate(int page, int offset);
}
