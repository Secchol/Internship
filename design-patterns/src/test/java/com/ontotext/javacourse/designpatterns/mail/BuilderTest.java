package com.ontotext.javacourse.designpatterns.mail;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.designpatterns.exceptions.MissingFieldException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuilderTest {
  private MailBuilder builder;

  @BeforeEach
  void setUp() {
    builder = new MailBuilder();
  }

  @Test
  void builderSetsMailFromCorrectly() {
    assertEquals("email@gmail.com", builder.from("email@gmail.com").build().getFrom());
  }

  @Test
  void builderThrowsExceptionIfMailFromIsEmpty() {
    assertThrows(MissingFieldException.class, () -> builder.from("").build());
  }

  @Test
  void builderSetsMailToCorrectly() {
    assertEquals("yourmail@abv.bg", builder.from("a").to("yourmail@abv.bg").build().getTo());
  }

  @Test
  void builderSetsMailSubjectCorrectly() {
    assertEquals(
        "internship",
        builder.from("a").to("yourmail@abv.bg").subject("internship").build().getSubject());
  }

  @Test
  void builderSetsMailContentCorrectly() {
    assertEquals(
        "you are fired",
        builder
            .from("a")
            .to("yourmail@abv.bg")
            .subject("internship")
            .content("you are fired")
            .build()
            .getContent());
  }

  @Test
  void builderSetsMailCcCorrectly() {
    assertEquals(
        "mybrother@gmail.com",
        builder
            .from("a")
            .to("yourmail@abv.bg")
            .subject("internship")
            .content("you are fired")
            .cc("mybrother@gmail.com")
            .build()
            .getCc());
  }

  @Test
  void builderAddsMailAttachmentsCorrectly() {
    assertTrue(
        builder
            .from("a")
            .to("yourmail@abv.bg")
            .subject("internship")
            .content("you are fired")
            .cc("mybrother@gmail.com")
            .attachment("note")
            .build()
            .getAttachments()
            .contains("note"));
  }
}
