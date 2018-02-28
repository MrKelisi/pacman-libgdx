package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Pacman extends Player {

	public Pacman(Vector2 position, World world) {
		super(position, world);
	}

	public void update(float timeElapsed) {
		
	}

	@Override
    public void move() {
		super.move();

        world.getMaze().eat(getPosition());
    }
}
