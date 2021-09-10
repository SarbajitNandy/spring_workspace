package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.BookDTO;
import com.infy.entity.Book;
import com.infy.exception.InfyBookException;
import com.infy.repository.BookRepository;
import com.infy.validator.Validator;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookDTO getBookDetails(Integer bookId) throws InfyBookException {
		Optional<Book> optional = bookRepository.findById(bookId);
		if (optional.isPresent()) {
			Book book = optional.orElseThrow(()-> new InfyBookException("Service.BOOK_DETAILS_NOT_FOUND"));
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			return bookDTO;
		} else {
			throw new InfyBookException("Service.BOOK_DETAILS_NOT_FOUND");
		}
		
	}

	@Override
	public void addBook(BookDTO bookDTO) throws InfyBookException {
		Validator validator = new Validator();
		try {
			validator.validate(bookDTO);
			Optional<Book> optional = bookRepository.findById(bookDTO.getBookId());
			if (optional.isPresent()) throw new InfyBookException("Service.BOOK_ALREADY_PRESENT");
			else {
				Book book = new Book();
				book.setBookId(bookDTO.getBookId());
				book.setAuthorName(bookDTO.getAuthorName());
				book.setIsbn(bookDTO.getIsbn());
				book.setPrice(bookDTO.getPrice());
				book.setPublishedYear(bookDTO.getPublishedYear());
				book.setPublisher(bookDTO.getPublisher());
				book.setTitle(bookDTO.getTitle());
				bookRepository.save(book);
			}
		} catch (InfyBookException e) {
			throw e;
		}
	}

	@Override
	public List<BookDTO> getBookByAuthorName(String authorName) throws InfyBookException {
		List<Book> bookList = bookRepository.findByAuthorName(authorName);
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for(Book book: bookList) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			bookDTOList.add(bookDTO);
		}
		
		if (bookDTOList.isEmpty()) throw new InfyBookException("Service.BOOK_NOT_FOUND");
		return bookDTOList;		
	}

	@Override
	public List<BookDTO> getBookGreaterThanEqualToPrice(Integer price) throws InfyBookException {
		List<Book> bookList = bookRepository.findByPriceGreaterThanEqual(price);
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for(Book book: bookList) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			bookDTOList.add(bookDTO);
		}
		
		if (bookDTOList.isEmpty()) throw new InfyBookException("Service.BOOK_NOT_FOUND");
		return bookDTOList;	
	}

	@Override
	public List<BookDTO> getBookLessThanPrice(Integer price) throws InfyBookException {
		List<Book> bookList = bookRepository.findByPriceLessThan(price);
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for(Book book: bookList) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			bookDTOList.add(bookDTO);
		}
		
		if (bookDTOList.isEmpty()) throw new InfyBookException("Service.BOOK_NOT_FOUND");
		return bookDTOList;	
	}

	@Override
	public List<BookDTO> bookPublishedBetweenYear(LocalDate startYear, LocalDate endYear) throws InfyBookException {
		List<Book> bookList = bookRepository.findByPublishedYearBetween(startYear, endYear);
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for(Book book: bookList) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			bookDTOList.add(bookDTO);
		}
		
		if (bookDTOList.isEmpty()) throw new InfyBookException("Service.BOOK_NOT_FOUND");
		return bookDTOList;	
	}

	@Override
	public List<BookDTO> bookPublishedAfterYear(LocalDate year) throws InfyBookException {
		List<Book> bookList = bookRepository.findByPublishedYearAfter(year);
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for(Book book: bookList) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			bookDTOList.add(bookDTO);
		}
		
		if (bookDTOList.isEmpty()) throw new InfyBookException("Service.BOOK_NOT_FOUND");
		return bookDTOList;	
	}

	@Override
	public List<BookDTO> getBookByAuthorNameAndPublisher(String authorName, String publisher) throws InfyBookException {
		List<Book> bookList = bookRepository.findByAuthorNameAndPublisher(authorName, publisher);
		List<BookDTO> bookDTOList = new ArrayList<>();
		
		for(Book book: bookList) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setBookId(book.getBookId());
			bookDTO.setAuthorName(book.getAuthorName());
			bookDTO.setIsbn(book.getIsbn());
			bookDTO.setPrice(book.getPrice());
			bookDTO.setPublishedYear(book.getPublishedYear());
			bookDTO.setPublisher(book.getPublisher());
			bookDTO.setTitle(book.getTitle());
			bookDTOList.add(bookDTO);
		}
		
		if (bookDTOList.isEmpty()) throw new InfyBookException("Service.BOOK_NOT_FOUND");
		return bookDTOList;	
	}

	@Override
	public void updateBookPrice(Integer bookId, Integer price) throws InfyBookException {
		Book book = null;
		Optional<Book> optional = bookRepository.findById(bookId);
		if (optional.isPresent()) {
			book = optional.orElseThrow(() -> new InfyBookException("Service.BOOK_NOT_FOUND"));
			book.setPrice(price);
		} else throw new InfyBookException("Service.BOOK_NOT_FOUND"); 
	}

	@Override
	public void deleteBook(Integer bookId) throws InfyBookException {
		Book book = null;
		Optional<Book> optional = bookRepository.findById(bookId);
		if (optional.isPresent()) {
			book = optional.orElseThrow(() -> new InfyBookException("Service.BOOK_NOT_FOUND"));
			bookRepository.delete(book);
		} else throw new InfyBookException("Service.BOOK_NOT_FOUND"); 
	}


	
}
