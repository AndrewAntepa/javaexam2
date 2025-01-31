package org.skypro.JavaExam.javaExam.interfaces;

import org.skypro.JavaExam.javaExam.question.Question;

import java.util.Collection;

public interface QuestionRepository {
    void add(Question question);
    void remove(Question question);
    Collection<Question> getAll();
}