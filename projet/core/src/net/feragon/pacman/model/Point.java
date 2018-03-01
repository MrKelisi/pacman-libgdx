package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Point extends GameElement implements Interactable {
	private final static int POINTS = 10;
	
	public Point(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	public void takenBy(Pacman pacman) {
		if(!isShown()) {
			return;
		}
		
		pacman.addPoints(POINTS);
		setShow(false);
	}
}
