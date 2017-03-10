package com.shooter.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

import java.util.Dictionary;

/**
 * Created by miraj on 9.3.17.
 */
public class GameMapView {
    private TiledMap map;
    private OrthogonalTiledMapRenderer mapRenderer;
    private OrthographicCamera camera;

    public GameMapView(){
        map = new TmxMapLoader().load("TileMaps/start.tmx");

        mapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    public void render(){
        mapRenderer.setView(camera);
        mapRenderer.render();
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

}
