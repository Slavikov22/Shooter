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
    private World world;

    private Player player;
    private PlayerView playerView;
    private PlayerController playerController;

    private GameMapView gameMapView;
    private GameMapController gameMapController;

    private OrthographicCamera camera;

    public GameWorld(){
        world = new World(new Vector2(0,0), false);
    }

    public void update(){
        world.step(1.0f / 60.0f, 10, 10);

        player.update();
    }

    public void render(){
        gameMapView.render();
        playerView.render();
    }

    public void initPlayer(){
        player = new Player();
        player.initPhysics(world);

        playerView = new PlayerView(player, world);
        playerView.setCamera(camera);

        playerController = new PlayerController(player, playerView);
    }

    public void initGameMap(){
        gameMapView = new GameMapView();
        gameMapView.setCamera(camera);

        gameMapController = new GameMapController(gameMapView);
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public Array<InputProcessor> getProcessors(){
        Array<InputProcessor> processors = new Array<InputProcessor>();
        processors.add(playerController);
        processors.add(gameMapController);
        return processors;
    }
}
