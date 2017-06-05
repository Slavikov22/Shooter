package com.shooter.gameobjects.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.shooter.gameobjects.Player;

/**
 * Created by miraj on 19.5.17.
 */
public class PlayerView extends View {
    private final static String TEXTURE_PATH = "images/persons/Player.png";

    private final static float SCALE = 1.55f;

    private final static int TEXTURE_CENTER_X = 11;
    private final static int TEXTURE_CENTER_Y = 14;

    private final static int HEALTH_BAR_WIDTH = 200;
    private final static int HEALTH_BAR_HEIGHT = 15;
    private final static int HEALTH_BAR_MARGIN = 30;

    private Sprite healthBar;
    private Sprite boundHealthBar;

    public PlayerView(Player player, OrthographicCamera camera){
        super(player, camera);

        setTexture(new Texture(TEXTURE_PATH));
        sprite.setScale(SCALE);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);

        Pixmap pixmap = new Pixmap(HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.drawRectangle(0, 0, HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT);

        boundHealthBar = new Sprite(new Texture(pixmap));
        boundHealthBar.setPosition(HEALTH_BAR_MARGIN, Gdx.graphics.getHeight() - HEALTH_BAR_MARGIN);

        pixmap = new Pixmap(HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(0, 0, HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT);

        healthBar = new Sprite(new Texture(pixmap));
        healthBar.setPosition(HEALTH_BAR_MARGIN, Gdx.graphics.getHeight() - HEALTH_BAR_MARGIN);
    }

    @Override
    public void render(){
        super.render();

        float widthHealth = HEALTH_BAR_WIDTH * (((Player) object).getHealth() / Player.MAX_HEALTH);
        Rectangle rectangle = healthBar.getBoundingRectangle();
        rectangle.width = widthHealth;
        healthBar.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        spriteBatch.begin();
        healthBar.draw(spriteBatch);
        boundHealthBar.draw(spriteBatch);
        spriteBatch.end();
    }
}
