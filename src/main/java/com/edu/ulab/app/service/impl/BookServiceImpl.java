package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.entity.BookEntity;
import com.edu.ulab.app.mapper.BookMapperImpl;
import com.edu.ulab.app.service.BookService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Override
    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookMapperImpl().bookDtoToBookEntity(bookDto);
        bookEntity = Storage.bookEntityDAO.save(bookEntity);
        bookDto.setId(bookEntity.getId());
        return bookDto;
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Long userId) {
        BookEntity bookEntity = new BookMapperImpl().bookDtoToBookEntity(bookDto);
        bookEntity = Storage.bookEntityDAO.update(bookEntity,userId);
        bookDto.setId(bookEntity.getId());
        return bookDto;
    }

    @Override
    public List<BookDto> getBookById(Long id) {
        return Storage.bookEntityDAO.getUserBooks(id)
                .stream()
                .map(bookEntity -> new BookMapperImpl().bookEntityToBookDto(bookEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBookById(Long id) {
        Storage.bookEntityDAO.delete(id);
    }
}
