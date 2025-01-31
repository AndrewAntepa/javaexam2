package org.skypro.JavaExam.javaExam.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.skypro.JavaExam.javaExam.interfaces.QuestionRepository;
import org.skypro.JavaExam.javaExam.question.Question;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final List<Question> questions = new ArrayList<>();

    public JavaQuestionRepository() {
        fillQuestions();
    }
    @Override
    public void add(Question question) {
        if (questions.contains(question)) {
            return;
        }
        questions.add(question);
    }

    @Override
    public void remove(Question question) {
        if (!questions.contains(question)) {
            throw new IllegalArgumentException("Такого примера нет");
        }
        questions.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    private void fillQuestions() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions/questions.json");
        if (inputStream == null) {
            throw new RuntimeException("Файл не найден!");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questionsJSON;
        try {
            questionsJSON = objectMapper.readValue(inputStream, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        questions.addAll(questionsJSON);
    }
}