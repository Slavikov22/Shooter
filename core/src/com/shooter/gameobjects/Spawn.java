package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by miraj on 30.5.17.
 */
public class Spawn {
    private World world;
    private ArrayList<Vector2> positions;

    private Random random;

    private float spawnInterval = 0;
    private float lastSpawn = 0;

    public Spawn(World world, ArrayList<Vector2> positions){
        this.world = world;
        this.positions = positions;

        random = new Random();
    }

    public void update(float deltaTime){
        lastSpawn += deltaTime;
    }

    public Enemy createEnemy(){
        lastSpawn = 0;
        return new Enemy(world, positions.get(random.nextInt(positions.size())));
    }

    public boolean isReady(){
        return lastSpawn > spawnInterval;
    }

    public void setSpawnInterval(float time){
        spawnInterval = time;
    }
}
