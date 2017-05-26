package com.shooter.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.shooter.gameobjects.Views.PlayerView;
import com.shooter.helpers.CameraHelper;

/**
 * Created by miraj on 20.5.17.
 */
public class GameRenderer {
    private final static float UNIT_SCALE = 1.0f / 32.0f;

    private GameWorld world;
    private PlayerView playerView;
    private OrthogonalTiledMapRenderer mapRenderer;

    private OrthographicCamera camera;

    public GameRenderer(GameWorld world, OrthographicCamera camera){
        this.world = world;
        this.camera = camera;

        playerView = new PlayerView(world.getPlayer(), camera);
        mapRenderer = new OrthogonalTiledMapRenderer(world.getMap(), UNIT_SCALE);
        mapRenderer.setView(camera);
    }

    public void render(){
        mapRenderer.setView(camera);
        mapRenderer.render();

        playerView.render();
    }
}
