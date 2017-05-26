package com.shooter.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.shooter.camera.CameraController;
import com.shooter.gameworld.GameRenderer;
import com.shooter.gameworld.GameWorld;
import com.shooter.helpers.CameraHelper;
import com.shooter.player.PlayerController;

/**
 * Created by miraj on 11.3.17.
 */
public class GameScreen implements Screen {
    private final static float VIEWPORT_WIDTH = 15;
    private final static float VIEWPORT_HEIGHT = 15;

    private final String START_MAP = "maps/Map.tmx";

    private GameWorld world;
    private GameRenderer renderer;

    private CameraController cameraController;

    private InputMultiplexer multiplexer;

    public GameScreen(){
        OrthographicCamera camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.update();

        cameraController = new CameraController(camera);
        CameraHelper.setCamera(camera);

        world = new GameWorld(START_MAP);

        cameraController.setMaxX(world.getWidth() - camera.viewportWidth / 2);
        cameraController.setMaxY(world.getHeight() - camera.viewportHeight / 2);

        renderer = new GameRenderer(world, camera);

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new PlayerController(world.getPlayer()));
        Gdx.input.setInputProcessor(multiplexer);

    }

    @Override
    public void show(){

    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.update(deltaTime);
        cameraController.update(world.getPlayer().getPosition());

        renderer.render();
    }

    @Override
    public void resize(int width, int height){

    }

    @Override
    public void hide(){

    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void dispose(){

    }
}
