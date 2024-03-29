package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Blank extends GameElement implements Blocking {
    public Blank(Vector2 position, World world) {
        super(position, world);
    }

	@Override
	public boolean allowMonsters() {
		return true;
	}
}
