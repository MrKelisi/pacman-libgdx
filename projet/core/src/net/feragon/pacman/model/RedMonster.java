package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class RedMonster extends Monster {
	public RedMonster(Vector2 position, World world) {
		super(position, world);
	}
	
	@Override
	protected Direction getNewDirection() {
		// TODO Auto-generated method stub
		return Direction.LEFT;
	}
}
