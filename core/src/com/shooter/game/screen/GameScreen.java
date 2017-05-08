package com.shooter.game.screen;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.shooter.game.controller.CameraController;
import com.shooter.game.model.GameWorld;

/**
 * Created by miraj on 11.3.17.
 */
public class GameScreen implements Screen {

    private CameraController cameraController;
    private GameWorld gameWorld;

    private InputMultiplexer multiplexer;

    public GameScreen(int width, int height){
        cameraController = new CameraController(width, height);
        gameWorld = new GameWorld(cameraController.getCamera());

        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(cameraController);

        for (InputProcessor processor: gameWorld.getInputProcessors()) {
            multiplexer.addProcessor(processor);
        }

        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void show(){

    }

    @Override
    public void render(float deltaTime){
        Gdx.gl.glClearColor(0,0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameWorld.update();
        gameWorld.render();
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
