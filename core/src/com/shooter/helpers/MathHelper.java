package com.shooter.helpers;

/**
 * Created by miraj on 19.5.17.
 */
public class MathHelper {
    public static float getAngle(float x1, float y1, float x2, float y2){
        double rad = Math.atan((y1 - y2) / (x2 - x1));

        rad += 2 * Math.PI;

        if (x2 < x1){
            rad += Math.PI;
        }

        return (float) Math.toDegrees(-rad);
    }
}
