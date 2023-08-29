package com.ontotext.javacourse.designpatterns.mail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MailBuilderTest {

  @Test
  void buildConstructsMailObject() {
    MailBuilder builder = new MailBuilder();
    Mail mail =
        builder
            .from("me")
            .to("ivan")
            .subject("work")
            .content("blabla")
            .cc("pesho")
            .attachments("very important info")
            .build();
    boolean isCorrectlyBuilt =
        mail.getFrom().equals("me")
            && mail.getTo().equals("ivan")
            && mail.getSubject().equals("work")
            && mail.getContent().equals("blabla")
            && mail.getCc().stream().count() == 1
            && mail.getAttachments().stream().count() == 1;
    assertTrue(isCorrectlyBuilt);
  }

  @Test
  void buildThrowsExceptionIfFromFieldIsMissing() {
    MailBuilder builder = new MailBuilder();
    builder.to("nobody").subject("work").content("sdfs").cc("pp");
    assertThrows(MissingFieldException.class, builder::build);
  }
}
