package com.shooter.gameobjects.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.shooter.gameobjects.Enemy;

/**
 * Created by miraj on 30.5.17.
 */
public class EnemyView extends View{
    private final static String TEXTURE_PATH = "images/persons/Enemy.png";

    private final static float SCALE = 1.55f;

    private final static int TEXTURE_CENTER_X = 11;
    private final static int TEXTURE_CENTER_Y = 14;

    private final static int HEALTH_BAR_WIDTH = 48;
    private final static int HEALTH_BAR_HEIGHT = 2;
    private final static int HEALTH_BAR_OFFSET_Y = 28;

    private Sprite healthBar;

    public EnemyView(Enemy enemy, OrthographicCamera camera){
        super(enemy, camera);

        setTexture(new Texture(TEXTURE_PATH));
        sprite.setScale(SCALE);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);

        Pixmap healthPixmap = new Pixmap(HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT, Pixmap.Format.RGBA8888);
        healthPixmap.setColor(Color.RED);
        healthPixmap.fillRectangle(0, 0, HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT);

        healthBar = new Sprite(new Texture(healthPixmap));
    }

    @Override
    public void render(){
        super.render();

        Vector3 position = camera.project(new Vector3(object.getPosition(), 0));
        healthBar.setX(position.x - healthBar.getOriginX());
        healthBar.setY(position.y - healthBar.getOriginY() - HEALTH_BAR_OFFSET_Y);

        float widthHealth = HEALTH_BAR_WIDTH * (((Enemy) object).getHealth() / Enemy.MAX_HEALTH);
        Rectangle rectangle = healthBar.getBoundingRectangle();
        rectangle.width = widthHealth;
        healthBar.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        spriteBatch.begin();
        healthBar.draw(spriteBatch);
        spriteBatch.end();
    }
}
