package com.shooter.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.camera.CameraController;

/**
 * Created by miraj on 19.5.17.
 */
public class DynamicGameObject extends GameObject{
    public DynamicGameObject(World world, CameraController cameraController, Vector2 position){
        super(world, cameraController, position);
    }

    public void applyForce(float forceX, float forceY){
        body.applyForceToCenter(forceX, forceY, true);
    }

    protected Body getDefaultBody(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.position.set(position);

        return world.createBody(bd);
    }
}
