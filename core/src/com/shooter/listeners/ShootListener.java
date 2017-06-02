package com.shooter.listeners;

import com.badlogic.gdx.physics.box2d.*;
import com.shooter.gameobjects.Bullet;
import com.shooter.gameobjects.Enemy;
import com.shooter.gameobjects.Person;
import com.shooter.gameobjects.Player;
import com.shooter.gameworld.GameWorld;

/**
 * Created by miraj on 31.5.17.
 */
public class ShootListener implements ContactListener {
    private GameWorld gameWorld;

    public ShootListener(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }

    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        if (!fixtureA.isSensor() && !fixtureB.isSensor()){
            return;
        }

        if (fixtureB.isSensor()){
            Fixture temp = fixtureA;
            fixtureA = fixtureB;
            fixtureB = temp;
        }

        if (fixtureB.getBody().getUserData() instanceof Enemy){
            Person person = (Person) fixtureB.getBody().getUserData();
            person.reduceHealth(5.0f);

            gameWorld.getPlayer().statistic.hits += 1;
        }

        if(fixtureB.getBody().getUserData() instanceof Player){
            Player player = (Player) fixtureB.getBody().getUserData();
            player.reduceHealth(15.0f);
        }

        gameWorld.getObjectRemover().add((Bullet) fixtureA.getBody().getUserData());
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }
}
