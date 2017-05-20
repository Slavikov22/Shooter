package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 19.5.17.
 */
abstract public class GameObject {
    protected Body body;
    protected Fixture fixture;
    protected World world;

    public GameObject(World world, float posX, float posY){
        this.world = world;

        this.body = world.createBody(getDefaultBodyDef());
        this.fixture = body.createFixture(getDefaultFixtureDef());

        setPosition(posX, posY);
    }

    public Vector2 getPosition(){
        return body.getPosition();
    }

    public void setPosition(Vector2 position){
        body.setTransform(position, 0);
    }

    public void setPosition(float x, float y){
        setPosition(new Vector2(x, y));
    }

    public float getAngle(){
        return body.getAngle();
    }

    public void setAngle(float angle){
        body.setTransform(body.getPosition(), angle);
    }

    public float getMass(){
        return body.getMassData().mass;
    }

    protected BodyDef getDefaultBodyDef(){
        return null;
    }

    protected FixtureDef getDefaultFixtureDef(){
        return null;
    }
}