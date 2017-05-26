package com.shooter.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.map.GameMap;
import com.shooter.gameobjects.Player;
import com.shooter.helpers.CameraHelper;
import com.shooter.helpers.TiledMapHelper;

/**
 * Created by miraj on 13.3.17.
 */
public class GameWorld {
    private final static float TILE_SIZE = 1.0f;

    private final static float TIME_STEP = 1.0f / 60.0f;

    private final static int VELOCITY_ITERATIONS = 10;
    private final static int POSITION_ITERATIONS = 10;

    private int gameWidth;
    private int gameHeight;

    private World world;
    private TiledMap map;
    private Player player;

    public GameWorld(String mapName){
        map = new TmxMapLoader().load(mapName);

        gameWidth = TiledMapHelper.getWidth(map);
        gameHeight = TiledMapHelper.getHeight(map);

        world = new World(new Vector2(0,0), false);

        player = new Player(world, TiledMapHelper.getPlayerPosition(map));
    }

    public void update(float deltaTime){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        player.update(deltaTime);
    }

    public Player getPlayer(){
        return player;
    }

    public TiledMap getMap(){
        return map;
    }

    public float getWidth(){
        return gameWidth;
    }

    public float getHeight(){
        return gameHeight;
    }

    public float getTileSize(){
        return TILE_SIZE;
    }
}
