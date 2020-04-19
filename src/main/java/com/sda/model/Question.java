package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Question {
   private String value;

   private Answer answerA;
   private Answer answerB;
   private Answer answerC;
   private Answer answerD;

   private AnswerLetter correctAnswer;
}
