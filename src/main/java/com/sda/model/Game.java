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
   private List<ConvertedQuestion> questionsList;
   private int currentPrize;
   private int guaranteedPrize;
}
