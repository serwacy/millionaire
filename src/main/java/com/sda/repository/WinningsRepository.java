package com.sda.repository;

import com.sda.model.Winning;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WinningsRepository {
   private static WinningsRepository winningsRepository;
   private List<Winning> winnings;

   public static WinningsRepository getInstance() {
      if(winningsRepository == null) {
         winningsRepository = new WinningsRepository(new ArrayList<>());
      }
      return winningsRepository;
   }

   public boolean addWinning(final Winning winning){
      return winnings.add(winning);
   }

   public List<Winning> getAll(){
      return winnings.stream()
              .sorted(Comparator.comparingInt(Winning::getPrize).reversed())
              .collect(Collectors.toList());
   }
}
