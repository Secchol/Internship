package com.ontotext.javacourse.designpatterns.mail.builders;

/** Defines a mail builder which sets the mail attachments. */
public class BuilderAttachments extends Builder {
  protected BuilderAttachments(Mail mail) {
    super(mail);
  }

  /**
   * Sets the mail attachments.
   *
   * @param attachment the mail attachment to add
   * @return a BuilderAttachments object in case the client wants to add another attachment
   */
  public BuilderAttachments attachment(String attachment) {
    super.mail.getAttachments().add(attachment);
    return this;
  }
}
