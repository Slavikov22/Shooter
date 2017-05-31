package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.shooter.gameworld.GameWorld;
import com.shooter.helpers.MathHelper;

/**
 * Created by miraj on 28.5.17.
 */
public class Bullet extends DynamicGameObject {
    private final static float WIDTH = 0.05f;
    private final static float HEIGHT = 0.03f;

    private final static float VELOCITY_MODULE = 50.0f;

    public Bullet(GameWorld gameWorld, Vector2 position, float angle, short categoryBits){
        super(gameWorld, position);

        setAngle(angle);
        setLinearVelocity(MathHelper.getVector2byAngle(angle, VELOCITY_MODULE));

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
        fd.isSensor = true;

        return fd;
    }

}
