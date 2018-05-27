package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class SuperPellet extends GameElement implements Interactable {
	private final static int POINTS = 50;
	
	public SuperPellet(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	public boolean takenBy(Pacman pacman) {
		if(!isShown()) {
			return false;
		}
		
		pacman.addPoints(POINTS);
		setShow(false);
		for(Monster monster : world.getMaze().getMonsters()) {
			monster.setWeak();
		}
		return true;
	}
}
