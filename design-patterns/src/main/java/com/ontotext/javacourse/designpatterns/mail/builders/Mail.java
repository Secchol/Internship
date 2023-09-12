package com.ontotext.javacourse.designpatterns.mail.builders;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/** Defines a mail object. */
@Getter
@Setter
public class Mail {
  private String from;
  private String to;
  private String subject;
  private String content;
  private String cc;
  private List<String> attachments = new ArrayList<>();

  protected Mail() {}
}
