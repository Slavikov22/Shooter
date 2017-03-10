package com.shooter.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.shooter.game.model.Person;

/**
 * Created by miraj on 7.3.17.
 */
public class PersonView {
    private final int TEXTURE_CENTER_X = 11;
    private final int TEXTURE_CENTER_Y = 14;

    protected Person person;

    protected OrthographicCamera camera;

    protected SpriteBatch spriteBatch;
    protected Sprite sprite;

    protected Texture texture;

    public PersonView(Person person){
        this.person = person;

        spriteBatch = new SpriteBatch();
    }

    public void setTexture(Texture texture){
        this.texture = texture;

        sprite = new Sprite(texture);
        sprite.setCenter(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public OrthographicCamera getCamera(){
        return camera;
    }

    public void render(){
        spriteBatch.begin();
        sprite.setCenter(person.getX(), person.getY());
        sprite.setRotation(person.getRotation());
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }
}
