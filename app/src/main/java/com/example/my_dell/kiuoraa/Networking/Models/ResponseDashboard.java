package com.example.my_dell.kiuoraa.Networking.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDashboard {
    @SerializedName("ques")
    @Expose
    private Ques ques;
    @SerializedName("answer")
    @Expose
    private List<Answer> answer = null;

    public Ques getQues() {
        return ques;
    }

    public void setQues(Ques ques) {
        this.ques = ques;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
