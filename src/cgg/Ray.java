package cgg;

import tools.Vec3;

/*
*
* @param x0     origin of ray
* @param d      direction of ray
* @param t_min  minimal length of ray ("point A")
* @param t_max  maximal length of ray ("point B")
*/
public record Ray(Vec3 x0, Vec3 d, float t_min, float t_max) {
    
    public Vec3 getPointOnRay(float t) {
        if (isTOnRay(t)) { 
            return new Vec3(
                x0.u() + t*d.u(), 
                x0.v() + t*d.v(), 
                x0.w() + t*d.w()
            ); }
        // default to 0,0,0 if not on Ray
        // TODO: check if that has ugly side effects
        return new Vec3(0,0,0);
    }

    /*
    *
    * @param t  position of a specified point on the ray defined by length from x0
    */
    private boolean isTOnRay(float t) {
        return t_min <= t && t <= t_max;
    }
}
