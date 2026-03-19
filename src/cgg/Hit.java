package cgg;

import tools.Color;

/*
*
* @param t    length between x0 and x1  TODO: fact check
* @param x_1  vector of position where hit occured
* @param n    normal vector of ray
* @param c    color of surface the ray hit
*/
public record Hit(double t, double x_1, double n, Color c) {
    
}
