package com.ontotext.javacourse.designpatterns.mail.builders;

/** Defines a mail builder which sets the mail content. */
public class BuilderContent extends Builder {
  protected BuilderContent(Mail mail) {
    super(mail);
  }

  /**
   * Sets the mail content.
   *
   * @param content the content of the mail
   * @return a BuilderCC object to set the cc of the mail
   */
  public BuilderCC content(String content) {
    super.mail.setContent(content);
    return new BuilderCC(super.mail);
  }
}
