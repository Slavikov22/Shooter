package com.shooter.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.shooter.ShooterGame;
import com.shooter.camera.CameraController;
import com.shooter.gameworld.GameController;
import com.shooter.gameworld.GameInfo;
import com.shooter.gameworld.GameRenderer;
import com.shooter.gameworld.GameWorld;
import com.shooter.helpers.CameraHelper;
import com.shooter.player.PlayerController;

/**
 * Created by miraj on 11.3.17.
 */
public class GameScreen implements Screen {
    private final String START_MAP = "maps/Map.tmx";

    private GameWorld world;
    private GameRenderer renderer;

    private CameraController cameraController;

    private InputMultiplexer multiplexer;

    private ShooterGame game;

    public GameScreen(ShooterGame game){
        this.game = game;

        OrthographicCamera camera = CameraHelper.getCamera();

        world = new GameWorld(START_MAP);
        renderer = new GameRenderer(world, camera);

        cameraController = new CameraController(camera);
        cameraController.setMaxX(world.getWidth() - camera.viewportWidth / 2);
        cameraController.setMaxY(world.getHeight() - camera.viewportHeight / 2);

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new PlayerController(world.getPlayer()));
        multiplexer.addProcessor(new GameController(world));
        Gdx.input.setInputProcessor(multiplexer);
    }

    public GameScreen(ShooterGame game, GameInfo gameInfo){
        this(game);
        world.setGameInfo(gameInfo);
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

        if (world.getPlayer().isDead()){
            game.setScreen(new GameOverScreen(game, world.getPlayer().statistic));
        }
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
