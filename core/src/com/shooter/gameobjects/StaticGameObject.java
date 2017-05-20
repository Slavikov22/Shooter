package com.shooter.gameobjects;

import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class StaticGameObject extends GameObject{
    public StaticGameObject(World world, float posX, float posY){
        super(world, posX, posY);
    }
}
