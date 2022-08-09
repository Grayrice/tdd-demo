package com.demo.study.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String questionId;
    private String title;
    private String detail;

    public Question(String questionId, String title, String detail) {
        this.questionId = questionId;
        this.title = title;
        this.detail = detail;
    }

    protected Question() {

    }

    public String getId() {
        return id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }
}
