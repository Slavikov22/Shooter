package com.shooter.gameobjects.views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.shooter.gameobjects.Bullet;

/**
 * Created by miraj on 31.5.17.
 */
public class BulletView extends View {
    private final static String TEXTURE_PATH = "images/objects/bullet.png";

    public BulletView(Bullet bullet, OrthographicCamera camera){
        super(bullet, camera);
        setTexture(new Texture(TEXTURE_PATH));
        sprite.setScale(0.6f);
    }
}
