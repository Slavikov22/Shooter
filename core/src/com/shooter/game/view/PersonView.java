package com.shooter.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.model.Person;

/**
 * Created by miraj on 7.3.17.
 */
public class PersonView {
    private final int TEXTURE_CENTER_X = 11;
    private final int TEXTURE_CENTER_Y = 14;

    private Person person;

    private OrthographicCamera camera;

    private SpriteBatch spriteBatch;
    private Sprite sprite;

    private Box2DDebugRenderer renderer;

    private World world;

    PersonView(Person person, World world, OrthographicCamera camera){
        this.person = person;
        this.world = world;
        this.camera = camera;

        renderer = new Box2DDebugRenderer();

        spriteBatch = new SpriteBatch();
    }

    public void render(){
        renderer.render(world, camera.combined);

        spriteBatch.begin();
        Vector3 position = camera.project(new Vector3(person.getPosition(), 0));
        sprite.setX(position.x - sprite.getOriginX());
        sprite.setY(position.y - sprite.getOriginY());
        sprite.setRotation(person.getAngle());
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    void initSprite(Texture texture){
        sprite = new Sprite(texture);
        sprite.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);
    }
}
