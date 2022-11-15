package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class QuizMaker {

	public static void main(String[] args) {

		// scanner for user input
		Scanner input = new Scanner(System.in);
		// set testQuiz pointer to file
		File testQuiz = new File("test_quiz.txt");

		try (Scanner fileScanner = new Scanner(testQuiz)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				QuizQuestion quizQuestion = makeQuestion(line);
				askQuestion(quizQuestion);
				System.out.println();
				System.out.print("Enter your answer: ");
				String userAnswerString = input.nextLine();
				int userAnswer = Integer.parseInt(userAnswerString);
				compareQuestions(userAnswer, quizQuestion);
			}
		} catch (Exception ex) {
			System.out.println("Error: an exception has been thrown");
		}

	}

	public static QuizQuestion makeQuestion(String line) {
		String[] stringArrayFromLine = line.split("\\|");
		return new QuizQuestion(stringArrayFromLine);
	}

	public static void askQuestion(QuizQuestion quizQuestion) {
		System.out.println(quizQuestion.getQuestion());
		String[] answers = quizQuestion.getAnswers();
		for (int i = 0; i < answers.length; i++) {
			System.out.println((i + 1) + ". " + answers[i]);
		}
	}

	public static void compareQuestions(int userAnswer, QuizQuestion quizQuestion) {
		if (userAnswer == quizQuestion.getCorrectAnswer()) {
			System.out.println("CORRECT!");
			System.out.println();
		} else {
			System.out.println("WRONG!");
			System.out.println();
		}
	}

}
