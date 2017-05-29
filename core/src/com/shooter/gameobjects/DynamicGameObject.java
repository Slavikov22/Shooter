package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class DynamicGameObject extends GameObject{
    public DynamicGameObject(World world, Vector2 position){
        super(world, position);
    }

    public void applyForce(Vector2 force){
        body.applyForceToCenter(force, true);
    }

    public void setLinearVelocity(Vector2 velocity){
        body.setLinearVelocity(velocity);
    }
}
