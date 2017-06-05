package com.shooter;

import com.badlogic.gdx.Game;
import com.shooter.screens.MenuScreen;

public class ShooterGame extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
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
