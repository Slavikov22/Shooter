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

    private final int TEXTURE_CENTER_X = 11;
    private final int TEXTURE_CENTER_Y = 14;

    private Box2DDebugRenderer renderer;

    public PlayerView(Player player, OrthographicCamera camera){
        super(player, camera);
        setSprite(new Texture(TEXTURE_PATH));
        renderer = new Box2DDebugRenderer();
    }

    @Override
    public void setSprite(Texture texture){
        sprite = new Sprite(texture);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);
    }
}
