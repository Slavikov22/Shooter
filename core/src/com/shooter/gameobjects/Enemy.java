package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 30.5.17.
 */
public class Enemy extends Person {
    private final static float FORCE = 15.0f;
    private final static float FIRE_INTERVAL = 1.0f;
    private final static float MOVE_RANGE = 5.0f;
    private final static float FIRE_RANGE = 7.0f;

    public Enemy(World world, Vector2 position){
        super(world, position);

        minFireInterval = FIRE_INTERVAL;
    }

    public void update(float deltaTime, Vector2 position){
        super.update(deltaTime);

        if (MathHelper.getRange(getPosition().x, getPosition().y, position.x, position.y) > MOVE_RANGE) {
            moveTo(position);
        }

        if (MathHelper.getRange(getPosition().x, getPosition().y, position.x, position.y) < FIRE_RANGE){
            fire(EntityCategory.ENEMY_BULLET);
        }
    }

    public void moveTo(Vector2 position){
        setAngle(MathHelper.getAngle(getPosition().x, getPosition().y, position.x, position.y));
        Vector2 force = MathHelper.getVector2byAngle(getAngle(), FORCE);
        applyForce(force);
    }
}
