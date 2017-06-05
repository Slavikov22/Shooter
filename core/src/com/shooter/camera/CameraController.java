package com.shooter.camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 25.5.17.
 */
public class CameraController {
    private OrthographicCamera camera;

    private float minX;
    private float minY;

    private float maxX;
    private float maxY;

    private float screenWidth;
    private float screenHeight;

    public CameraController(OrthographicCamera camera){
        this.camera = camera;

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();

        minX = camera.viewportWidth / 2;
        minY = camera.viewportHeight / 2;

        maxX = Float.MAX_VALUE;
        maxY = Float.MAX_VALUE;
    }

    public void update(Vector2 position){
        Vector2 temp = new Vector2(position);

        temp.x = Math.max(minX, temp.x);
        temp.x = Math.min(maxX, temp.x);

        temp.y = Math.max(minY, temp.y);
        temp.y = Math.min(maxY, temp.y);

        camera.position.set(temp.x, temp.y, 0);
        camera.update();
    }

    public void setMaxX(float x){
        maxX = x;
    }

    public void setMaxY(float y){
        maxY = y;
    }

}
