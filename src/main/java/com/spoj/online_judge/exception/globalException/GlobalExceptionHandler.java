package com.spoj.online_judge.exception.globalException;

import com.spoj.online_judge.exception.ErrorResponseDto;
import com.spoj.online_judge.exception.customExceptiom.ProblemNotFoundException;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFoundException(UserNotFoundException ex){
        ErrorResponseDto errorResponse = new ErrorResponseDto(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ProblemNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleProblemNotFoundException(ProblemNotFoundException ex){
        ErrorResponseDto errorResponse = new ErrorResponseDto(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
