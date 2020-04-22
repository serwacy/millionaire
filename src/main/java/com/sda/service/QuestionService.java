package com.sda.service;

import com.sda.model.ConvertedQuestion;
import com.sda.model.Game;
import com.sda.model.Question;
import com.sda.repository.QuestionRepository;
import com.sda.utils.QuestionAdapter;

import java.io.IOException;
import java.util.List;

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

   private QuestionService(final QuestionRepository questionRepository, final QuestionAdapter questionAdapter){
      this.questionRepository = questionRepository;
      this.questionAdapter = questionAdapter;
   }

   public List<Question> initQuestions(final String urlAsString) throws IOException {
      return questionRepository.initQuestions(urlAsString);
   }

   public Question questionPicker(final Game game){
      if(game.getQuestionNumber() < 5){
         return game.getQuestionLists().getEasyQuestions().get(game.getQuestionNumber()-1);
      }
      if(game.getQuestionNumber() < 9){
         return game.getQuestionLists().getMediumQuestions().get(game.getQuestionNumber()-5);
      }
      return game.getQuestionLists().getHardQuestions().get(game.getQuestionNumber()-9);
   }

   public ConvertedQuestion adaptQuestion(final Question question){
      return questionAdapter.getAndAdapt(question);
   }
}
