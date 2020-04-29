package com.sda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.*;

import java.util.List;

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
   private String category;
   @JsonProperty("type")
   private String type;
   @JsonProperty("difficulty")
   private String difficulty;
   @JsonProperty("question")
   private String question;
   @JsonProperty("correct_answer")
   private String correctAnswer;
   @JsonProperty("incorrect_answers")
   private List<String> incorrectAnswers = null;
}