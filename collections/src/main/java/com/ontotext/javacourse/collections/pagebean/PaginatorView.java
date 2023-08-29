package com.ontotext.javacourse.collections.pagebean;

import java.util.Scanner;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The PaginatorView class contains methods for displaying command result and taking user commands.
 */
@NoArgsConstructor
public class PaginatorView {

  private static final Logger LOGGER = LoggerFactory.getLogger(PaginatorView.class);
  private final Scanner scanner = new Scanner(System.in);


  /**
   * Displays the previously given command result.
   *
   * @param result the command's result
   */
  public void displayCommandResult(String result) {
    LOGGER.info(result);
  }

  /**
   * Gets the user command input.
   *
   * @return the user's command
   */
  public String getUserCommandInput() {
    return scanner.nextLine();
  }
}
