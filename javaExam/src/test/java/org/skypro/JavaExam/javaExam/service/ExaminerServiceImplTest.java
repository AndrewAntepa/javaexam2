package org.skypro.JavaExam.javaExam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.JavaExam.javaExam.exception.TooManyQuestionsRequestException;
import org.skypro.JavaExam.javaExam.interfaces.QuestionService;
import org.skypro.JavaExam.javaExam.question.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService javaQuestionService;

    @Mock
    private QuestionService mathQuestionService;

    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        when(javaQuestionService.getType()).thenReturn("java");

        examinerService = new ExaminerServiceImpl(List.of(javaQuestionService, mathQuestionService));
    }

    @Test
    void getJavaQuestions_ShouldThrowException_WhenAmountTooHigh() {
        when(javaQuestionService.getAll()).thenReturn(List.of());
        assertThrows(TooManyQuestionsRequestException.class, () -> examinerService.getJavaQuestions(23));
    }

    @Test
    void getMathQuestions_ShouldReturnRequestedAmount() {
        when(mathQuestionService.getRandomQuestion()).thenReturn(new Question("random question", "random answer"));
        assertEquals(1, examinerService.getMathQuestions(1).size());
    }
}