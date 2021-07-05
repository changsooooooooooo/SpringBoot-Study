package com.exceptionhandle.advice;

import com.exceptionhandle.controller.ApiController;
import com.exceptionhandle.dto.Error;
import com.exceptionhandle.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestControllerAdvice(basePackageClasses = ApiController.class)
public class GlobalControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e){
        System.out.println(e.getClass().getName());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNOtValidException(MethodArgumentNotValidException e){

        BindingResult bindingResult = e.getBindingResult();

        bindingResult.getAllErrors().forEach(
                error->{
                    FieldError fieldError = (FieldError) error;
                    String filedName = fieldError.getField();
                    String message = fieldError.getDefaultMessage();
                    String value = fieldError.getRejectedValue().toString();

                    System.out.println(filedName);
                    System.out.println(message);
                    System.out.println(value);
                }
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e, HttpServletRequest httpServletRequest){

        List<Error> errorList = new ArrayList<>();

        e.getConstraintViolations().forEach(
                error->{

                    Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);
                    List<Path.Node> list = stream.collect(Collectors.toList());

                    String field = list.get(list.size()-1).getName();
                    String message = error.getMessage();
                    String invalidValue = error.getInvalidValue().toString();

                    Error errorMessage = new Error();
                    errorMessage.setMessage(message);
                    errorMessage.setFiled(field);
                    errorMessage.setInvalidValue(invalidValue);

                    errorList.add(errorMessage);
                }
        );

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setMessage("");
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e){

        String filedName = e.getParameterName();
        String filedType = e.getParameterType();
        String invalidValue = e.getMessage();

        System.out.println(filedName);
        System.out.println(filedType);
        System.out.println(invalidValue);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
