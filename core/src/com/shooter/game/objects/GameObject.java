package com.shooter.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.camera.CameraController;
import com.shooter.game.objects.Views.View;

/**
 * Created by miraj on 19.5.17.
 */
abstract public class GameObject {
    protected Body body;
    protected Fixture fixture;
    protected World world;

    protected View view;
    protected CameraController cameraController;
    protected Vector2 position;

    public GameObject(World world, CameraController cameraController, Vector2 position){
        this.world = world;
        this.cameraController = cameraController;
        this.position = position;

        this.body = getDefaultBody();
        this.fixture = getDefaultFixture();
    }

    public void render(){
        view.render();
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

    protected Body getDefaultBody(){
        return null;
    }

    protected Fixture getDefaultFixture(){
        return null;
    }
}