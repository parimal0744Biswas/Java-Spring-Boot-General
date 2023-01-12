package com.parimal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalExceptionHandler
{
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<MyErrorDetails> studentExceptionHandler(StudentException be, WebRequest req)
	{
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), be.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CourseException.class)
	public ResponseEntity<MyErrorDetails> courseExceptionHandler(CourseException be, WebRequest req)
	{
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), be.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumetHandler(MethodArgumentNotValidException me, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(),
				me.getBindingResult().getFieldError().getDefaultMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> notfoundHandler(NoHandlerFoundException nof, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(), nof.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> illigalArgumetHandler(IllegalArgumentException ee, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genaralExceptionHandler(Exception e, WebRequest req)
	{
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setName(e.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}
