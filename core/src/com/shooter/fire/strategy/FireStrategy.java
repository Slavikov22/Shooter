package com.shooter.fire.strategy;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 3.6.17.
 */
public interface FireStrategy {
    boolean fire(Vector2 position, float angle, short bulletCategory);

    void update(float deltaTime);

    void setMinInterval(float interval);

    int getNumBullets();
}
