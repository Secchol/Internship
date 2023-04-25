package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

public abstract class Figure {
    @Getter
    @Setter
    private int x;
    @Getter
    @Setter
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }


}
