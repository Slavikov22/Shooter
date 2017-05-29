package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by miraj on 30.5.17.
 */
public class Enemy extends Person {
    public Enemy(World world, Vector2 position){
        super(world, position);
    }
}
