package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.shooter.gameworld.GameWorld;

/**
 * Created by miraj on 19.5.17.
 */
abstract public class GameObject {
    protected Body body;
    protected Fixture fixture;
    protected GameWorld gameWorld;

    public GameObject(GameWorld gameWorld, Vector2 position){
        this.gameWorld = gameWorld;

        body = gameWorld.getWorld().createBody(getDefaultBodyDef());
        fixture = body.createFixture(getDefaultFixtureDef());

        body.setUserData(this);

        setPosition(position);
    }

    public GameWorld getGameWorld(){
        return gameWorld;
    }

    public Body getBody(){
        return body;
    }

    public Vector2 getPosition(){
        return body.getPosition();
    }

    public void setPosition(Vector2 position){
        body.setTransform(position, getAngle());
    }

    public float getAngle(){
        return body.getAngle();
    }

    public void setAngle(float angle){
        body.setTransform(body.getPosition(), angle);
    }

    protected BodyDef getDefaultBodyDef(){
        return null;
    }

    protected FixtureDef getDefaultFixtureDef(){
        return null;
    }
}