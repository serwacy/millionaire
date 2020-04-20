package com.sda.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionLists {
   private List<Question> easyQuestions;
   private List<Question> mediumQuestions;
   private List<Question> hardQuestions;
}
