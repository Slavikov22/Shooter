package com.shooter.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.shooter.gameworld.GameRenderer;
import com.shooter.gameworld.GameWorld;
import com.shooter.player.PlayerController;

/**
 * Created by miraj on 11.3.17.
 */
public class GameScreen implements Screen {
    private final static float VIEWPORT_WIDTH = 15;
    private final static float VIEWPORT_HEIGHT = 15;

    private final String START_MAP = "maps/Map.tmx";

    private OrthographicCamera camera;

    private GameWorld world;
    private GameRenderer renderer;

    private InputMultiplexer multiplexer;

    public GameScreen(int width, int height){
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(true, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.update();

        world = new GameWorld(START_MAP, camera);
        renderer = new GameRenderer(world, camera);

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new PlayerController(world.getPlayer(), camera));
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
