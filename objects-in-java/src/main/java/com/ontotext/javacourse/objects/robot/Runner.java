package com.ontotext.javacourse.objects.robot;

import kareltherobot.World;

public class Runner {
    public static void main(String[] args) {
        World.setSize(20, 20);
        World.setVisible(true);
        World.setDelay(0);
        OntoMasterRobot.drawHouse();
    }
}
