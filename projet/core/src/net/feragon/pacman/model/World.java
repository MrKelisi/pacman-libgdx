package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.util.Iterator;

public class World implements Iterable<GameElement> {
	public final static float TICK_TIME = 0.4f;
	private float _tickProgression;
	private Maze laby;
	
	public World() {
		laby = new Maze(this);

		laby.getPacman().setStartPos();
		for(Monster monster: laby.getMonsters()) {
			monster.setStartPos();
		}
	}

	public int getWidth() {
		return laby.getWidth();
	}
	
	public int getHeight() {
		return laby.getHeight();
	}

	public Maze getMaze() {
		return laby;
	}

	public Iterator<GameElement> iterator() {
		return laby.iterator();
	}
	
	/**
	 * Fait avancer le monde !
	 * @param timeElapsed Temps écoulé depuis la dernière mise à jour
	 */
	public void update(float timeElapsed) throws Exception {
		_tickProgression += timeElapsed; 

		if(_tickProgression >= TICK_TIME) {
			_tickProgression %= TICK_TIME;
			getMaze().getPacman().move();
			Vector2 pacmanPos = getMaze().getPacman().getPosition();

			for(Monster monster : getMaze().getMonsters()) {
				monster.move();

				Vector2 v = monster.getPosition().cpy().sub(pacmanPos);
				boolean crossedWay = (v.x + v.y == 1 && v.x * v.y == 0 && monster.direction().equals(getMaze().getPacman().direction().reverse()));

				if(monster.getPosition().equals(pacmanPos) || crossedWay) {
					if(monster.getWeakTime() <= 0) {
						getMaze().getPacman().takeALife();
						getMaze().getPacman().addPoints(-200);

						if (getMaze().getPacman().getLifes() < 0)
							throw new Exception("You lost!");
						else
							resetPositions();
					}
					else {
						getMaze().getPacman().addPoints(500);
						monster.resetPosition();
					}
				}
			}
			
			GameElement ge = getMaze().get(getMaze().getPacman().getPosition());
			if(ge instanceof Interactable) {
				if(((Interactable) ge).takenBy(getMaze().getPacman()))
					getMaze().decreaseRemainingPellets();
			}
		}
		getMaze().getPacman().move(_tickProgression);
		for(Monster monster : getMaze().getMonsters()) {
			monster.move(_tickProgression);
			monster.update(timeElapsed);
		}
	}

	public void resetPositions() {
		getMaze().getPacman().resetPosition();
		for(Monster monster : getMaze().getMonsters()) {
			monster.resetPosition();
		}
	}
}
