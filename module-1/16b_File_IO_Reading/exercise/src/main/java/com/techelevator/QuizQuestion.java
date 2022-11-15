package com.techelevator;

public class QuizQuestion {

    String question;
    String[] answers = new String[4];
    int correctAnswer;

    public QuizQuestion(String[] stringArrayFromLine) {
        this.question = stringArrayFromLine[0];
        for (int i = 1; i < stringArrayFromLine.length; i++) {
            answers[i - 1] = stringArrayFromLine[i];
            if (stringArrayFromLine[i].endsWith("*")) {
                this.correctAnswer = i;
                int lastElement = stringArrayFromLine[i].length() - 1;
                answers[i - 1] = stringArrayFromLine[i].substring(0, lastElement);
            }
        }
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
