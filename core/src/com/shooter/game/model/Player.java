package com.shooter.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by miraj on 10.3.17.
 */
public class Player extends Person {

    private final float FORCE = 150.0f;

    private final static Vector2 START_POSITION = new Vector2(2.0f,2.0f);

    public boolean isMovedUp;
    public boolean isMovedLeft;
    public boolean isMovedDown;
    public boolean isMovedRight;

    public Player(World world){
        super(world);
        setPosition(START_POSITION);

        isMovedUp = false;
        isMovedLeft = false;
        isMovedDown = false;
        isMovedRight = false;
    }

    public void update(){
        System.out.println(getPosition().x);

        if (isMovedUp){
            applyForce(0, FORCE);
        }
        if (isMovedLeft){
            applyForce(-FORCE, 0);
        }
        if (isMovedDown){
            applyForce(0, -FORCE);
        }
        if (isMovedRight){
            applyForce(FORCE, 0);
        }
    }
}
