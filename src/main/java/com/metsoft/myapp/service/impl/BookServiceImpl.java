package com.metsoft.myapp.service.impl;

import com.metsoft.myapp.model.Book;
import com.metsoft.myapp.repository.BookRepository;
import com.metsoft.myapp.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) throws Exception {
        return bookRepository.findById(id).orElseThrow(()->new Exception("Not found"));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByCategoryAndPrice(String category, double minPrice, double maxPrice) {
        return bookRepository.findByCategoryAndPrice(category,minPrice,maxPrice);
    }

    @Override
    public Page<Book> findAllBookWithPage(int page, int offset) {
        return bookRepository.findAll(PageRequest.of(page,offset));
    }

    @Override
    public Page<Book> findAllMongo(int page, int offset) {
        return bookRepository.findAllWithMongoTemplate(page,offset);
    }
}
