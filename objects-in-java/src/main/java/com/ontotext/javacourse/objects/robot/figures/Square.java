package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

public class Square extends Dot {
    @Getter @Setter
    private int length;

    public Square(int x, int y, int length) {
        super(x, y);
        this.length = length;
    }
}
