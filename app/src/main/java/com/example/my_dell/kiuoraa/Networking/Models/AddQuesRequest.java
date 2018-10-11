package com.example.my_dell.kiuoraa.Networking.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddQuesRequest {
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("ques_id")
    @Expose
    private Integer question_id;
    @SerializedName("uniq_id")
    @Expose
    private Integer uniq_id;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Integer getUniq_id() {
        return uniq_id;
    }

    public void setUniq_id(Integer uniq_id) {
        this.uniq_id = uniq_id;
    }
}
