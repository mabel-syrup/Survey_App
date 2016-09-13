package com.surber.matthew.surveyapp;

/**
 * Created by wo1624bu on 9/13/16.
 */
public class Memory {

    public static String Question = "Is this a good app?";
    public static String AnswerYes = "Yes";
    public static String AnswerNo = "No";
    public static String AnswerMaybe = "Maybe";

    public static String getQuestion() {
        return Question;
    }

    public static void setQuestion(String question) {
        Question = question;
    }

    public static String getAnswerYes() {
        return AnswerYes;
    }

    public static void setAnswerYes(String answerYes) {
        AnswerYes = answerYes;
    }

    public static String getAnswerNo() {
        return AnswerNo;
    }

    public static void setAnswerNo(String answerNo) {
        AnswerNo = answerNo;
    }

    public static String getAnswerMaybe() {
        return AnswerMaybe;
    }

    public static void setAnswerMaybe(String answerMaybe) {
        AnswerMaybe = answerMaybe;
    }
}
