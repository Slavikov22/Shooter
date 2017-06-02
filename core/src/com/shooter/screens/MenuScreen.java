package com.shooter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.shooter.ShooterGame;
import com.shooter.listeners.ExitListener;
import com.shooter.listeners.StartListener;

/**
 * Created by miraj on 1.6.17.
 */
public class MenuScreen implements Screen {
    private final static float BUTTON_WIDTH = 200;
    private final static float BUTTON_HEIGHT = 40;

    private Stage stage;
    private Skin skin;
    private Table table;

    private TextureAtlas atlas;

    private BitmapFont white, black;

    private TextButton buttonPlay;
    private TextButton buttonExit;

    private Label heading;

    public MenuScreen(ShooterGame game){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        buttonPlay = new TextButton("Play", skin);
        buttonPlay.setPosition((Gdx.graphics.getWidth() - BUTTON_WIDTH) / 2, Gdx.graphics.getHeight() / 2 + BUTTON_HEIGHT);
        buttonPlay.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonPlay.addListener(new StartListener(game));

        buttonExit = new TextButton("Exit", skin);
        buttonExit.setPosition((Gdx.graphics.getWidth() - BUTTON_WIDTH) / 2, Gdx.graphics.getHeight() / 2 - BUTTON_HEIGHT);
        buttonExit.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        buttonExit.addListener(new ExitListener());

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

    }

    @Override
    public void dispose() {

    }
}
