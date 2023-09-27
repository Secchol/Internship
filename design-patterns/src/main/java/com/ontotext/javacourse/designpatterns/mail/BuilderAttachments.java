package com.ontotext.javacourse.designpatterns.mail;

/** Defines a mail builder which adds the mail attachments. */
public class BuilderAttachments extends Builder {
  protected BuilderAttachments(Mail mail) {
    super(mail);
  }

  /**
   * Adds an attachment to the mail.
   *
   * @param attachment the mail attachment to add
   * @return a BuilderAttachments object in case the client wants to add another attachment
   */
  public BuilderAttachments attachment(String attachment) {
    super.mail.getAttachments().add(attachment);
    return this;
  }
}
