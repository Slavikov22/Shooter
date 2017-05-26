package com.shooter.helpers;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 26.5.17.
 */
public class TiledMapHelper {
    public static Vector2 getPlayerPosition(TiledMap map){
        float posX = (Float) map.getLayers().get("GameObjects").getObjects().get("StartPoint").getProperties().get("x");
        float posY = (Float) map.getLayers().get("GameObjects").getObjects().get("StartPoint").getProperties().get("y");

        return CameraHelper.unproject(new Vector2(posX, posY));
    }

    public static int getWidth(TiledMap map){
        return (Integer) map.getProperties().get("width");
    }

    public static int getHeight(TiledMap map){
        return (Integer) map.getProperties().get("height");
    }
}
