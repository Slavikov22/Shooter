package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 28.5.17.
 */
public class Bullet extends DynamicGameObject {
    private final float WIDTH = 0.05f;
    private final float HEIGHT = 0.03f;

    public Bullet(World world, Vector2 position, short categoryBits){
        super(world, position);


        Filter filter = new Filter();
        filter.categoryBits = categoryBits;

        if (categoryBits == EntityCategory.PLAYER_BULLET){
            filter.maskBits = EntityCategory.STATIC | EntityCategory.ENEMY;
        }
        else{
            filter.maskBits = EntityCategory.STATIC | EntityCategory.PLAYER;
        }

        fixture.setFilterData(filter);
    }

    @Override
    protected BodyDef getDefaultBodyDef(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.DynamicBody;
        bd.bullet = true;

        return bd;
    }

    @Override
    protected FixtureDef getDefaultFixtureDef(){
        FixtureDef fd = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(WIDTH, HEIGHT);
        fd.shape = shape;
        fd.density = 1;

        return fd;
    }

}
