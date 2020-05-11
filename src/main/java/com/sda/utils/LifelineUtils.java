package com.sda.utils;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Difficulty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LifelineUtils {
   private static LifelineUtils lifelineUtils;

   public static LifelineUtils getInstance() {
      if(lifelineUtils == null) {
         lifelineUtils = new LifelineUtils();
      }
      return lifelineUtils;
   }

   public void useFiftyFiftyLifeline(final ConvertedQuestion question){
      prepareAnswerList(question);
   }

   private void prepareAnswerList(final ConvertedQuestion question){
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

   private void clearTwoWrongAnswers(final ConvertedQuestion question, final List<Integer> wrongNumbers){
      List<Integer> wrongAnswerNumbers = randomlyChooseTwoOutOfThree(wrongNumbers);
      wrongAnswerNumbers.forEach(answerNumber -> question.getAnswers().set(answerNumber, ""));
   }

   private List<Integer> randomlyChooseTwoOutOfThree(final List<Integer> givenNumbers){
      List<Integer> copy = new LinkedList<>(givenNumbers);
      Collections.shuffle(copy);
      return copy.subList(0, 2);
   }

   public void useAudienceLifeline(final ConvertedQuestion question){
      appendPercentagesToAnswers(question);
   }

   private void appendPercentagesToAnswers(final ConvertedQuestion question){
      List<String> percentages = getPercentagesValues(question);
      List<Integer> answerNumbers = organizeAnswerNumbers(question);
      for (int idx = 0; idx < percentages.size(); idx++) {
         final String answer = question.getAnswers().get(answerNumbers.get(idx)).concat(percentages.get(idx));
         question.getAnswers().set(answerNumbers.get(idx), answer);
      }
   }

   private List<String> getPercentagesValues(final ConvertedQuestion question){
      switch (question.getDifficulty()){
         case EASY:
            return Arrays.asList(" - 74%", " - 11%", " - 8%", " - 7%");
         case MEDIUM:
            return  Arrays.asList(" - 46%", " - 29%", " - 14%", " - 11%");
         case HARD:
            return Arrays.asList(" - 38%", " - 30%", " - 19%", " - 13%");
         default:
            return Collections.emptyList();
      }
   }

   private List<Integer> organizeAnswerNumbers(final ConvertedQuestion question){
      boolean isAnswerCorrect = isAudienceGivingCorrectAnswer(question.getDifficulty());
      List<Integer> answerNumbers = new LinkedList<>();
      if(isAnswerCorrect){
         answerNumbers.add(question.getCorrectAnswerNumber());
         answerNumbers.addAll(getRemainingAnswerNumbers(question.getCorrectAnswerNumber()));
      } else {
         final int incorrectAnswerNumber = getAnotherAnswerNumberOutOfRemaining(question.getCorrectAnswerNumber());
         answerNumbers.add(incorrectAnswerNumber);
         answerNumbers.addAll(getRemainingAnswerNumbers(incorrectAnswerNumber));
      }
      return answerNumbers;
   }

   private boolean isAudienceGivingCorrectAnswer(final Difficulty difficulty){
      final Random random = new Random();
      if(difficulty.equals(Difficulty.HARD)){
         return random.nextInt(100) <= 50;
      } else if(difficulty.equals(Difficulty.MEDIUM)){
         return random.nextInt(100) <= 75;
      } else {
         return true;
      }
   }

   private List<Integer> getRemainingAnswerNumbers(final int firstNumber){
      List<Integer> answerNumbers = new LinkedList<>();
      switch (firstNumber){
         case 0:
            answerNumbers.addAll(Arrays.asList(1,2,3));
            break;
         case 1:
            answerNumbers.addAll(Arrays.asList(0,2,3));
            break;
         case 2:
            answerNumbers.addAll(Arrays.asList(0,1,3));
            break;
         case 3:
            answerNumbers.addAll(Arrays.asList(0,1,2));
            break;
      }
      Collections.shuffle(answerNumbers);
      return answerNumbers;
   }

   private int getAnotherAnswerNumberOutOfRemaining(final int number){
      List<Integer> answerNumbers = new LinkedList<>(Arrays.asList(0,1,2,3));
      answerNumbers.remove(number);
      Collections.shuffle(answerNumbers);
      return answerNumbers.get(0);
   }
}
