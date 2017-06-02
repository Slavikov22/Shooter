package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.gameworld.GameWorld;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by miraj on 30.5.17.
 */
public class Spawn {
    private final static float MIN_INTERVAL = 1.0f;

    private GameWorld gameWorld;
    private ArrayList<Vector2> positions;

    private Random random;

    private float spawnInterval = 0;
    private float lastSpawn = 0;

    public Spawn(GameWorld gameWorld, ArrayList<Vector2> positions){
        this.gameWorld = gameWorld;
        this.positions = positions;

        random = new Random();
    }

    public void update(float deltaTime){
        lastSpawn += deltaTime;
    }

    public Enemy createEnemy(){
        lastSpawn = 0;
        return new Enemy(gameWorld, positions.get(random.nextInt(positions.size())));
    }

    public boolean isReady(){
        return lastSpawn > spawnInterval;
    }

    public void setSpawnInterval(float time){
        spawnInterval = Math.max(time, MIN_INTERVAL);
    }
}
