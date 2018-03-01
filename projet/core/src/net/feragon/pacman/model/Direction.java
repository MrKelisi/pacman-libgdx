package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public enum Direction {
	LEFT,
	UP,
	RIGHT,
	DOWN;
	
	/**
	 * Donne le vecteur de mouvement associé à la direction
	 * @return Vector2
	 */
	Vector2 moveVector() {
		switch (this) {
			case UP:    
	        	return new Vector2(0, 1);
	        	
	        case RIGHT:
	        	return new Vector2(1, 0);
	        	
	        case DOWN: 
	        	return new Vector2(0, -1);
	        	
	        case LEFT: 
	        	return new Vector2(-1, 0);
		}
		
		return new Vector2(0, 0);
	}
}
