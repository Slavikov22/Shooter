package com.shooter.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.shooter.gameworld.GameWorld;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class Person extends DynamicGameObject {
    private final static float RADIUS = 0.5f;
    private final static float LINEAR_DAMPING = 30.0f;

    protected float minFireInterval = 0;
    protected float fireInterval = 0;

    protected float health;

    protected Sound fireSound = Gdx.audio.newSound(Gdx.files.internal("sounds/pistol_shoot.mp3"));

    public Person(GameWorld gameWorld, Vector2 position){
        super(gameWorld, position);
    }

    public void update(float deltaTime){
        fireInterval += deltaTime;
    }

    public boolean fire(short bulletCategory){
        if (fireInterval < minFireInterval){
            return false;
        }

        fireInterval = 0;

        gameWorld.addBullet(getPosition(), getAngle(), bulletCategory);

        fireSound.play();

        return true;
    }

    public float getHealth(){
        return health;
    }

    public void reduceHealth(float deltaHealth){
        health -= deltaHealth;
    }

    @Override
    protected BodyDef getDefaultBodyDef(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.linearDamping = LINEAR_DAMPING;
        bd.fixedRotation = true;
        bd.bullet = false;

        return bd;
    }

    @Override
    protected FixtureDef getDefaultFixtureDef(){
        FixtureDef fd = new FixtureDef();
        CircleShape circle = new CircleShape();
        circle.setRadius(RADIUS);
        fd.shape = circle;
        fd.density = 1;

        return fd;
    }
}
