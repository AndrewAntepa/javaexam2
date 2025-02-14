package org.skypro.JavaExam.javaExam.interfaces;

import org.skypro.JavaExam.javaExam.question.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getJavaQuestions(int amount);
    Collection<Question> getMathQuestions(int amount);
}