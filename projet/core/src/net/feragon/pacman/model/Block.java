package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Block extends GameElement implements Blocking {
	public Block(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	public boolean allowMonsters() {
		return false;
	}
}
