package com.shooter.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.model.Player;
import com.shooter.game.view.PersonView;
import com.shooter.game.view.PlayerView;

/**
 * Created by miraj on 10.3.17.
 */
public class PlayerController extends InputAdapter {
    private Player player;
    private PersonView view;

    private OrthographicCamera camera;

    public PlayerController(World world, OrthographicCamera camera){
        player = new Player(world);
        view = new PlayerView(player, world, camera);

        this.camera = camera;
    }

    public void render(){
        player.update();
        view.render();
    }

    public boolean keyDown(int keycode){
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

    public boolean keyUp(int keycode){
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

    public boolean mouseMoved(int x, int y){

        Vector3 mousePos = new Vector3(x, y, 0);
        camera.unproject(mousePos);

        player.setAngle(getAngle(mousePos.x, mousePos.y));

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
