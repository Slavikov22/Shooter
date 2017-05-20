package com.shooter.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.shooter.gameobjects.Player;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 19.5.17.
 */
public final class PlayerController extends InputAdapter {
    private Player player;
    private OrthographicCamera camera;

    public PlayerController(Player player, OrthographicCamera camera){
        this.player = player;
        this.camera = camera;
    }

    public boolean mouseMoved(int x, int y){
        Vector3 mousePos = new Vector3(x, y, 0);
        camera.unproject(mousePos);

        player.setAngle(MathHelper.getAngle(player.getPosition().x, player.getPosition().y, mousePos.x, mousePos.y));
        return false;
    }

    public boolean keyDown (int keycode){
        switch (keycode) {
            case Input.Keys.W:
                player.isMovedUp = true;
                break;
            case Input.Keys.A:
                player.isMovedLeft = true;
                break;
            case Input.Keys.S:
                player.isMovedDown = true;
                break;
            case Input.Keys.D:
                player.isMovedRight = true;
                break;
        }

        return false;
    }

    public boolean keyUp (int keycode){
        switch (keycode){
            case Input.Keys.W:
                player.isMovedUp = false;
                break;
            case Input.Keys.A:
                player.isMovedLeft = false;
                break;
            case Input.Keys.S:
                player.isMovedDown = false;
                break;
            case Input.Keys.D:
                player.isMovedRight = false;
                break;
        }

        return false;
    }

    public Player getPlayer(){
        return player;
    }
}
