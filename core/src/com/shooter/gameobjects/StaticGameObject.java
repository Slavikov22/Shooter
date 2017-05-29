package com.shooter.gameobjects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by miraj on 19.5.17.
 */
public class StaticGameObject extends GameObject{
    private static PolygonShape defaultShape;

    public static void setDefaultShape(PolygonShape shape){
        defaultShape = shape;
    }

    public StaticGameObject(World world, Vector2 position){
        super(world, position);
    }

    @Override
    protected BodyDef getDefaultBodyDef(){
        BodyDef bd = new BodyDef();
        bd.type = BodyDef.BodyType.StaticBody;

        return bd;
    }

    @Override
    protected FixtureDef getDefaultFixtureDef(){
        FixtureDef fd = new FixtureDef();
        fd.shape = defaultShape;

        fd.filter.categoryBits = EntityCategory.STATIC;
        fd.filter.maskBits = -1;

        return fd;
    }
}
