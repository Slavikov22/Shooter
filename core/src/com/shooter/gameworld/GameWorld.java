package com.shooter.gameworld;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.gameobjects.Bullet;
import com.shooter.gameobjects.Player;
import com.shooter.gameobjects.StaticGameObject;
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

    private int gameWidth;
    private int gameHeight;

    private World world;
    private TiledMap map;
    private Player player;

    private ArrayList<StaticGameObject> staticObjects;

    private ArrayList<Bullet> bullets;

    public GameWorld(String mapName){
        map = TiledMapHelper.getTiledMap(mapName);

        gameWidth = TiledMapHelper.getWidth(map);
        gameHeight = TiledMapHelper.getHeight(map);

        world = new World(new Vector2(0,0), false);

        player = new Player(world, TiledMapHelper.getPlayerPosition(map));

        staticObjects = TiledMapHelper.getStaticObjects(map, world);

        bullets = new ArrayList<Bullet>();
    }

    public void update(float deltaTime){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        player.update(deltaTime);
    }

    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }

    public World getWorld(){
        return world;
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
