package com.shooter.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.shooter.gameobjects.Views.PlayerView;

/**
 * Created by miraj on 20.5.17.
 */
public class GameRenderer {
    private final static float VIEWPORT_WIDTH = 15;
    private final static float VIEWPORT_HEIGHT = 15;

    private GameWorld world;
    private PlayerView playerView;

    private OrthographicCamera camera;

    public GameRenderer(GameWorld world, OrthographicCamera camera){
        this.world = world;
        this.camera = camera;

        playerView = new PlayerView(world.getPlayer(), camera);
    }

    public void render(){
        playerView.render();
    }
}
