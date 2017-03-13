package com.shooter.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 5.3.17.
 */
public abstract class Person {
    public final static float SPEED = 100;
    public final static int RADIUS = 30;

    private Fixture physicsFixture;
    private Body body;

    private float rotation;

    private Vector2 position;
    private Vector2 velocity;

    Person(Vector2 position){
        this.position = position;
    }

    public void update(){
        body.setLinearVelocity(velocity);
        position = body.getPosition();
    }

    public Vector2 getVelocity(){
        return velocity;
    }

    public void initPhysics(World world){
        velocity = new Vector2(0,0);

        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bd);
        body.setTransform(position.x, position.y, 0);
        body.setFixedRotation(true);

        CircleShape circle = new CircleShape();
        circle.setRadius(RADIUS);
        physicsFixture = body.createFixture(circle, 1);
        circle.dispose();

        body.setBullet(true);
    }

    public Vector2 getPosition(){
        return position;
    }

    public float getRotation(){
        return rotation;
    }

    public void setRotation(float degrees){
        this.rotation = degrees;
    }
}
