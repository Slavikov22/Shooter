package com.shooter.game.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.camera.CameraController;
import com.shooter.game.objects.Player;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 19.5.17.
 */
public final class PlayerController extends InputAdapter {
    private Player player;
    private CameraController cameraController;

    public PlayerController(World world, CameraController cameraController){
        this.player = new Player(world, cameraController, new Vector2(0,0));
        this.cameraController = cameraController;
    }

    public boolean mouseMoved(int x, int y){
        Vector3 mousePos = new Vector3(x, y, 0);
        cameraController.getCamera().unproject(mousePos);

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
