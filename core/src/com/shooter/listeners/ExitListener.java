package com.shooter.listeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by miraj on 1.6.17.
 */
public class ExitListener extends ClickListener {
    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        Gdx.app.exit();

        return true;
    }
}
