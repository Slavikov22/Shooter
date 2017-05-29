package com.shooter.gameobjects.Views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.shooter.gameobjects.Player;

/**
 * Created by miraj on 19.5.17.
 */
public class PlayerView extends View {
    private final String TEXTURE_PATH = "images/persons/Player.png";

    private final float SCALE = 1.55f;

    private final int TEXTURE_CENTER_X = 11;
    private final int TEXTURE_CENTER_Y = 14;

    public PlayerView(Player player, OrthographicCamera camera){
        super(player, camera);
        setTexture(new Texture(TEXTURE_PATH));
    }

    @Override
    public void setTexture(Texture texture){
        sprite = new Sprite(texture);
        sprite.setScale(SCALE);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);
    }
}
