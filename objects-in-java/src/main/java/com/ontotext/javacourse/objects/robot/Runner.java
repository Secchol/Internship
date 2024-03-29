package com.ontotext.javacourse.objects.robot;

import kareltherobot.World;

/** Draws a house using OntoMasterRobot. */
public class Runner {
  /**
   * Sets up a 20x20 KarelJ World and invokes the drawHouse method.
   *
   * @param args
   */
  public static void main(String[] args) {
    World.setSize(20, 20);
    World.setVisible(true);
    World.setDelay(0);
    OntoMasterRobot.drawHouse();
  }
}
