package com.metsoft.myapp.api;

import com.metsoft.myapp.dto.CreateBookDto;
import com.metsoft.myapp.dto.GetBookDto;
import com.metsoft.myapp.model.Book;
import com.metsoft.myapp.service.interfaces.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BookService bookService;
    private final ModelMapper modelMapper;

    @Autowired
    public BooksController(BookService bookService, ModelMapper modelMapper) {
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("")
    public List<GetBookDto> getAll() {
        return bookService.findBooks().stream().map(
                book -> modelMapper.map(book,GetBookDto.class)
        ).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") String id) throws Exception {
        return bookService.findById(id);
    }
    @GetMapping("/pagination/repo")
    public Page<Book> findAllWithPage(@RequestParam(value = "page")int page,@RequestParam(value = "offset")int offset){
        return bookService.findAllBookWithPage(page,offset);
    }

    @GetMapping("/pagination/mongotemp")
    public Page<Book> findAllWithPageMongoTemplate(@RequestParam(value = "page")int page,@RequestParam(value = "offset")int offset){
        return bookService.findAllMongo(page,offset);
    }



    @PostMapping("")
    public Book save(@RequestBody CreateBookDto bookDto){
        return bookService.save(modelMapper.map(bookDto,Book.class));
    }
    @GetMapping("/findByPriceAndCategory")
    public ResponseEntity<List<Book>> getByCategoryAndPrice(@RequestParam(value = "category") String category,
                                                            @RequestParam(value = "minPrice") double minPrice,
                                                            @RequestParam(value = "maxPrice") double maxPrice){
        return new ResponseEntity<List<Book>>(bookService.findByCategoryAndPrice(category,minPrice,maxPrice), HttpStatus.OK);

    }
}
