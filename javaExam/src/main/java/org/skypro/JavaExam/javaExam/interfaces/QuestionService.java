package org.skypro.JavaExam.javaExam.interfaces;

import org.skypro.JavaExam.javaExam.question.Question;

import java.util.Collection;

public interface QuestionService {
    void add(Question question);

    void add(String question, String answer);

    Collection<Question> getAll();

    void remove(Question question);

    Question getRandomQuestion();

    String getType();
}