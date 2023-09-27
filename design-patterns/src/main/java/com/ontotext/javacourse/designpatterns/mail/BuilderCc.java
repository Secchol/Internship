package com.ontotext.javacourse.designpatterns.mail;

/** Defines a mail builder which sets the mail cc. */
public class BuilderCc extends Builder {
  protected BuilderCc(Mail mail) {
    super(mail);
  }

  /**
   * Sets the mail cc field.
   *
   * @param cc the cc of the mail
   * @return a BuilderAttachments object to set the mail attachments
   */
  public BuilderAttachments cc(String cc) {
    super.mail.setCc(cc);
    return new BuilderAttachments(super.mail);
  }
}
