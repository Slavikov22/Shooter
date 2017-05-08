package com.shooter.game.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * Created by miraj on 5.3.17.
 */
public class GameMap
{
    TiledMap map;

    public GameMap(){
        map = new TmxMapLoader().load("TileMaps/start.tmx");
    }

    public TiledMap getMap(){
        return map;
    }
}
