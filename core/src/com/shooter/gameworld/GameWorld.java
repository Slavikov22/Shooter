package com.shooter.gameworld;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.gameobjects.*;
import com.shooter.helpers.TiledMapHelper;

import java.util.ArrayList;

/**
 * Created by miraj on 13.3.17.
 */
public class GameWorld {
    private final static float TILE_SIZE = 1.0f;
    private final static float TIME_STEP = 1.0f / 60.0f;
    private final static int VELOCITY_ITERATIONS = 10;
    private final static int POSITION_ITERATIONS = 10;
    private final static float SPAWN_INTERVAL = 5;

    private int gameWidth;
    private int gameHeight;

    private World world;
    private TiledMap map;
    private Player player;
    private Spawn spawn;
    private ArrayList<Enemy> enemies;

    private ArrayList<StaticGameObject> staticObjects;

    public GameWorld(String mapName){
        map = TiledMapHelper.getTiledMap(mapName);

        gameWidth = TiledMapHelper.getWidth(map);
        gameHeight = TiledMapHelper.getHeight(map);

        world = new World(new Vector2(0,0), false);

        staticObjects = TiledMapHelper.getStaticObjects(map, world);

        player = new Player(world, TiledMapHelper.getPlayerPosition(map));

        enemies = new ArrayList<Enemy>();

        spawn = TiledMapHelper.getSpawn(map, world);
        spawn.setSpawnInterval(SPAWN_INTERVAL);
    }

    public void update(float deltaTime){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);

        player.update(deltaTime);

        spawn.update(deltaTime);
        if (spawn.isReady()){
            enemies.add(spawn.createEnemy());
        }

        for (Enemy enemy: enemies){
            enemy.update(deltaTime, player.getPosition());
        }
    }

    public World getWorld(){
        return world;
    }

    public Player getPlayer(){
        return player;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
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
}
