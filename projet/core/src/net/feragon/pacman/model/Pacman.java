package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public class Pacman extends Player {

	public Pacman(Vector2 position, World world) {
		super(position, world);
	}

	public void update(float timeElapsed) {
		
	}

    public void move() {
        int i, j;

        switch(direction()) {
            case UP:    i = 0; j = 1; break;
            case RIGHT: i = 1; j = 0; break;
            case DOWN:  i = 0; j =-1; break;
            case LEFT:  i =-1; j = 0; break;
            default:    i = 0; j = 0;
        }

        Vector2 newPos = new Vector2(getPosition().x + i, getPosition().y + j);

        if(world.getMaze().get(newPos) == null) {
            if(newPos.x == -1)
                newPos.set(world.getWidth()-1, newPos.y);
            else if(newPos.x == world.getWidth())
                newPos.set(0, newPos.y);

            setPosition(newPos);
        }

        world.getMaze().eat(getPosition());
    }
}
