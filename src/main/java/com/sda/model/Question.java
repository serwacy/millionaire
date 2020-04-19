package com.sda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "category",
        "type",
        "difficulty",
        "question",
        "correct_answer",
        "incorrect_answers"
})
public class Question {

   @JsonProperty("category")
   public String category;
   @JsonProperty("type")
   public String type;
   @JsonProperty("difficulty")
   public String difficulty;
   @JsonProperty("question")
   public String question;
   @JsonProperty("correct_answer")
   public String correctAnswer;
   @JsonProperty("incorrect_answers")
   public List<String> incorrectAnswers = null;
}