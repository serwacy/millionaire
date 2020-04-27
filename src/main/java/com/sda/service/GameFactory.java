package com.sda.service;

import com.sda.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GameFactory {
   private static QuestionService questionService = QuestionService.getInstance();

   public static Game create(final String playerName) throws IOException {
      return Game.builder()
              .playerName(playerName)
              .questionNumber(1)
              .active(true)
              .lifelines(new LinkedList<>(Arrays.asList(Lifeline.FIFTY_FIFTY, Lifeline.AUDIENCE)))
              .questionsList(initiateQuestionsList())
              .currentPrize(0)
              .guaranteedPrize(0)
              .build();
   }

   private static List<ConvertedQuestion> initiateQuestionsList() throws IOException{
      final List<ConvertedQuestion> questions = new ArrayList<>();
      questions.addAll(getQuestionListOfGivenDifficulty(Difficulty.EASY.getUrl()));
      questions.addAll(getQuestionListOfGivenDifficulty(Difficulty.MEDIUM.getUrl()));
      questions.addAll(getQuestionListOfGivenDifficulty(Difficulty.HARD.getUrl()));
      return questions;
   }

   private static List<ConvertedQuestion> getQuestionListOfGivenDifficulty (final String difficulty) throws IOException {
      final List<Question> questions = questionService.initQuestions(difficulty);
      return questions.stream().map(x->questionService.adaptQuestion(x)).collect(Collectors.toList());
   }
}
