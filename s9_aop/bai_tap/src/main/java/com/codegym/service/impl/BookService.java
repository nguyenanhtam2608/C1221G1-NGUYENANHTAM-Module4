package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override

    public String borrow(Book book) {
        if (book.getQuantity() == 0) {
            return "Hết sách ";
        } else {
            book.setQuantity(book.getQuantity() - 1);
            iBookRepository.save(book);
            return "Thành Công";
        }

    }


    @Override
    public void plus(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }

    @Override
    public String borrowError(Integer id) {
        if (findById(id).getQuantity() <= 0) {
            return "Hết sách";
        } else {
            findById(id).setQuantity(findById(id).getQuantity() - 1);
            iBookRepository.save(findById(id));
            return "Đã mượn";
        }

    }
}
