package com.shooter.gameobjects.Views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.shooter.gameobjects.Enemy;

/**
 * Created by miraj on 30.5.17.
 */
public class EnemyView extends View{
    private final static String TEXTURE_PATH = "images/persons/Enemy.png";

    private final static float SCALE = 1.55f;

    private final static int TEXTURE_CENTER_X = 11;
    private final static int TEXTURE_CENTER_Y = 14;

    public EnemyView(Enemy enemy, OrthographicCamera camera){
        super(enemy, camera);
        setTexture(new Texture(TEXTURE_PATH));
    }

    @Override
    public void setTexture(Texture texture){
        sprite = new Sprite(texture);
        sprite.setScale(SCALE);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);
    }
}
