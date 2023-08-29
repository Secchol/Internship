package com.ontotext.javacourse.collections.pagebean;

import java.util.Map;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;

/** The PaginatorController class contains a method which starts taking commands from the user. */
@AllArgsConstructor
public class PaginatorController<T> {
  private PaginatorModel<T> paginatorModel;
  private final Map<String, Supplier<String>> commands =
      Map.of(
          "next()", () -> paginatorModel.next().toString(),
          "previous()", () -> paginatorModel.previous().toString(),
          "hasNext()", () -> Boolean.toString(paginatorModel.hasNext()),
          "hasPrevious()", () -> Boolean.toString(paginatorModel.hasPrevious()),
          "firstPage()", () -> paginatorModel.firstPage().toString(),
          "lastPage()", () -> paginatorModel.lastPage().toString(),
          "getCurrentPageNumber()", () -> String.valueOf(paginatorModel.getCurrentPageNumber()));
  private PaginatorView paginatorView;

  /** Starts taking commands from the user and displays their result. */
  public void start() {
    String result;
    String command = "next()";
    while (!command.equals("end")) {
      result = returnCommandResult(command);
      if (result.length() == 0) {
        result = "Invalid operation!";
      }
      paginatorView.displayCommandResult(result);
      command = paginatorView.getUserCommandInput();
    }
  }

  /**
   * Returns the given command result.
   *
   * @param command the command which to execute
   * @return the command's result
   */
  private String returnCommandResult(String command) {
    if (!commands.containsKey(command)) {
      throw new IllegalArgumentException("Command is invalid!");
    }
    return commands.get(command).get();
  }
}
