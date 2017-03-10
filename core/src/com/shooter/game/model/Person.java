package com.shooter.game.model;

import com.badlogic.gdx.math.Vector2;
import com.shooter.game.view.PersonView;

/**
 * Created by miraj on 5.3.17.
 */
public abstract class Person {

    protected float rotation;

    protected Vector2 position;

    public Person(Vector2 position){
        this.position = position;
    }

    public void setRotation(float degrees){
        this.rotation = degrees;
    }

    public float getRotation(){
        return rotation;
    }

    public float getX(){
        return position.x;
    }

    public float getY(){
        return position.y;
    }
}
