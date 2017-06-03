package com.shooter.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.shooter.helpers.GameHelper;

/**
 * Created by miraj on 2.6.17.
 */
public class GameController extends InputAdapter {
    GameWorld gameWorld;

    public GameController(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }

    public boolean keyDown (int keycode) {
        switch (keycode) {
            case Input.Keys.ESCAPE:
                GameHelper.save(new GameInfo(gameWorld));
                Gdx.app.exit();
                break;
        }

        return true;
    }
}
