package com.shooter.gameobjects;

import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 19.5.17.
 */
public class Person extends DynamicGameObject {
    private final static float RADIUS = 0.6f;
    private final static float DAMPING = 30.0f;

    private float startPosX;
    private float startPosY;

    public Person(World world, float posX, float posY){
        super(world, posX, posY);
    }

    @Override
    protected BodyDef getDefaultBodyDef(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.linearDamping = DAMPING;
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
