package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

public class Line extends Dot {

    @Getter @Setter
    private int secondPointX;

    @Getter @Setter private int secondPointY;

    public Line(int x, int y, int secondPointX, int secondPointY) {
        super(x, y);
        this.secondPointX = secondPointX;
        this.secondPointY = secondPointY;
    }
}
