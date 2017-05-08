package com.shooter.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.shooter.game.model.GameMap;

import java.util.Dictionary;

/**
 * Created by miraj on 9.3.17.
 */
public class GameMapView {
    private GameMap gameMap;

    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    public GameMapView(GameMap gameMap, OrthographicCamera camera){
        this.gameMap = gameMap;
        this.camera = camera;

        // TODO: edit unitScale
        mapRenderer = new OrthogonalTiledMapRenderer(this.gameMap.getMap(), 0.04f);
    }

    public void render(){
        mapRenderer.setView(camera);
        mapRenderer.render();
    }
}
