package com.shooter.gameworld;

import com.badlogic.gdx.math.Vector2;
import com.shooter.gameobjects.Bullet;
import com.shooter.gameobjects.Enemy;
import com.shooter.player.Statistic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by miraj on 2.6.17.
 */
public class GameInfo implements Serializable{
    private transient GameWorld gameWorld;

    public float gameTime;

    public float lastSpawn;

    public Vector2 playerPosition;
    public float playerAngle;
    public float playerHealth;
    public Statistic playerStatistic = new Statistic();

    public ArrayList<Vector2> enemiesPosition = new ArrayList<Vector2>();
    public ArrayList<Float> enemiesHealth = new ArrayList<Float>();

    public ArrayList<Vector2> bulletsPosition = new ArrayList<Vector2>();
    public ArrayList<Float> bulletsAngle = new ArrayList<Float>();
    public ArrayList<Short> bulletsCategory = new ArrayList<Short>();

    public GameInfo(GameWorld gameWorld){
        gameTime = gameWorld.getGameTime();

        lastSpawn = gameWorld.getSpawn().getLastSpawn();

        playerPosition = gameWorld.getPlayer().getPosition();
        playerAngle = gameWorld.getPlayer().getAngle();
        playerHealth = gameWorld.getPlayer().getHealth();
        playerStatistic = gameWorld.getPlayer().statistic;

        for (Enemy enemy: gameWorld.getEnemies()){
            enemiesPosition.add(enemy.getPosition());
            enemiesHealth.add(enemy.getHealth());
        }

        for (Bullet bullet: gameWorld.getBullets()){
            bulletsPosition.add(bullet.getPosition());
            bulletsAngle.add(bullet.getAngle());
            bulletsCategory.add(bullet.getCategoryBits());
        }
    }
}
