package com.shooter.game.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 5.3.17.
 */
public abstract class Person {
    public final static float RADIUS = 0.6f;
    public final static float DAMPING = 30.0f;

    private Fixture physicsFixture;
    public Body body;

    public Person(World world){
        initPhysics(world);
    }

    public void update(){
        //body.setLinearVelocity(velocity);
        //position = body.getPosition();
    }

    public Vector2 getVelocity(){
        return body.getLinearVelocity();
    }

    public void setVelocity(Vector2 velocity){
        body.setLinearVelocity(velocity);
    }

    public void setVelocity(float x, float y){
        setVelocity(new Vector2(x, y));
    }

    public Vector2 getPosition(){
        return body.getPosition();
    }

    public void setPosition(Vector2 position){
        body.getPosition().set(position);
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

    public void applyForce(float forceX, float forceY){
        body.applyForceToCenter(forceX, forceY, true);
    }

    private void initPhysics(World world){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.linearDamping = DAMPING;

        body = world.createBody(bd);

        CircleShape circle = new CircleShape();
        circle.setRadius(RADIUS);
        physicsFixture = body.createFixture(circle, 1);
        circle.dispose();

        body.setBullet(true);
    }
}
