package com.foodApp.Exception;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.foodApp.UserLogin.exception.LoginException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
//	@ExceptionHandler(InvalidPasswordException.class)
//	public ResponseEntity<MyErrorMessage> handleCustomerPasswordException(InvalidPasswordException iun,WebRequest req){
//		
//		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(),iun.getMessage(),req.getDescription(false));
//		
//		return new ResponseEntity<MyErrorMessage>(message,HttpStatus.BAD_REQUEST);
//		
//	}

	
	//	Userlogin.exception's LoginException Handler
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorMessage> loginExpHandler(LoginException ie,WebRequest wr)  {
		
		System.out.println("Inside login exception handler");
		MyErrorMessage err = new MyErrorMessage(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorMessage>(err, HttpStatus.BAD_REQUEST);		
		
	}


	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorMessage> customerExpHandler(CustomerException ie,WebRequest wr)  {
		System.out.println("Inside customer exception handler");
		
		MyErrorMessage err = new MyErrorMessage(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		
		
	
	 return new ResponseEntity<MyErrorMessage>(err, HttpStatus.BAD_REQUEST);		
		
	}
	//to handle Not found exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorMessage> wrongUrl(NoHandlerFoundException nhf, WebRequest req){
		MyErrorMessage err = new MyErrorMessage(LocalDateTime.now(), nhf.getMessage(), req.getDescription(false));
		
		ResponseEntity<MyErrorMessage> responseEntity = new ResponseEntity<>(err, HttpStatus.BAD_GATEWAY);
		
		return responseEntity;
	}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<MyErrorMessage> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		
		MyErrorMessage err=new MyErrorMessage(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
		
	
//	@ExceptionHandler(UserAlreadyExistWithMobileNumber.class)
//	public ResponseEntity<MyErrorMessage> handleUserAlreadyExistWithMobileNumber(UserAlreadyExistWithMobileNumber uae,WebRequest req){
//		
//		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(),uae.getMessage(),req.getDescription(false));
//		
//		return new ResponseEntity<MyErrorMessage>(message,HttpStatus.BAD_REQUEST);
//		
//	}
	
	
	
	
	
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<MyErrorMessage> handleIndexOutOfBoundException(IndexOutOfBoundsException isa,WebRequest req){
		
		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(),"Please login first",req.getDescription(false));
		
		return new ResponseEntity<MyErrorMessage>(message,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorMessage> handleDataNotFountException(NotFoundException iun,WebRequest req){
		
		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(),iun.getMessage(),req.getDescription(false));
		
		return new ResponseEntity<MyErrorMessage>(message,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(BillNotFoundException.class)
	public ResponseEntity<MyErrorMessage> handleDataNotFountException(BillNotFoundException bfe,WebRequest req){

		MyErrorMessage message = new MyErrorMessage(LocalDateTime.now(),bfe.getMessage(),req.getDescription(false));

		return new ResponseEntity<MyErrorMessage>(message,HttpStatus.BAD_REQUEST);

	}
	

}
