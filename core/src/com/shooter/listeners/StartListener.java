package com.shooter.listeners;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.shooter.ShooterGame;
import com.shooter.screens.GameScreen;

/**
 * Created by miraj on 1.6.17.
 */
public class StartListener extends ClickListener {
    private ShooterGame game;

    private Music menuMusic;

    public StartListener(ShooterGame game, Music menuMusic){
        this.game = game;
        this.menuMusic = menuMusic;
    }

    @Override
    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        if (menuMusic != null){
            menuMusic.stop();
        }

        game.setScreen(new GameScreen(game));

        return true;
    }
}
