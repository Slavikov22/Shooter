package com.shooter.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.shooter.gameobjects.Bullet;
import com.shooter.gameobjects.Enemy;
import com.shooter.gameobjects.views.BulletView;
import com.shooter.gameobjects.views.EnemyView;
import com.shooter.gameobjects.views.PlayerView;
import com.shooter.helpers.TiledMapHelper;

/**
 * Created by miraj on 20.5.17.
 */
public class GameRenderer {
    private GameWorld world;
    private PlayerView playerView;
    private EnemyView enemyView;
    private BulletView bulletView;
    private OrthogonalTiledMapRenderer mapRenderer;

    private Box2DDebugRenderer box2DDebugRenderer;

    private OrthographicCamera camera;

    public GameRenderer(GameWorld world, OrthographicCamera camera){
        this.world = world;
        this.camera = camera;

        playerView = new PlayerView(world.getPlayer(), camera);
        enemyView = new EnemyView(null, camera);
        bulletView = new BulletView(null, camera);
        mapRenderer = new OrthogonalTiledMapRenderer(world.getMap(), 1.0f / TiledMapHelper.TILE_SIZE);

        box2DDebugRenderer = new Box2DDebugRenderer();
    }

    public void render(){
        updateMapRenderer();
        mapRenderer.render();

        for (Bullet bullet: world.getBullets()){
            bulletView.setObject(bullet);
            bulletView.render();
        }

        playerView.render();

        for (Enemy enemy: world.getEnemies()){
            enemyView.setObject(enemy);
            enemyView.render();
        }

        //box2DDebugRenderer.render(world.getWorld(), camera.combined);
    }

    private void updateMapRenderer(){
        mapRenderer.setView(camera.combined, 20, 20, 100, 100);
        mapRenderer.getViewBounds().x -= 20;
        mapRenderer.getViewBounds().y -= 20;
        mapRenderer.getViewBounds().width += 40;
        mapRenderer.getViewBounds().height += 40;
    }
}
