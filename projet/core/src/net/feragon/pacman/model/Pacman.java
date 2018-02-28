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

        int x = (int) getPosition().x + i;
        int y = (int) getPosition().y + j;

        if(world.getMaze().get(x, y) == null) {
            if(x == -1)
                setPosition(new Vector2(world.getWidth()-1, y));
            else if(x == world.getWidth())
                setPosition(new Vector2(0, y));
            else
                setPosition(new Vector2(x, y));
        }

        //eat();
    }
}
