package com.ontotext.javacourse.collections;

import com.ontotext.javacourse.collections.exceptionsmessagemanager.ExceptionsMessageManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class sdfsdf {
  public static void main(String args[]) {
    Map<String, String> map = new HashMap<>();
    map.put("Invalid debit card number", null);
    map.put("Wrong PIN", "Invalid zip code");
    map.put("Invalid argument", null);
    var exceptionsMessageManager = new ExceptionsMessageManager(map);
    System.out.println(
        Arrays.stream("Wrong PIN | Invalid debit card number | Invalid zip code".split(" | "))
            .collect(Collectors.joining(" | ")));
  }
}
