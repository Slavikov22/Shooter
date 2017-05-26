package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class StaticGameObject extends GameObject{
    public StaticGameObject(World world, Vector2 position){
        super(world, position);
    }
}
