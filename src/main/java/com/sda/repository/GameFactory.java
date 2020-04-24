package com.sda.repository;

import com.sda.model.*;
import com.sda.service.QuestionService;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GameFactory {
   private static QuestionService questionService = QuestionService.getInstance();

   public static Game create(final String playerName) throws IOException {
      return Game.builder()
              .playerName(playerName)
              .questionNumber(1)
              .active(true)
              .lifelines(new LinkedList<>(Arrays.asList(Lifeline.FIFTY_FIFTY, Lifeline.AUDIENCE)))
              .questionLists(initiateQuestionLists())
              .currentPrize(0)
              .guaranteedPrize(0)
              .usedFiftyFifty(false)
              .build();
   }

   private static QuestionLists initiateQuestionLists() throws IOException{
      return QuestionLists.builder()
              .easyQuestions(getQuestionListOfGivenDifficulty(Difficulty.EASY.getUrl()))
              .mediumQuestions(getQuestionListOfGivenDifficulty(Difficulty.MEDIUM.getUrl()))
              .hardQuestions(getQuestionListOfGivenDifficulty(Difficulty.HARD.getUrl()))
              .build();
   }

   private static List<Question> getQuestionListOfGivenDifficulty (final String difficulty) throws IOException {
      return questionService.initQuestions(difficulty);
   }
}
