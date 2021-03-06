package com.sda.service;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Question;
import com.sda.repository.QuestionRepository;
import com.sda.utils.QuestionAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class QuestionService {
   private static QuestionService questionService;
   private final QuestionRepository questionRepository;
   private final QuestionAdapter questionAdapter;

   public static QuestionService getInstance() {
      if(questionService == null) {
         questionService = new QuestionService(QuestionRepository.getInstance(), QuestionAdapter.getInstance());
      }
      return questionService;
   }

   public List<Question> initQuestions(final String urlAsString) throws IOException {
      return questionRepository.initQuestions(urlAsString);
   }

   public ConvertedQuestion adaptQuestion(final Question question){
      return questionAdapter.getAndAdapt(question);
   }
}
