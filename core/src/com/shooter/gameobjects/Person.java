package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 19.5.17.
 */
public abstract class Person extends DynamicGameObject {
    private final static float RADIUS = 0.5f;
    private final static float LINEAR_DAMPING = 30.0f;
    private final static float BULLET_VELOCITY = 150.0f;

    public float minFireInterval = 0;
    protected float fireInterval = 0;

    public Person(World world, Vector2 position){
        super(world, position);
    }

    public void update(float deltaTime){
        fireInterval += deltaTime;
    }

    public boolean fire(short bulletCategory){
        if (fireInterval < minFireInterval){
            return false;
        }

        fireInterval = 0;

        Vector2 position = new Vector2(getPosition());
        Bullet bullet = new Bullet(world, position, bulletCategory);
        bullet.setLinearVelocity(MathHelper.getVector2byAngle(getAngle(), BULLET_VELOCITY));

        return true;
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
