package com.shooter.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.shooter.fire.strategy.SingleShoot;
import com.shooter.fire.strategy.TripleShoot;
import com.shooter.gameobjects.EntityCategory;
import com.shooter.gameobjects.Player;
import com.shooter.helpers.CameraHelper;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 19.5.17.
 */
public final class PlayerController extends InputAdapter {
    private Player player;

    private Sound changeWeapon = Gdx.audio.newSound(Gdx.files.internal("sounds/change_pistol.mp3"));

    public PlayerController(Player player){
        this.player = player;
    }

    public boolean mouseMoved(int x, int y){
        Vector2 mousePos = CameraHelper.unproject(new Vector2(x, y));

        mousePos.x += CameraHelper.getOffsetX();
        mousePos.y += CameraHelper.getOffsetY();

        player.setAngle(MathHelper.getAngle(player.getPosition().x, player.getPosition().y, mousePos.x, mousePos.y));
        return false;
    }

    public boolean touchDown (int screenX, int screenY, int pointer, int button){
        player.fire(EntityCategory.PLAYER_BULLET);

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
            case Input.Keys.NUM_1:
                player.setFireStrategy(new SingleShoot(player.getGameWorld()), Player.MIN_FIRE_INTERVAL);
                changeWeapon.play();
                break;
            case Input.Keys.NUM_2:
                player.setFireStrategy(new TripleShoot(player.getGameWorld()), Player.MIN_FIRE_INTERVAL);
                changeWeapon.play();
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
}
