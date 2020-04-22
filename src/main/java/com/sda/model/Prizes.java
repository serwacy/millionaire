package com.sda.model;

import java.util.Arrays;
import java.util.List;

public enum Prizes {
   PRIZES(Arrays.asList(500, 1_000, 2_000, 5_000, 10_000, 20_000, 40_000, 75_000, 125_000, 250_000, 500_000, 1_000_000)),
   GUARANTEED_PRIZES(Arrays.asList(1_000, 40_000, 1_000_000));

   private List<Integer> prizes;

   Prizes(final List<Integer> prizes) {
      this.prizes = prizes;
   }

   public int getPrize(final int questionNumber) {
      return prizes.get(questionNumber - 1);
   }

   public List<Integer> getAllPrizes(){
      return prizes;
   }
}
