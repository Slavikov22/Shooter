package com.shooter.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.shooter.game.model.Player;
import com.shooter.game.view.PersonView;

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

    public boolean keyDown(int keycode){
        switch (keycode){
            case Input.Keys.W:
                player.getVelocity().y = player.SPEED;
                break;
            case Input.Keys.S:
                player.getVelocity().y = -player.SPEED;
                break;
            case Input.Keys.A:
                player.getVelocity().x = -player.SPEED;
                break;
            case Input.Keys.D:
                player.getVelocity().x = player.SPEED;
                break;
        }

        return false;
    }

    public boolean keyUp(int keycode){
        switch (keycode){
            case Input.Keys.W:
                player.getVelocity().y = 0;
                break;
            case Input.Keys.S:
                player.getVelocity().y = 0;
                break;
            case Input.Keys.A:
                player.getVelocity().x = 0;
                break;
            case Input.Keys.D:
                player.getVelocity().x = 0;
                break;
        }

        return false;
    }

    public boolean mouseMoved(int x, int y){

        Vector3 mousePos = new Vector3(x, y, 0);
        view.getCamera().unproject(mousePos);

        player.setRotation(getAngle(mousePos.x, mousePos.y));

        return false;
    }

    private float getAngle(float x, float y){

        double rad = Math.atan((y - player.getPosition().y) / (x - player.getPosition().x));

        rad += 2 * Math.PI;

        if (x < player.getPosition().x){
            rad += Math.PI;
        }

        return (float) Math.toDegrees(rad);
    }
}
