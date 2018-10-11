package com.example.my_dell.kiuoraa.Networking.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Askquestion {
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("add_by")
    @Expose
    private Integer add_by;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAdd_by() {
        return add_by;
    }

    public void setAdd_by(Integer add_by) {
        this.add_by = add_by;
    }
}
