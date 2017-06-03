package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.fire.strategy.SingleShoot;
import com.shooter.gameworld.GameWorld;
import com.shooter.helpers.MathHelper;
import com.shooter.player.Statistic;

/**
 * Created by miraj on 19.5.17.
 */
public class Player extends Person {
    private final static float FORCE = 200.0f;

    public final static float MIN_FIRE_INTERVAL = 0.4f;
    public final static float MAX_HEALTH = 250.0f;

    public boolean isMovedUp;
    public boolean isMovedLeft;
    public boolean isMovedDown;
    public boolean isMovedRight;

    public Statistic statistic = new Statistic();

    public Player(GameWorld gameWorld, Vector2 position){
        super(gameWorld, position);

        health = MAX_HEALTH;

        Filter filter = new Filter();
        filter.categoryBits = EntityCategory.PLAYER;
        filter.maskBits = EntityCategory.STATIC | EntityCategory.ENEMY | EntityCategory.ENEMY_BULLET;

        fixture.setFilterData(filter);

        setFireStrategy(new SingleShoot(gameWorld), MIN_FIRE_INTERVAL);
    }

    @Override
    public void update(float deltaTime){
        super.update(deltaTime);

        statistic.leave_time += deltaTime;

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

    @Override
    public boolean fire(short bulletCategory){
        if (super.fire(bulletCategory)){
            statistic.shoots += fireStrategy.getNumBullets();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isDead(){
        return health <= 0;
    }
}
