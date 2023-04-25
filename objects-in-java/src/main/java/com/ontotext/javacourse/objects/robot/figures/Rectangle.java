package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

public class Rectangle extends Square {

    @Getter
    @Setter
    private int width;

    public Rectangle(int x, int y, int length, int width) {
        super(x, y, length);
        this.width = width;
    }
}
