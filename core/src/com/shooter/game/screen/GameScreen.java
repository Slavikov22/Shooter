package com.shooter.game.screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.shooter.game.model.GameWorld;

/**
 * Created by miraj on 11.3.17.
 */
public class GameScreen implements Screen {

    private OrthographicCamera camera;

    private InputMultiplexer multiplexer;

    private GameWorld world;

    public GameScreen(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        camera.update();

        world = new GameWorld();
        world.setCamera(camera);
        world.initPlayer();
        world.initGameMap();

        multiplexer = new InputMultiplexer();
        multiplexer.setProcessors(world.getProcessors());

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void show(){

    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.update();
        world.render();
    }

    @Override
    public void resize(int width, int height){

    }

    @Override
    public void hide(){

    }

    @Override
    public void pause(){

    }

    @Override
    public void resume(){

    }

    @Override
    public void dispose(){

    }

    public void printFile(){
        //        File f = new File("log");
//
//        try {
//            if(!f.exists()){
//                f.createNewFile();
//            }
//
//            PrintWriter out = new PrintWriter(f.getAbsoluteFile());
//
//            out.print(player.getPosition().y);
//            out.close();
//
//        } catch (IOException e){
//            throw new RuntimeException(e);
//        }
    }
}
