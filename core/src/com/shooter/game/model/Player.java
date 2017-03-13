package com.shooter.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by miraj on 10.3.17.
 */
public class Player extends Person {

    private final static Vector2 START_POSITION = new Vector2(30,30);

    Player(){
        super(START_POSITION);
    }
}
