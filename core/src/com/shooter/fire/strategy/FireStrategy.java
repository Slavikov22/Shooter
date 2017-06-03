package com.shooter.fire.strategy;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 3.6.17.
 */
public interface FireStrategy {
    public boolean fire(Vector2 position, float angle, short bulletCategory);

    public void update(float deltaTime);

    public void setMinInterval(float interval);

    public int getNumBullets();
}
