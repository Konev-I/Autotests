package org.test.pages.wrappers;

import java.util.ArrayList;

public class NewNoteBuilder {
    private String header = null;
    private String text = null;
    private String quizQuestion = null;
    private ArrayList<String> answers = null;

    public NewNoteBuilder addText(String newText){
        text = newText;
        return this;
    }

    public NewNoteBuilder addHeader(String newHeader){
        header = newHeader;
        return this;
    }

    public NewNoteBuilder addQuiz(String question, ArrayList<String> ans){
        quizQuestion = question;
        answers = new ArrayList<>(ans);
        return this;
    }

    public NewNote build(){
        return new NewNote(header, text, quizQuestion, answers);
    }
}
