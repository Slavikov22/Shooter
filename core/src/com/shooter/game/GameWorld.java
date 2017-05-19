package com.shooter.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.shooter.game.camera.CameraController;
import com.shooter.game.map.GameMap;
import com.shooter.game.player.PlayerController;

/**
 * Created by miraj on 13.3.17.
 */
public class GameWorld {
    private final static float TIME_STEP = 1.0f / 60.0f;

    private final static int VELOCITY_ITERATIONS = 4;
    private final static int POSITION_ITERATIONS = 4;

    private World world;

    private GameMap gameMap;

    private CameraController cameraController;

    private PlayerController playerController;

    public GameWorld(String mapName, CameraController cameraController){
        this.cameraController = cameraController;

        world = new World(new Vector2(0,0), false);

        playerController = new PlayerController(world, this.cameraController);
        gameMap = new GameMap(mapName, cameraController.getCamera());
    }

    public void update(){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);

        cameraController.setPosition(playerController.getPlayer().getPosition());
    }

    public void render(){
        gameMap.render();
        playerController.getPlayer().render();
    }

    public Array<InputProcessor> getInputProcessors(){
        Array<InputProcessor> processors = new Array<InputProcessor>();
        processors.add(playerController);
        return processors;
    }
}
