package com.tutorial.mario.tile;

import java.awt.Graphics;

import com.tutorial.mario.Game;
import com.tutorial.mario.Handler;
import com.tutorial.mario.Id;
import com.tutorial.mario.entity.powerup.Mushroom;
import com.tutorial.mario.gfx.Sprite;

public class PowerUpBlock extends Tile {
	
	private Sprite powerUp;
	
	private boolean poppedUp;
	
	private int spriteY = getY();
	private int type;

	public PowerUpBlock(int x, int y, int width, int height, boolean solid, Id id, Handler handler, Sprite powerUp, int type) {
		super(x, y, width, height, solid, id, handler);
		this.type = type;
		this.powerUp = powerUp;
		

	}

	
	public void render(Graphics g) {
		if(!poppedUp) g.drawImage(powerUp.getBufferedImage(), x, spriteY, width, height, null);{
		}
		if(!activated) {
			
			g.drawImage(Game.powerUp.getBufferedImage(), x, y, width, height, null);
		}
		
		else {
			g.drawImage(Game.usedPowerUp.getBufferedImage(), x, y, width, height, null);
			
		}
	}


	public void tick() {
		if(activated&&!poppedUp) {
			spriteY--;
			if(spriteY<= y-height) {
				handler.addEntity(new Mushroom(x, spriteY, width, height, Id.mushroom, handler, type));
				poppedUp = true;
			}
		}

	}

}
