package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public abstract class Monster extends Player {
	public Monster(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	protected boolean isElementAccessible(GameElement ge) {
		if(ge instanceof Blocking) {
			return ((Blocking) ge).allowMonsters();
		}
		return true;
	}

	/**
	 * Donne une nouvelle direction
	 * @return Nouvelle direction
	 */
	abstract protected Direction getNewDirection();
}
