package com.shooter.game.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.camera.CameraController;
import com.shooter.game.objects.Views.PlayerView;

/**
 * Created by miraj on 19.5.17.
 */
public class Player extends Person {
    private final float FORCE = 150.0f;
    private final static Vector2 START_POSITION = new Vector2(2.0f,2.0f);

    private Box2DDebugRenderer renderer;

    public boolean isMovedUp;
    public boolean isMovedLeft;
    public boolean isMovedDown;
    public boolean isMovedRight;

    public Player(World world, CameraController cameraController, Vector2 position){
        super(world, cameraController, position);

        view = new PlayerView(this, cameraController.getCamera());

        renderer = new Box2DDebugRenderer();
    }

    @Override
    public void render(){
        update();

        renderer.render(world, cameraController.getCamera().combined);
        view.render();
    }

    public void update(){
        System.out.println(getPosition().x);

        if (isMovedUp){
            applyForce(0, FORCE);
        }
        if (isMovedLeft){
            applyForce(-FORCE, 0);
        }
        if (isMovedDown){
            applyForce(0, -FORCE);
        }
        if (isMovedRight){
            applyForce(FORCE, 0);
        }
    }
}
