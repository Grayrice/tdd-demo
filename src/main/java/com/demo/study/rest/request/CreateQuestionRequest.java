package com.demo.study.rest.request;

public record CreateQuestionRequest(
        String questionId,
        String title,
        String detail
) {
}
