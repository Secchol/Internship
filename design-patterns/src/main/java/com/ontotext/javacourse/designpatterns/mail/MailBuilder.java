package com.ontotext.javacourse.designpatterns.mail;

/**
 * The MailBuilder class contains methods for constructing the mail object and getting the result.
 */
public class MailBuilder {
  private final Mail mail = new Mail();

  public MailBuilder from(String from) {
    mail.setFrom(from);
    return this;
  }

  public MailBuilder to(String to) {
    mail.setTo(to);
    return this;
  }

  public MailBuilder subject(String subject) {
    mail.setSubject(subject);
    return this;
  }

  public MailBuilder content(String content) {
    mail.setContent(content);
    return this;
  }

  public MailBuilder cc(String email) {
    mail.getCc().add(email);
    return this;
  }

  public MailBuilder attachments(String attachment) {
    mail.getAttachments().add(attachment);
    return this;
  }

  /**
   * Builds the mail object. If the get field is empty MissingFieldException is thrown.
   *
   * @return returns the constructed mail object
   */
  public Mail build() {
    if (mail.getFrom() == null) {
      throw new MissingFieldException("Mail from is required!");
    }
    return mail;
  }
}
