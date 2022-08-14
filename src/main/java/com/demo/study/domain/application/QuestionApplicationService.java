package com.demo.study.domain.application;

import com.demo.study.domain.application.command.CreateQuestionCommand;
import com.demo.study.domain.application.result.QuestionCreateResult;
import com.demo.study.domain.model.Question;
import com.demo.study.domain.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionApplicationService {

    private final QuestionRepository questionRepository;

    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionCreateResult createQuestion(CreateQuestionCommand command) {
        Question question = new Question(command.questionId(), command.title(), command.detail());
        questionRepository.save(question);
        return new QuestionCreateResult(question.getId());
    }
}
