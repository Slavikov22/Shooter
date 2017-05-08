package com.shooter.game.controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by miraj on 8.5.17.
 */
public class CameraController extends InputAdapter
{
    private OrthographicCamera camera;

    public CameraController(int width, int height){
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false, 20, 20);
        camera.update();
    }

    public OrthographicCamera getCamera(){
        return camera;
    }
}
