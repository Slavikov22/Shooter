package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.shooter.gameworld.GameWorld;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class DynamicGameObject extends GameObject{
    public DynamicGameObject(GameWorld gameWorld, Vector2 position){
        super(gameWorld, position);
    }

    public void applyForce(Vector2 force){
        body.applyForceToCenter(force, true);
    }

    public void setLinearVelocity(Vector2 velocity){
        body.setLinearVelocity(velocity);
    }
}
