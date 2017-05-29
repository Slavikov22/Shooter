package com.shooter.helpers;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 19.5.17.
 */
public class MathHelper {
    public static float getAngle(float x1, float y1, float x2, float y2){
        double rad = Math.atan((y1 - y2) / (x2 - x1));

        if (x2 < x1){
            rad += Math.PI;
        }

        return (float)(-rad);
    }

    public static float getArea(float[] points){
        float[] lines = new float[3];

        lines[0] = (float) Math.sqrt(Math.pow(points[0] - points[2], 2) + Math.pow(points[1] - points[3], 2));
        lines[1] = (float) Math.sqrt(Math.pow(points[2] - points[4], 2) + Math.pow(points[3] - points[5], 2));
        lines[2] = (float) Math.sqrt(Math.pow(points[4] - points[0], 2) + Math.pow(points[5] - points[1], 2));

        float pp = (lines[0] + lines[1] + lines[2]) / 2;

        return (float) Math.sqrt(pp * (pp - lines[0]) * (pp - lines[1]) * (pp - lines[2]));
    }

    public static Vector2 getVector2byAngle(float angle, float module){
        float x = (float) (Math.pow(module, 2) / (1 + Math.pow(Math.tan(angle), 2)));
        float y = (float) (x * Math.tan(angle));

        if (angle < -(Math.PI / 2)){
            x = -x;
            y = -y;
        }

        return new Vector2(x, y);
    }
}
