package com.ontotext.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.List;

public class Runner {

  public static void main(String args[]) {
    PaginatorController<String> paginatorController =
        new PaginatorController<>(createPaginatorModel(), new PaginatorView());
    paginatorController.start();
  }

  public static PaginatorModel<String> createPaginatorModel() {
    List<String> testData = new ArrayList<>();
    for (int i = 1; i <= 16; i++) {
      testData.add("Item " + i);
    }
    return new PaginatorModel<>(testData, 5);
  }
}
