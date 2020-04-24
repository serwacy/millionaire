package com.sda.utils;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Game;

import java.util.*;

public class LifelineUtils {
   public static void useFiftyFiftyLifeline(final ConvertedQuestion question){
      prepareAnswerList(question);
   }

   public static void useAudienceLifeline(final Game game){

   }

   private static void prepareAnswerList(final ConvertedQuestion question){
      switch (question.getCorrectAnswerNumber()){
         case 0:
            clearTwoWrongAnswers(question, new LinkedList<>(Arrays.asList(1,2,3)));
            break;
         case 1:
            clearTwoWrongAnswers(question, new LinkedList<>(Arrays.asList(0,2,3)));
            break;
         case 2:
            clearTwoWrongAnswers(question, new LinkedList<>(Arrays.asList(0,1,3)));
            break;
         case 3:
            clearTwoWrongAnswers(question, new LinkedList<>(Arrays.asList(0,1,2)));
            break;
      }
   }

   private static void clearTwoWrongAnswers(final ConvertedQuestion question, final List<Integer> wrongNumbers){
      List<Integer> wrongAnswerNumbers = randomlyChooseTwoOutOfThree(wrongNumbers);
      for (Integer answerNumber: wrongAnswerNumbers) {
         question.getAnswers().set(answerNumber, "");
      }
   }

   private static List<Integer> randomlyChooseTwoOutOfThree(final List<Integer> givenNumbers){
      List<Integer> copy = new LinkedList<>(givenNumbers);
      Collections.shuffle(copy);
      return copy.subList(0, 2);
   }
}
