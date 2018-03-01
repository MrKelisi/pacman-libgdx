package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class CyanMonster extends Monster {
	public CyanMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		// TODO Auto-generated method stub
		return Direction.LEFT;
	}
}
