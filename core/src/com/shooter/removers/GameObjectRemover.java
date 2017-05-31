package com.shooter.removers;

import com.shooter.gameobjects.Bullet;
import com.shooter.gameobjects.Enemy;
import com.shooter.gameobjects.GameObject;
import com.shooter.gameworld.GameWorld;

import java.util.HashSet;

/**
 * Created by miraj on 31.5.17.
 */
public class GameObjectRemover {
    private HashSet<GameObject> objects = new HashSet<GameObject>();

    public void add(GameObject object){
        objects.add(object);
    }

    public void removeAll(){
        for (GameObject object: objects){
            GameWorld gameWorld = object.getGameWorld();

            gameWorld.getWorld().destroyBody(object.getBody());

            if (object instanceof Bullet){
                gameWorld.getBullets().remove(object);
            }
            else if (object instanceof Enemy){
                gameWorld.getEnemies().remove(object);
            }
        }

        objects.clear();
    }
}
