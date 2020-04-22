package com.sda.utils;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Question;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionAdapter {
   private static QuestionAdapter questionAdapter;

   public static QuestionAdapter getInstance() {
      if(questionAdapter == null) {
         questionAdapter = new QuestionAdapter();
      }
      return questionAdapter;
   }

   public ConvertedQuestion getAndAdapt(final Question question) {
      final ConvertedQuestion convertedQuestion = new ConvertedQuestion();
      convertedQuestion.setQuestionContent(question.getQuestion());
      organizeAnswers(question, convertedQuestion);
      return convertedQuestion;
   }

   private void organizeAnswers(final Question question, final ConvertedQuestion convertedQuestion){
      final Random random = new Random();
      final int picker = random.nextInt(4);
      switch (picker){
         case 0:
            convertedQuestion.setCorrectAnswerLetter("a");
            convertedQuestion.setAnswerA(question.getCorrectAnswer());
            convertedQuestion.setAnswerB(question.getIncorrectAnswers().get(0));
            convertedQuestion.setAnswerC(question.getIncorrectAnswers().get(1));
            convertedQuestion.setAnswerD(question.getIncorrectAnswers().get(2));
            break;
         case 1:
            convertedQuestion.setCorrectAnswerLetter("b");
            convertedQuestion.setAnswerA(question.getIncorrectAnswers().get(0));
            convertedQuestion.setAnswerB(question.getCorrectAnswer());
            convertedQuestion.setAnswerC(question.getIncorrectAnswers().get(1));
            convertedQuestion.setAnswerD(question.getIncorrectAnswers().get(2));
            break;
         case 2:
            convertedQuestion.setCorrectAnswerLetter("c");
            convertedQuestion.setAnswerA(question.getIncorrectAnswers().get(0));
            convertedQuestion.setAnswerB(question.getIncorrectAnswers().get(1));
            convertedQuestion.setAnswerC(question.getCorrectAnswer());
            convertedQuestion.setAnswerD(question.getIncorrectAnswers().get(2));
            break;
         case 3:
            convertedQuestion.setCorrectAnswerLetter("d");
            convertedQuestion.setAnswerA(question.getIncorrectAnswers().get(0));
            convertedQuestion.setAnswerB(question.getIncorrectAnswers().get(1));
            convertedQuestion.setAnswerC(question.getIncorrectAnswers().get(2));
            convertedQuestion.setAnswerD(question.getCorrectAnswer());
            break;
      }
   }
}
