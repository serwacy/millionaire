package com.sda.repository;

import com.sda.model.Game;
import com.sda.model.Lifeline;

import java.util.Arrays;

public class GameFactory {
   public static Game create(final String playerName) {
      return Game.builder()
              .playerName(playerName)
              .questionNumber(1)
              .isActive(true)
              .lifelines(Arrays.asList(Lifeline.AUDIENCE, Lifeline.ON_HALF))
              .build();
   }
}
