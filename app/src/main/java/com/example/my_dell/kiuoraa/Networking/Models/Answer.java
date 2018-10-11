package com.example.my_dell.kiuoraa.Networking.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("added_by__name")
    @Expose
    private String addedByName;
    @SerializedName("added_by__gender")
    @Expose
    private String addedByGender;
    @SerializedName("upvote")
    @Expose
    private Object upvote;
    @SerializedName("downvote_by")
    @Expose
    private Object downvoteBy;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAddedByName() {
        return addedByName;
    }

    public void setAddedByName(String addedByName) {
        this.addedByName = addedByName;
    }

    public String getAddedByGender() {
        return addedByGender;
    }

    public void setAddedByGender(String addedByGender) {
        this.addedByGender = addedByGender;
    }

    public Object getUpvote() {
        return upvote;
    }

    public void setUpvote(Object upvote) {
        this.upvote = upvote;
    }

    public Object getDownvoteBy() {
        return downvoteBy;
    }

    public void setDownvoteBy(Object downvoteBy) {
        this.downvoteBy = downvoteBy;
    }

}
