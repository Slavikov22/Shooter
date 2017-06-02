package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.gameworld.GameWorld;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 30.5.17.
 */
public class Enemy extends Person {
    private final static float FORCE = 200.0f;
    private final static float FIRE_INTERVAL = 1.0f;
    private final static float MOVE_RANGE = 5.0f;
    private final static float FIRE_RANGE = 7.0f;
    public final static float MAX_HEALTH = 20.0f;

    public Enemy(GameWorld gameWorld, Vector2 position){
        super(gameWorld, position);

        health = MAX_HEALTH;

        minFireInterval = FIRE_INTERVAL;
    }

    public void update(float deltaTime, Vector2 position){
        super.update(deltaTime);

        if (health <= 0){
            gameWorld.getObjectRemover().add(this);
            return;
        }

        Filter filter = new Filter();
        filter.categoryBits = EntityCategory.ENEMY;
        filter.maskBits = EntityCategory.STATIC | EntityCategory.ENEMY | EntityCategory.PLAYER_BULLET;

        fixture.setFilterData(filter);

        setAngle(MathHelper.getAngle(getPosition().x, getPosition().y, position.x, position.y));

        if (MathHelper.getRange(getPosition().x, getPosition().y, position.x, position.y) > MOVE_RANGE) {
            moveTo(position);
        }

        if (MathHelper.getRange(getPosition().x, getPosition().y, position.x, position.y) < FIRE_RANGE){
            fire(EntityCategory.ENEMY_BULLET);
        }
    }

    public void moveTo(Vector2 position){
        float angle = MathHelper.getAngle(getPosition().x, getPosition().y, position.x, position.y);
        applyForce(MathHelper.getVector2byAngle(angle, FORCE));
    }
}
