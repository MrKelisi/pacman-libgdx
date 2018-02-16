package net.feragon.pacman.model;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class YellowMonster extends GameElement implements AI {
	public YellowMonster(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	public Vector2 getNewPosition() {
		Random random = new Random();
		
		if(random.nextBoolean()) {
			return getPosition().cpy().add(random.nextInt(3) - 1, 0);
		}
		else {
			return getPosition().cpy().add(0, random.nextInt(3) - 1);
		}
	}
}
