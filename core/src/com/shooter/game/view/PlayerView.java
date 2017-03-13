package com.shooter.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.shooter.game.model.Player;

/**
 * Created by miraj on 11.3.17.
 */
public class PlayerView extends PersonView {
    public PlayerView(Player player, World world){
        super(player, world);

        initSprite(new Texture("Player1.png"));
    }
}
