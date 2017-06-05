package com.shooter.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 24.5.17.
 */
public class CameraHelper {
    private final static float VIEWPORT_WIDTH = 20;
    private final static float VIEWPORT_HEIGHT = 20;

    private static OrthographicCamera camera;

    public static OrthographicCamera getCamera(){
        if (camera == null){
            camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            camera.setToOrtho(true, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
            camera.update();
        }

        return camera;
    }

    public static float getOffsetX(){
        return camera.position.x - camera.viewportWidth / 2;
    }

    public static float getOffsetY(){
        return camera.position.y - camera.viewportHeight / 2;
    }

    public static Vector2 project(Vector2 position){
        float coefX = Gdx.graphics.getWidth() / camera.viewportWidth;
        float coefY = Gdx.graphics.getHeight() / camera.viewportHeight;

        return new Vector2(position.x * coefX, position.y * coefY);
    }

    public static Vector2 unproject(Vector2 position){
        float coefX = Gdx.graphics.getWidth() / camera.viewportWidth;
        float coefY = Gdx.graphics.getHeight() / camera.viewportHeight;

        return new Vector2(position.x / coefX, position.y / coefY);
    }
}
