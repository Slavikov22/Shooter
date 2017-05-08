package com.shooter.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.shooter.game.controller.GameMapController;
import com.shooter.game.controller.PlayerController;
import com.shooter.game.view.GameMapView;
import com.shooter.game.view.PlayerView;

/**
 * Created by miraj on 13.3.17.
 */
public class GameWorld {
    private final static float TIME_STEP = 1.0f / 60.0f;

    private final static int VELOCITY_ITERATIONS = 10;
    private final static int POSITION_ITERATIONS = 10;

    private World world;

    private OrthographicCamera camera;

    private PlayerController playerController;

    private GameMapController gameMapController;

    public GameWorld(OrthographicCamera camera){
        this.camera = camera;

        world = new World(new Vector2(0,0), false);

        playerController = new PlayerController(world, this.camera);
        gameMapController = new GameMapController(this.camera);
    }

    public void update(){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    public void render(){
        gameMapController.render();
        playerController.render();
    }

    public Array<InputProcessor> getInputProcessors(){
        Array<InputProcessor> processors = new Array<InputProcessor>();
        processors.add(playerController);
        processors.add(gameMapController);
        return processors;
    }
}
