package com.shooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.shooter.ShooterGame;
import com.shooter.listeners.ExitListener;
import com.shooter.listeners.StartListener;
import com.shooter.player.Statistic;

import javax.swing.*;
import java.util.Locale;

/**
 * Created by miraj on 1.6.17.
 */
public class GameOverScreen implements Screen {
    private final static float LABEL_WIDTH = 160;
    private final static float LABEL_HEIGHT = 50;

    private final static float BUTTON_WIDTH = 200;
    private final static float BUTTON_HEIGHT = 40;

    private Stage stage;
    private Skin skin;

    private Sound deadSound = Gdx.audio.newSound(Gdx.files.internal("sounds/dead.mp3"));

    private Sprite background = new Sprite(new Texture("images/game_over.png"));
    private SpriteBatch spriteBatch = new SpriteBatch();

    public GameOverScreen(ShooterGame game, Statistic statistic){
        deadSound.play();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        Label killsLabel = new Label("Kills : " + String.valueOf(statistic.kills), skin);
        Label shootsLabel = new Label("Shoots : " + String.valueOf(statistic.shoots), skin);
        Label hitsLabel = new Label("Hits : " + String.valueOf(statistic.hits), skin);
        Label accuracyLabel = new Label("Accuracy : " + String.format(Locale.ENGLISH, "%(.2f", (float) statistic.hits / statistic.shoots * 100) + "%", skin);
        Label timeLabel = new Label("Time : " + String.valueOf((int) statistic.leave_time + " seconds"), skin);

        killsLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        shootsLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        hitsLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        accuracyLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        timeLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);

        killsLabel.setPosition((Gdx.graphics.getWidth() - killsLabel.getWidth()) / 2, 520);
        shootsLabel.setPosition((Gdx.graphics.getWidth() - shootsLabel.getWidth()) / 2, 480);
        hitsLabel.setPosition((Gdx.graphics.getWidth() - hitsLabel.getWidth()) / 2, 440);
        accuracyLabel.setPosition((Gdx.graphics.getWidth() - accuracyLabel.getWidth()) / 2, 400);
        timeLabel.setPosition((Gdx.graphics.getWidth() - timeLabel.getWidth()) / 2, 360);

        Button buttonPlay = new TextButton("Play", skin);
        buttonPlay.setPosition((Gdx.graphics.getWidth() - BUTTON_WIDTH) / 2 - 120, 150);
        buttonPlay.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonPlay.addListener(new StartListener(game));

        Button buttonExit = new TextButton("Exit", skin);
        buttonExit.setPosition((Gdx.graphics.getWidth() - BUTTON_WIDTH) / 2 + 120, 150);
        buttonExit.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonExit.addListener(new ExitListener());

        stage.addActor(killsLabel);
        stage.addActor(shootsLabel);
        stage.addActor(hitsLabel);
        stage.addActor(accuracyLabel);
        stage.addActor(timeLabel);
        stage.addActor(buttonPlay);
        stage.addActor(buttonExit);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        background.draw(spriteBatch);
        spriteBatch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        deadSound.stop();
    }

    @Override
    public void dispose() {

    }
}
