package com.ontotext.javacourse.designpatterns.mail.builders;

import com.ontotext.javacourse.designpatterns.mail.MissingFieldException;
import lombok.NoArgsConstructor;

/** Defines a mail builder. */
@NoArgsConstructor
public abstract class Builder {
  protected Mail mail;

  protected Builder(Mail mail) {
    this.mail = mail;
  }

  /**
   * Builds the mail object. If the from field is empty MissingFieldException is thrown.
   *
   * @return the constructed mail object
   */
  public Mail build() {
    if (mail.getFrom().isEmpty()) {
      throw new MissingFieldException("Mail from is required!");
    }
    return this.mail;
  }
}
