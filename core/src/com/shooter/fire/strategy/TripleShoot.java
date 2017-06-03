package com.shooter.fire.strategy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.shooter.gameworld.GameWorld;

import java.util.Random;

/**
 * Created by miraj on 3.6.17.
 */
public class TripleShoot implements FireStrategy {
    private final static float INTERVAL_COEF = 2.0f;

    public final static int NUM_BULLETS = 3;

    private GameWorld gameWorld;

    private Sound fireSound = Gdx.audio.newSound(Gdx.files.internal("sounds/triple_pistol.mp3"));

    private float fireInterval = 0;
    private float minInterval = 0;

    public TripleShoot(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }

    @Override
    public boolean fire(Vector2 position, float angle, short bulletCategory) {
        if (fireInterval < minInterval){
            return false;
        }

        fireInterval = 0;

        gameWorld.addBullet(position, angle + (float) ((Math.random() - 0.5f) / 5), bulletCategory);
        gameWorld.addBullet(position, angle + (float) ((Math.random() - 0.5f) / 5), bulletCategory);
        gameWorld.addBullet(position, angle + (float) ((Math.random() - 0.5f) / 5), bulletCategory);

        fireSound.play();
        fireSound.play();
        fireSound.play();

        return true;
    }

    @Override
    public void update(float deltaTime){
        fireInterval += deltaTime;
    }

    @Override
    public void setMinInterval(float interval) {
        minInterval = interval*INTERVAL_COEF;
    }

    @Override
    public int getNumBullets() {
        return NUM_BULLETS;
    }
}
