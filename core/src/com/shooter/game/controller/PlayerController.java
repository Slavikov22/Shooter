package com.shooter.game.controller;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.shooter.game.model.Player;
import com.shooter.game.view.PersonView;

import javax.swing.*;

/**
 * Created by miraj on 10.3.17.
 */
public class PlayerController extends InputAdapter {
    private Player player;
    private PersonView view;

    public PlayerController(Player player, PersonView view){
        this.player = player;
        this.view = view;
    }

    public boolean mouseMoved(int x, int y){

        Vector3 mousePos = new Vector3(x, y, 0);
        view.getCamera().unproject(mousePos);

        player.setRotation(getAngle(mousePos.x, mousePos.y));

        return false;
    }

    private float getAngle(float x, float y){

        double rad = Math.atan((y - player.getY()) / (x - player.getX()));

        rad += 2 * Math.PI;

        if (x < player.getX()){
            rad += Math.PI;
        }

        return (float) Math.toDegrees(rad);
    }
}
