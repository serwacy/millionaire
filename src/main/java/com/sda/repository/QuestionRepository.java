package com.sda.repository;

import com.sda.model.Question;



public class QuestionRepository {
   private static QuestionRepository questionRepository;

   public static QuestionRepository getInstance() {
      if(questionRepository == null) {
         questionRepository = new QuestionRepository();
      }
      return questionRepository;
   }

   private QuestionRepository(){}
}
