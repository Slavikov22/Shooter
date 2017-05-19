package com.shooter.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.shooter.game.camera.CameraController;

/**
 * Created by miraj on 19.5.17.
 */
public class Person extends DynamicGameObject{
    private final static float RADIUS = 0.6f;
    private final static float DAMPING = 30.0f;

    public Person(World world, CameraController cameraController, Vector2 position){
        super(world, cameraController, position);
    }

    @Override
    protected Body getDefaultBody(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.linearDamping = DAMPING;

        return world.createBody(bd);
    }

    @Override
    protected Fixture getDefaultFixture(){
        CircleShape circle = new CircleShape();
        circle.setRadius(RADIUS);
        fixture = body.createFixture(circle, 1);
        circle.dispose();

        return fixture;
    }
}
