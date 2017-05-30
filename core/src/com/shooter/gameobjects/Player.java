package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 19.5.17.
 */
public class Player extends Person {
    private final static float FORCE = 200.0f;
    private final static float FIRE_INTERVAL = 0.5f;

    public boolean isMovedUp;
    public boolean isMovedLeft;
    public boolean isMovedDown;
    public boolean isMovedRight;

    public Player(World world, Vector2 position){
        super(world, position);

        Filter filter = new Filter();
        filter.categoryBits = EntityCategory.PLAYER;
        filter.maskBits = EntityCategory.STATIC | EntityCategory.ENEMY | EntityCategory.ENEMY_BULLET;

        fixture.setFilterData(filter);

        minFireInterval = FIRE_INTERVAL;
    }

    @Override
    public void update(float deltaTime){
        super.update(deltaTime);

        if (isMovedUp){
            applyForce(new Vector2(0, -FORCE));
        }
        if (isMovedLeft){
            applyForce(new Vector2(-FORCE, 0));
        }
        if (isMovedDown){
            applyForce(new Vector2(0, FORCE));
        }
        if (isMovedRight){
            applyForce(new Vector2(FORCE, 0));
        }
    }
}
