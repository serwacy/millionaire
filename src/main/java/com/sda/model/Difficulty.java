package com.sda.model;

public enum Difficulty {
   EASY("https://opentdb.com/api.php?amount=4&difficulty=easy&type=multiple"),
   MEDIUM("https://opentdb.com/api.php?amount=4&difficulty=medium&type=multiple"),
   HARD("https://opentdb.com/api.php?amount=4&difficulty=hard&type=multiple");

   private String url;

   Difficulty(final String diffUrl) {
      this.url = diffUrl;
   }

   public String getUrl() {
      return url;
   }
}
