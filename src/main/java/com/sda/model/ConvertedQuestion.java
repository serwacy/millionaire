package com.sda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvertedQuestion {
   private String questionContent;
   private String answerA;
   private String answerB;
   private String answerC;
   private String answerD;
   private String correctAnswerLetter;
}
