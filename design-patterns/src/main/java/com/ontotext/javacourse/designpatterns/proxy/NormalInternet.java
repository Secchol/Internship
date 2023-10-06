package com.ontotext.javacourse.designpatterns.proxy;

import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The NormalInternet class contains a method that connects a client to a given url. */
public class NormalInternet implements Internet {
  private static final Logger LOGGER = LoggerFactory.getLogger(NormalInternet.class);

  /**
   * Connects a client to a given url if it is valid.
   *
   * @param url the url to connect the client to
   * @return whether the connection was successful
   */
  @Override
  public boolean connectTo(String url) {
    String[] schemes = {"http", "https"};
    UrlValidator urlValidator = new UrlValidator(schemes);
    boolean isValidUrl = urlValidator.isValid(url);
    if (!isValidUrl) {
      throw new IllegalArgumentException("URL is invalid!");
    }
    LOGGER.info("Connected to {}", url);
    return true;
  }
}
