package com.ontotext.javacourse.designpatterns.proxy;

import java.util.Random;

/**
 * The LeetcodeInternet class is an Internet that redirects the client to a random Leetcode problem
 * when he requests to connect to a URL. If the client is not able to solve the given problem first
 * try he is unworthy of using the internet and is redirected to the official java documentation
 * page.
 */
public class LeetcodeInternet implements Internet {

  private static final Random RANDOM = new Random();
  private static final String[] RANDOMPROBLEMURLS = {
    "https://leetcode.com/problems/random-problem-1/",
    "https://leetcode.com/problems/random-problem-2/",
    "https://leetcode.com/problems/random-problem-3/",
    "https://leetcode.com/problems/random-problem-4/",
  };
  private final NormalInternet normalInternet;

  private boolean solvedProblem = false;

  public LeetcodeInternet() {
    normalInternet = new NormalInternet();
  }

  @Override
  public boolean connectTo(String url) {
    String randomProblemUrl = pickRandomProblem();
    normalInternet.connectTo(randomProblemUrl);
    if (solvedProblem) {
      return normalInternet.connectTo(url);
    }
    normalInternet.connectTo("https://docs.oracle.com/en/java/");
    return false;
  }

  public void solveProblem() {
    this.solvedProblem = true;
  }

  private String pickRandomProblem() {
    int randomNumber = RANDOM.nextInt(0, 4);
    return RANDOMPROBLEMURLS[randomNumber];
  }
}
