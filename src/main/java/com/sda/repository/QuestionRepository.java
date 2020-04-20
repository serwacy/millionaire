package com.sda.repository;

import com.sda.model.Question;
import com.sda.utils.JsonReader;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;

public class QuestionRepository {
   private static QuestionRepository questionRepository;

   public static QuestionRepository getInstance() {
      if(questionRepository == null) {
         questionRepository = new QuestionRepository();
      }
      return questionRepository;
   }

   private QuestionRepository(){}

   public Question getQuestion(final String urlAsString) throws IOException {
      final ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(modifyJsonToString(JsonReader.readJsonFromUrl(urlAsString)), Question.class);
   }

   private String modifyJsonToString (final JSONObject jsonFromUrl) {
      final String jsonToString = jsonFromUrl.toString();
      return jsonToString.substring(0, jsonToString.length() - 2)
              .replace("{\"response_code\":0,\"results\":[", "");
   }
}
