package com.shooter.game.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by miraj on 20.5.17.
 */
public class GameMap {
    private static final float UNIT_SCALE = 1.0f / 32.0f;

    OrthographicCamera camera;
    OrthogonalTiledMapRenderer renderer;
    TiledMap map;

    public GameMap(String path, OrthographicCamera camera){
        map = new TmxMapLoader().load(path);
        this.camera = camera;
        renderer = new OrthogonalTiledMapRenderer(map, UNIT_SCALE);

        getStartPlayerPosition();
    }

    public void render(){
        renderer.setView(camera);
        renderer.render();
    }

    public Vector2 getStartPlayerPosition(){
        MapObject startPoint =  map.getLayers().get("GameObjects").getObjects().get("StartPoint");
        return new Vector2((Float)startPoint.getProperties().get("x"), (Float)startPoint.getProperties().get("y"));
    }
}
