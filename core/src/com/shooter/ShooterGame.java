package com.shooter;

import com.badlogic.gdx.Game;
import com.shooter.screens.GameScreen;

public class ShooterGame extends Game {
	@Override
	public void create() {
		this.setScreen(new GameScreen());
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void render() {
		super.render();
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
