package com.demo.study.domain.repository;

import com.demo.study.domain.model.Question;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
class QuestionRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void repository_should_successful_save_question() {
        Question question = new Question("uuid_question_001", "a test title", "a test detail");
        Question savedQuestion = questionRepository.save(question);
        assertThat(savedQuestion.getId(), Matchers.is(Matchers.notNullValue()));
        assertSameQuestion(savedQuestion, question);
    }

    @Test
    void repository_should_successful_find_question_by_id(){
        Question question = new Question("uuid_question_001", "a test title", "a test detail");
        Question savedQuestion = questionRepository.saveAndFlush(question);
        entityManager.detach(savedQuestion);
        Question foundQuestion = questionRepository.findById(savedQuestion.getId()).orElseThrow(AssertionError::new);
        assertThat(foundQuestion.getId(), Matchers.is(Matchers.notNullValue()));
        assertSameQuestion(foundQuestion, savedQuestion);
    }

    private void assertSameQuestion(Question actualQuestion, Question expectedQuestion) {
        assertThat(actualQuestion.getQuestionId(), equalTo(expectedQuestion.getQuestionId()));
        assertThat(actualQuestion.getTitle(), equalTo(expectedQuestion.getTitle()));
        assertThat(actualQuestion.getDetail(), equalTo(expectedQuestion.getDetail()));
    }
}