package com.shooter.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.ShooterGame;
import com.shooter.gameobjects.*;
import com.shooter.helpers.MathHelper;
import com.shooter.helpers.TiledMapHelper;
import com.shooter.listeners.ShootListener;
import com.shooter.removers.GameObjectRemover;
import com.shooter.screens.GameOverScreen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by miraj on 13.3.17.
 */
public class GameWorld {
    private final static float TILE_SIZE = 1.0f;
    private final static float TIME_STEP = 1.0f / 60.0f;
    private final static int VELOCITY_ITERATIONS = 10;
    private final static int POSITION_ITERATIONS = 10;
    private final static float SPAWN_INTERVAL = 5;
    private final static float SPAWN_COEF = 0.1f;
    private final static int MAX_ENEMIES = 50;

    private int gameWidth;
    private int gameHeight;

    private World world;
    private TiledMap map;

    private Player player;

    private Spawn spawn;

    private ArrayList<StaticGameObject> staticObjects;

    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    private GameObjectRemover objectRemover = new GameObjectRemover();

    private float gameTime = 0;

    public GameWorld(String mapName){
        map = TiledMapHelper.getTiledMap(mapName);

        gameWidth = TiledMapHelper.getWidth(map);
        gameHeight = TiledMapHelper.getHeight(map);

        world = new World(new Vector2(0,0), false);

        staticObjects = TiledMapHelper.getStaticObjects(map, this);

        player = new Player(this, TiledMapHelper.getPlayerPosition(map));

        spawn = TiledMapHelper.getSpawn(map, this);
        spawn.setSpawnInterval(SPAWN_INTERVAL);

        world.setContactListener(new ShootListener(this));
    }

    public void setGameInfo(GameInfo gameInfo){
        gameTime = gameInfo.gameTime;

        spawn.setLastSpawn(gameInfo.lastSpawn);

        player.setPosition(gameInfo.playerPosition);
        player.setAngle(gameInfo.playerAngle);
        player.setHealth(gameInfo.playerHealth);
        player.statistic = gameInfo.playerStatistic;

        for (int count = 0; count < gameInfo.enemiesPosition.size(); count++){
            enemies.add(spawn.createEnemy());
            enemies.get(count).setPosition(gameInfo.enemiesPosition.get(count));
            enemies.get(count).setHealth(gameInfo.enemiesHealth.get(count));
        }

        for (int count = 0; count < gameInfo.bulletsPosition.size(); count++){
            addBullet(gameInfo.bulletsPosition.get(count), gameInfo.bulletsAngle.get(count), gameInfo.bulletsCategory.get(count));
        }
    }

    public void update(float deltaTime){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        gameTime += deltaTime;
        spawn.setSpawnInterval(SPAWN_INTERVAL - gameTime*SPAWN_COEF);

        objectRemover.removeAll();

        player.update(deltaTime);

        spawn.update(deltaTime);
        if (spawn.isReady() && enemies.size() < MAX_ENEMIES){
            enemies.add(spawn.createEnemy());
        }

        for (Enemy enemy: enemies){
            enemy.update(deltaTime, player.getPosition());
        }
    }

    public void addBullet(Vector2 position, float angle, short category){
        bullets.add(new Bullet(this, position, angle, category));
    }

    public World getWorld(){
        return world;
    }

    public float getGameTime(){
        return gameTime;
    }

    public void setGameTime(float time){
        gameTime = time;
    }

    public Player getPlayer(){
        return player;
    }

    public Spawn getSpawn(){
        return spawn;
    }

    public ArrayList<Enemy> getEnemies(){
        return enemies;
    }

    public ArrayList<Bullet> getBullets(){
        return bullets;
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

    public GameObjectRemover getObjectRemover(){
        return objectRemover;
    }
}
