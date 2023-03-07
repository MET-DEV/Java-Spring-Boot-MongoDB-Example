package com.metsoft.myapp.repository;

import com.metsoft.myapp.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends MongoRepository<Book,String> , BookRepositoryCustom{
    @Override
    Page<Book> findAll(Pageable pageable);
}
