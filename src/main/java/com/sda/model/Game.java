package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Game {
   private String playerName;
   private int questionNumber;
   private List<Lifeline> lifelines;
   private boolean active;
   private QuestionLists questionLists;
   private int currentPrize;
   private int guaranteedPrize;
   private ConvertedQuestion processedQuestion;
   private boolean usedFiftyFifty;
}
