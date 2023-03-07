package com.metsoft.myapp.repository;

import com.metsoft.myapp.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom{
    private MongoTemplate mongoTemplate;

    @Autowired
    public BookRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Book> findByCategoryAndPrice(String category, double minPrice, double maxPrice) {
        Query query = new Query();
        query.addCriteria(Criteria.where("category").is(category));
        query.addCriteria(Criteria.where("price").lte(maxPrice).gte(minPrice));
        return mongoTemplate.find(query,Book.class);
    }

    @Override
    public Page<Book> findAllWithMongoTemplate(int page, int offset) {
        Pageable pageable= PageRequest.of(page,offset);
        Query query=new Query().with(pageable);
        List<Book> books=mongoTemplate.find(query,Book.class);
        return PageableExecutionUtils.getPage(
                books,
                pageable,
                ()->mongoTemplate.count(Query.of(query).limit(-1).skip(-1),Book.class));
    }


}
