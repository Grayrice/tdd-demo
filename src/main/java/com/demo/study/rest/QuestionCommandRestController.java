package com.demo.study.rest;

import com.demo.study.domain.application.QuestionApplicationService;
import com.demo.study.domain.application.command.CreateQuestionCommand;
import com.demo.study.domain.application.result.QuestionCreateResult;
import com.demo.study.rest.request.CreateQuestionRequest;
import com.demo.study.rest.response.QuestionCreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionCommandRestController {

    private final QuestionApplicationService questionApplicationService;

    public QuestionCommandRestController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @PostMapping("/create-question")
    public QuestionCreateResponse createQuestion(@RequestBody CreateQuestionRequest request) {
        CreateQuestionCommand command = new CreateQuestionCommand(request.questionId(), request.title(), request.detail());
        QuestionCreateResult result = questionApplicationService.createQuestion(command);
        return new QuestionCreateResponse(result.questionId());
    }
}
