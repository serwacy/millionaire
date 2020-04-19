package com.sda.repository;

import com.sda.model.Answer;
import com.sda.model.AnswerLetter;
import com.sda.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
   private static List<Question> questionList;

   static {
      questionList = new ArrayList<>();

      String value1 = "Jaka jest stolica USA ?";
      Answer answerA1 = new Answer("Nowy York", AnswerLetter.A);
      Answer answerB1 = new Answer("Waszyngton", AnswerLetter.B);
      Answer answerC1 = new Answer("Los Angeles", AnswerLetter.C);
      Answer answerD1 = new Answer("Hong Kong", AnswerLetter.D);
      Question question1 = new Question(value1, answerA1, answerB1, answerC1, answerD1, AnswerLetter.B);

      String value2 = "Jaki owoc rośnie na palmie ?";
      Answer answerA2 = new Answer("Kokos", AnswerLetter.A);
      Answer answerB2 = new Answer("Ananas", AnswerLetter.B);
      Answer answerC2 = new Answer("Papaja", AnswerLetter.C);
      Answer answerD2 = new Answer("Brzoskwinia", AnswerLetter.D);
      Question question2 = new Question(value2, answerA2, answerB2, answerC2, answerD2, AnswerLetter.A);

      String value3 = "Jaka jest stolica USA ?";
      Answer answerA3 = new Answer("Adam Mickiewicz", AnswerLetter.A);
      Answer answerB3 = new Answer("Roy Hodghson", AnswerLetter.B);
      Answer answerC3 = new Answer("Santiago De Morales", AnswerLetter.C);
      Answer answerD3 = new Answer("William Szekspir", AnswerLetter.D);
      Question question3 = new Question(value3, answerA3, answerB3, answerC3, answerD3, AnswerLetter.D);

      String value4 = "W którym roku Hitler popełnił samobójstwo ?";
      Answer answerA4 = new Answer("1969", AnswerLetter.A);
      Answer answerB4 = new Answer("1939", AnswerLetter.B);
      Answer answerC4 = new Answer("1945", AnswerLetter.C);
      Answer answerD4 = new Answer("2020", AnswerLetter.D);
      Question question4 = new Question(value4, answerA4, answerB4, answerC4, answerD4, AnswerLetter.C);

      questionList.add(question1);
      questionList.add(question2);
      questionList.add(question3);
      questionList.add(question4);
   }
   private static QuestionRepository questionRepository;

   public static QuestionRepository getInstance() {
      if(questionRepository == null) {
         questionRepository = new QuestionRepository();
      }
      return questionRepository;
   }

   private QuestionRepository(){}

   public int getNumberOfQuestions() {
      return questionList.size();
   }
   public Question getQuestionByNumber(int number) {
      return questionList.get(number);
   }
}
