package com.shooter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.shooter.game.controller.GameMapController;
import com.shooter.game.controller.PlayerController;
import com.shooter.game.model.Player;
import com.shooter.game.view.GameMapView;
import com.shooter.game.view.PersonView;
import com.shooter.game.view.PlayerView;

public class ShooterGame extends Game {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Shooter";

	private static final Vector2 START_POSITION = new Vector2(30,30);

	private InputMultiplexer multiplexer;

	private OrthographicCamera camera;

	private GameMapView mapView;

	private Player player;
	private PlayerView playerView;
	private PlayerController playerController;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
		camera.update();

		player = new Player(START_POSITION);
		playerView = new PlayerView(player);
		playerView.setCamera(camera);
		playerController = new PlayerController(player, playerView);

		mapView = new GameMapView();
		mapView.setCamera(camera);

		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(new GameMapController(mapView));
		multiplexer.addProcessor(new PlayerController(player, playerView));

		Gdx.input.setInputProcessor(multiplexer);

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0,0,0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mapView.render();
		playerView.render();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	@Override
	public void dispose() {
	}
}
