package org.skypro.JavaExam.javaExam.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.skypro.JavaExam.javaExam.exception.QuestionError;
import org.skypro.JavaExam.javaExam.exception.MathQuestionMethodNotAllowedException;
import org.skypro.JavaExam.javaExam.exception.TooManyQuestionsRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExamAdvice {
    @ExceptionHandler(TooManyQuestionsRequestException.class)
    public ResponseEntity<QuestionError> handleTooManyQuestionsRequestException(TooManyQuestionsRequestException ex, HttpServletRequest request) {
        QuestionError error = new QuestionError(ex.getStatus(), ex.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(MathQuestionMethodNotAllowedException.class)
    public ResponseEntity<QuestionError> handleMathQuestionMethodNotAllowedException(MathQuestionMethodNotAllowedException ex, HttpServletRequest request) {
        QuestionError error = new QuestionError(ex.getStatus(), ex.getMessage(), request.getRequestURI());

        return new ResponseEntity<>(error, ex.getStatus());
    }
}