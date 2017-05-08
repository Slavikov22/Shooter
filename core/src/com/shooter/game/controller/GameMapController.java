package com.shooter.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.shooter.game.model.GameMap;
import com.shooter.game.view.GameMapView;

import javax.swing.*;

/**
 * Created by miraj on 10.3.17.
 */
public class GameMapController extends InputAdapter
{
    GameMap map;
    GameMapView view;

    public GameMapController(OrthographicCamera camera){
        map = new GameMap();
        view = new GameMapView(map, camera);
    }

    public void render(){
        view.render();
    }
}
