package com.sda.service;

import com.sda.model.Question;
import com.sda.repository.QuestionRepository;

import java.io.IOException;

public class QuestionService {
   private static QuestionService questionService;
   private final QuestionRepository questionRepository;

   public static QuestionService getInstance() {
      if(questionService == null) {
         questionService = new QuestionService(QuestionRepository.getInstance());
      }
      return questionService;
   }

   private QuestionService(final QuestionRepository questionRepository){
      this.questionRepository = questionRepository;
   }

   public Question getQuestion(final String urlAsString) throws IOException {
      return questionRepository.getQuestion(urlAsString);
   }
}
