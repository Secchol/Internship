package com.ontotext.javacourse.designpatterns.mail.builders;

/** Defines a mail builder which sets the mail from. */
public class MailBuilder extends Builder {
  public MailBuilder() {
    super.mail = new Mail();
  }

  /**
   * Sets the mail from field.
   *
   * @param from the sender of the mail
   * @return BuilderTo object to set the receiver of the mail
   */
  public BuilderTo from(String from) {
    super.mail.setFrom(from);
    return new BuilderTo(super.mail);
  }
}
