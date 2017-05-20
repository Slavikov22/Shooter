package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class DynamicGameObject extends GameObject{
    public DynamicGameObject(World world, float posX, float posY){
        super(world, posX, posY);
    }

    public void applyForce(Vector2 force){
        body.applyForceToCenter(force, true);
    }
}
