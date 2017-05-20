package com.shooter.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.map.GameMap;
import com.shooter.gameobjects.Player;

/**
 * Created by miraj on 13.3.17.
 */
public class GameWorld {
    private final static float TIME_STEP = 1.0f / 60.0f;

    private final static int VELOCITY_ITERATIONS = 10;
    private final static int POSITION_ITERATIONS = 10;

    private int gameWidth;
    private int gameHeight;

    private World world;
    private TiledMap map;
    private GameMap gameMap;
    private Player player;

    private OrthographicCamera camera;

    public GameWorld(String mapName, OrthographicCamera camera){
        map = new TmxMapLoader().load(mapName);
        gameWidth = (Integer) map.getProperties().get("width");
        gameHeight = (Integer) map.getProperties().get("height");

        this.camera = camera;

        world = new World(new Vector2(0,0), false);

        float posX = (Float) map.getLayers().get("GameObjects").getObjects().get("StartPoint").getProperties().get("x");
        float posY = (Float) map.getLayers().get("GameObjects").getObjects().get("StartPoint").getProperties().get("y");
        Vector3 position = camera.unproject(new Vector3(posX, posY, 0));
        player = new Player(world, position.x, position.y);
    }

    public void update(float deltaTime){
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        player.update();
    }

    public Player getPlayer(){
        return player;
    }
}
