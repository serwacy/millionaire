package com.sda.service;

import com.sda.model.Winning;
import com.sda.repository.WinningsRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WinningsService {
   private static WinningsService winningsService;
   private final WinningsRepository winningsRepository;

   public static WinningsService getInstance() {
      if(winningsService == null) {
         winningsService = new WinningsService(WinningsRepository.getInstance());
      }
      return winningsService;
   }

   public void addWinning(final Winning winning){
      winningsRepository.addWinning(winning);
   }

   public List<Winning> getAll(){
      return winningsRepository.getAll();
   }
}
