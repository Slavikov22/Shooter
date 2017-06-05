package com.shooter.gameobjects.views;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.shooter.gameobjects.GameObject;

/**
 * Created by miraj on 19.5.17.
 */
public class View {
    protected GameObject object;
    protected Sprite sprite;
    protected SpriteBatch spriteBatch;
    protected OrthographicCamera camera;

    public View(GameObject object, OrthographicCamera camera){
        setObject(object);
        this.camera = camera;

        sprite = new Sprite();
        spriteBatch = new SpriteBatch();
    }

    public void render(){
        Vector3 position = camera.project(new Vector3(object.getPosition(), 0));
        sprite.setX(position.x - sprite.getOriginX());
        sprite.setY(position.y - sprite.getOriginY());
        sprite.setRotation((float) Math.toDegrees(2*Math.PI - object.getAngle()));

        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    public void setObject(GameObject object){
        this.object = object;
    }

    public void setTexture(Texture texture){
        sprite = new Sprite(texture);
        sprite.setOriginCenter();
    }
}
