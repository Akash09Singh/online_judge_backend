package com.spoj.online_judge.submission.pojo;

import java.util.List;

public class UserSubmission {
    private List<String> langEnum;
    private String lang;
    private String code;
    private String input;

    public List<String> getLangEnum() {
        return langEnum;
    }

    public void setLangEnum(List<String> langEnum) {
        this.langEnum = langEnum;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "UserSubmission{" +
                "langEnum=" + langEnum +
                ", lang='" + lang + '\'' +
                ", code='" + code + '\'' +
                ", input='" + input + '\'' +
                '}';
    }
}
