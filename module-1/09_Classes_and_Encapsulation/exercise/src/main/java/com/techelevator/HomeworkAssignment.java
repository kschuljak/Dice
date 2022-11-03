package com.techelevator;

public class HomeworkAssignment {

    // instance variables
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;


    // earned marks - getter and setter
    public int getEarnedMarks() {
        return earnedMarks;
    }
    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    // possible marks - getter
    public int getPossibleMarks() {
        return possibleMarks;
    }

    // submitterName - getter
    public String getSubmitterName() {
        return submitterName;
    }

    // letterGrade (derived) - getter
    public String getLetterGrade() {
        int percentage = (earnedMarks * 100) / possibleMarks;
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        return "F";
    }

    // constructor
    // argument 1 - possible marks
    // argument 2 - submitter name
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;
    }
}
