/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jokes.entities;

/**
 *
 * @author Fernando
 */
public class Joke {
    private String desc;
    private String answer;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Joke(String desc, String answer) {
        this.desc = desc;
        this.answer = answer;
    }
    
    
    
}
