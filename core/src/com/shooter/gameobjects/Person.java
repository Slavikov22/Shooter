package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 19.5.17.
 */
public class Person extends DynamicGameObject {
    public final static float RADIUS = 0.6f;

    private final static float LINEAR_DAMPING = 30.0f;

    public Person(World world, Vector2 position){
        super(world, position);
    }

    @Override
    protected BodyDef getDefaultBodyDef(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.linearDamping = LINEAR_DAMPING;
        bd.fixedRotation = true;
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
