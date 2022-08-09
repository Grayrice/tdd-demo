package com.demo.study.domain.repository;

import com.demo.study.domain.model.Question;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void repository_should_successful_save_question() {
        Question question = new Question("uuid_question_001", "a test title", "a test detail");
        Question savedQuestion = questionRepository.save(question);
        assertThat(savedQuestion.getId(), Matchers.is(Matchers.notNullValue()));
        assertThat(savedQuestion.getQuestionId(), equalTo(question.getQuestionId()));
        assertThat(savedQuestion.getTitle(), equalTo(question.getTitle()));
        assertThat(savedQuestion.getDetail(), equalTo(question.getDetail()));
    }
}