package com.ontotext.javacourse.designpatterns.mail;

import com.ontotext.javacourse.designpatterns.mail.builders.Mail;
import com.ontotext.javacourse.designpatterns.mail.builders.MailBuilder;

public class Runner {
  public static void main(String args[]) {

    MailBuilder builder = new MailBuilder();
    Mail mail = builder.from("").to("sdfs").build();
    System.out.println(
        mail.getFrom()
            + mail.getTo()
            + mail.getContent()
            + mail.getSubject()
            + mail.getCc()
            + mail.getAttachments());
  }
}
