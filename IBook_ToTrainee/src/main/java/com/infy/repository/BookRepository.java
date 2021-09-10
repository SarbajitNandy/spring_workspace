package com.infy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	List<Book> findByAuthorName(String authorName);
	List<Book> findByPriceGreaterThanEqual(Integer price);
	List<Book> findByPriceLessThan(Integer price);
	List<Book> findByPublishedYearBetween(LocalDate from, LocalDate to);
	List<Book> findByPublishedYearAfter(LocalDate from);
	List<Book> findByAuthorNameAndPublisher(String authorName, String publisher);
}