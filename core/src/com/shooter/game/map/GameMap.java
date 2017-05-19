package com.shooter.game.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by miraj on 20.5.17.
 */
public class GameMap {
    private static final float UNIT_SCALE = 1.0f / 32.0f;

    OrthographicCamera camera;
    OrthogonalTiledMapRenderer renderer;

    public GameMap(String path, OrthographicCamera camera){
        TiledMap tiledMap = new TmxMapLoader().load(path);
        this.camera = camera;
        renderer = new OrthogonalTiledMapRenderer(tiledMap, UNIT_SCALE);
    }

    public void render(){
        renderer.setView(camera);
        renderer.render();
    }
}
