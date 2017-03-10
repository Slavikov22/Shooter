package com.shooter.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.shooter.game.ShooterGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ShooterGame.WIDTH;
		config.height = ShooterGame.HEIGHT;
		config.title = ShooterGame.TITLE;
		new LwjglApplication(new ShooterGame(), config);
	}
}
