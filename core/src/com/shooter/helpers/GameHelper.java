package com.shooter.helpers;

import com.shooter.gameworld.GameInfo;
import com.shooter.gameworld.GameWorld;
import com.shooter.player.Statistic;

import java.io.*;

/**
 * Created by miraj on 2.6.17.
 */
public class GameHelper {
    public final static String PATH = "game";

    public static GameInfo load(){
        GameInfo gameInfo = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            gameInfo = (GameInfo) objectInputStream.readObject();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
        catch (ClassNotFoundException e){}

        return gameInfo;
    }

    public static void save(GameInfo gameInfo){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gameInfo);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}

    }
}
