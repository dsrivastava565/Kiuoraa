package com.example.my_dell.kiuoraa.Networking.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("message")
    @Expose
    private String msg;

    @SerializedName("uniq_id")
    @Expose
    private Integer uniq_id;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getUniq_id() {
        return uniq_id;
    }

    public void setUniq_id(Integer uniq_id) {
        this.uniq_id = uniq_id;
    }
}
