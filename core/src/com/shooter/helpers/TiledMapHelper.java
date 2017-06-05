package com.shooter.helpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.ShortArray;
import com.shooter.gameobjects.Spawn;
import com.shooter.gameobjects.StaticGameObject;
import com.shooter.gameworld.GameWorld;

import java.util.ArrayList;

/**
 * Created by miraj on 26.5.17.
 */
public class TiledMapHelper {
    public static final float TILE_SIZE = 32.0f;

    public static TiledMap getTiledMap(String mapName){
        TmxMapLoader.Parameters parameters = new TmxMapLoader.Parameters();
        parameters.flipY = false;
        parameters.textureMagFilter = Texture.TextureFilter.Nearest;
        parameters.textureMinFilter = Texture.TextureFilter.Linear;

        return new TmxMapLoader().load(mapName, parameters);
    }

    public static int getWidth(TiledMap map){
        return (Integer) map.getProperties().get("width");
    }

    public static int getHeight(TiledMap map){
        return (Integer) map.getProperties().get("height");
    }

    public static Vector2 getPlayerPosition(TiledMap map){
        Vector2 position = getObjectPosition(map.getLayers().get("GameObjects").getObjects().get("StartPoint"));
        position.x += 0.5f;
        position.y += 0.5f;
        return position;
    }

    public static ArrayList<StaticGameObject> getStaticObjects(TiledMap map, GameWorld gameWorld){
        ArrayList<StaticGameObject> result = new ArrayList<StaticGameObject>();

        for (MapObject mapObject: map.getLayers().get("StaticObjects").getObjects()){
            Vector2 position = getObjectPosition(mapObject);

            PolygonMapObject polygonMapObject = (PolygonMapObject) mapObject;

            float[] vertices = polygonMapObject.getPolygon().getVertices();

            for (int count = 0; count < vertices.length; count++){
                vertices[count] /= TILE_SIZE;
            }

            ShortArray triangles = new EarClippingTriangulator().computeTriangles(vertices);

            for (int count = 0; count < triangles.size; count += 3) {
                float[] tempVertices = new float[6];
                tempVertices[0] = vertices[triangles.get(count) * 2];
                tempVertices[1] = vertices[triangles.get(count) * 2 + 1];
                tempVertices[2] = vertices[triangles.get(count + 1) * 2];
                tempVertices[3] = vertices[triangles.get(count + 1) * 2 + 1];
                tempVertices[4] = vertices[triangles.get(count + 2) * 2];
                tempVertices[5] = vertices[triangles.get(count + 2) * 2 + 1];

                if (Math.abs(MathHelper.getArea(tempVertices)) < 1e-5) continue;

                PolygonShape polygonShape = new PolygonShape();

                polygonShape.set(tempVertices);

                StaticGameObject.setDefaultShape(polygonShape);

                result.add(new StaticGameObject(gameWorld, position));
            }
        }

        return result;
    }

    public static Spawn getSpawn(TiledMap map, GameWorld gameWorld){
        ArrayList<Vector2> positions = new ArrayList<Vector2>();

        for (MapObject mapObject: map.getLayers().get("EnemySpawns").getObjects()){
            positions.add(new Vector2(getObjectPosition(mapObject)));
        }

        return new Spawn(gameWorld, positions);
    }

    private static Vector2 getObjectPosition(MapObject object){
        float posX = (Float) object.getProperties().get("x");
        float posY = (Float) object.getProperties().get("y");

        return new Vector2(posX / TILE_SIZE, posY / TILE_SIZE);
    }
}