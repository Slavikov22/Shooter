package com.shooter.listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.shooter.ShooterGame;
import com.shooter.gameworld.GameInfo;
import com.shooter.helpers.GameHelper;
import com.shooter.screens.GameScreen;

/**
 * Created by miraj on 2.6.17.
 */
public class LoadListener extends ClickListener {
    private ShooterGame game;

    public LoadListener(ShooterGame game){
        this.game = game;
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        GameInfo gameInfo = GameHelper.load();
        game.setScreen(new GameScreen(game, gameInfo));

        return true;
    }
}
