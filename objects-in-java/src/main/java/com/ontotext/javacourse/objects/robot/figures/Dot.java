package com.ontotext.javacourse.objects.robot.figures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The Dot class defines a dot which is meant to be drawn. It has x and y coordinates which indicate
 * where the dot will be drawn.
 */
@Getter
@Setter
@AllArgsConstructor
public class Dot extends Figure {
    private int x;
    private int y;
}
