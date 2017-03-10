package com.shooter.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.shooter.game.view.GameMapView;

import javax.swing.*;

/**
 * Created by miraj on 10.3.17.
 */
public class GameMapController extends InputAdapter{

    GameMapView mapView;

    public GameMapController(GameMapView mapView){
        this.mapView = mapView;
    }
}
