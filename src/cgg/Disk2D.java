package cgg;

import tools.Color;
import tools.Vec2;

// records create private final fields, constructors, getters, some basic methods
// but fields are immutable!
public record Disk2D(Vec2 position, double radius, Color color) {

    protected boolean coversPoint(Vec2 pointPosition) {
        // u-component == x-coordinate; v-component == y-coordinate 
        return (
            (Math.pow(pointPosition.u() - position.u(), 2)) +
            (Math.pow(pointPosition.v() - position.v(), 2)) <=
            radius() * radius()
        );
    }
}
