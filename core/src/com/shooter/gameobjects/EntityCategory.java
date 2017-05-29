package com.shooter.gameobjects;

/**
 * Created by miraj on 28.5.17.
 */
public abstract class EntityCategory {
    public static final short STATIC =        0x0001;
    public static final short PLAYER =        0x0002;
    public static final short ENEMY =         0x0004;
    public static final short PLAYER_BULLET = 0x0008;
    public static final short ENEMY_BULLET =  0x0010;
}
