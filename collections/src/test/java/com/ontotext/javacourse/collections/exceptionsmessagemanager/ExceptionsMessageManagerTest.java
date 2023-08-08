package com.ontotext.javacourse.collections.exceptionsmessagemanager;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExceptionsMessageManagerTest {

  private ExceptionsMessageManager exceptionsMessageManager;

  @BeforeEach
  void setUp() {
    Map<String, String> map = new HashMap<>();
    map.put("Invalid debit card number", null);
    map.put("Wrong PIN", "Invalid zip code");
    map.put("Invalid argument", null);
    exceptionsMessageManager = new ExceptionsMessageManager(map, " | ");
  }

  @Test
  void getMessagesWorksWithCorrectInput() {
    ArrayList<String> list = new ArrayList<>();
    list.add("Wrong PIN");
    list.add("Invalid debit card number");
    list.add("Invalid zip code");
    assertEquals(
        list,
        ExceptionsMessageManager.getMessages(
            "Wrong PIN | Invalid debit card number | Invalid zip code"));
  }

  @Test
  void getMessagesWorksWithEmptyStringInput() {
    assertEquals(0, ExceptionsMessageManager.getMessages("").stream().count());
  }

  @Test
  void addExceptionMessageWorksIfMessageIsPresentInMap() {
    exceptionsMessageManager.addExceptionMessage("Invalid zip code");
    assertTrue(exceptionsMessageManager.getElementsToConcatenate().contains("Invalid zip code"));
  }

  @Test
  void addExceptionMessageThrowsExceptionIfMessageIsNotPresentInMap() {
    assertThrows(
        InvalidParameterException.class,
        () -> exceptionsMessageManager.addExceptionMessage("Missing Message"));
  }

  @Test
  void addExceptionMessageUsingCodeWorksIfMessageCodeIsPresentInMap() {
    exceptionsMessageManager.addExceptionMessageUsingCode("Wrong PIN");
    assertTrue(exceptionsMessageManager.getElementsToConcatenate().contains("Wrong PIN"));
  }

  @Test
  void addExceptionMessageUsingCodeThrowsExceptionIfMessageCodeIsNotPresentInMap() {
    assertThrows(
        InvalidParameterException.class,
        () -> exceptionsMessageManager.addExceptionMessageUsingCode("Missing message"));
  }

  @Test
  void getMessageReturnsCorrectOutput() {
    exceptionsMessageManager.addExceptionMessage("Invalid zip code");
    exceptionsMessageManager.addExceptionMessageUsingCode("Invalid argument");
    exceptionsMessageManager.addExceptionMessageUsingCode("Invalid debit card number");
    assertEquals(
        "Invalid zip code | Invalid argument | Invalid debit card number",
        exceptionsMessageManager.getMessage());
  }

  @Test
  void getMessageReturnsCorrectInputIfGeneratedStringIsEmpty() {
    assertTrue(exceptionsMessageManager.getMessage().isEmpty());
  }
}
