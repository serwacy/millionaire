package com.sda.utils;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Difficulty;
import com.sda.model.Question;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
      final int correctAnswerNumber = correctAnswerNumberPicker();
      return ConvertedQuestion.builder()
              .questionContent(question.getQuestion())
              .answers(organizeAnswers(question, correctAnswerNumber))
              .correctAnswerNumber(correctAnswerNumber)
              .difficulty(Difficulty.parseDiff(question.getDifficulty()))
              .build();
   }

   private int correctAnswerNumberPicker(){
      final Random random = new Random();
      return random.nextInt(4);
   }

   private List<String> organizeAnswers (final Question question, final int correctAnswerNumber){
      final List<String> answers = new ArrayList<>();
      int incorrectAnswersMarker = 0;
      for (int idx = 0; idx < 4; idx++) {
         if(idx == correctAnswerNumber){
            answers.add(question.getCorrectAnswer());
         } else {
            answers.add(question.getIncorrectAnswers().get(incorrectAnswersMarker));
            incorrectAnswersMarker++;
         }
      }
      return answers;
   }
}
