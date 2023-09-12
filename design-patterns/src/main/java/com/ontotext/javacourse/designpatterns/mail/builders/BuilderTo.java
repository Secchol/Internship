package com.ontotext.javacourse.designpatterns.mail.builders;

/** Defines a mail builder which sets the mail to. */
public class BuilderTo extends Builder {

  protected BuilderTo(Mail mail) {
    super(mail);
  }

  /**
   * Sets the mail to field.
   *
   * @param to the mail receiver
   * @return a BuilderSubject object to set the mail subject
   */
  public BuilderSubject to(String to) {
    super.mail.setTo(to);
    return new BuilderSubject(super.mail);
  }
}
