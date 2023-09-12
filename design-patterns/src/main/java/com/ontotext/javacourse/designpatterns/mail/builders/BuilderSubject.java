package com.ontotext.javacourse.designpatterns.mail.builders;

/** Defines a mail builder which sets the mail subject. */
public class BuilderSubject extends Builder {
  protected BuilderSubject(Mail mail) {
    super(mail);
  }

  /**
   * Sets the mail subject field.
   *
   * @param subject the subject of the mail
   * @return a BuilderContent object to set the mail content
   */
  public BuilderContent subject(String subject) {
    super.mail.setSubject(subject);
    return new BuilderContent(super.mail);
  }
}
