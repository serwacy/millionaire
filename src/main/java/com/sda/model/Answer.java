package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Answer {
   private String value;
   private AnswerLetter answerLetter;
}
