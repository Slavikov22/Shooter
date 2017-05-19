package com.shooter.game.camera;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by miraj on 8.5.17.
 */
public class CameraController extends InputAdapter
{
    private final int WIDTH = 15;

    private OrthographicCamera camera;

    public CameraController(int width, int height){
        camera = new OrthographicCamera(width, height);
        Viewport viewport = new StretchViewport(WIDTH, WIDTH, camera);
        viewport.apply();
        //camera.setToOrtho(false, 15, 15);
        camera.update();
    }

    public OrthographicCamera getCamera(){
        return camera;
    }

    public void setPosition(float x, float y){
        camera.position.set(x, y, 0);
        camera.update();
    }

    public void setPosition(Vector2 position){
        setPosition(position.x, position.y);
    }
}
