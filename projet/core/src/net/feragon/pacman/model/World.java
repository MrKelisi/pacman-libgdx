package net.feragon.pacman.model;

import java.util.Iterator;

public class World implements Iterable<GameElement> {
	public final static float TICK_TIME = 0.4f;
	private float _tickProgression;
	private Maze laby;
	
	public World() {
		laby = new Maze(this);
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
	public void update(float timeElapsed) {
		_tickProgression += timeElapsed; 
		
		if(_tickProgression >= TICK_TIME) {
			_tickProgression %= TICK_TIME;
			getMaze().getPacman().move();
			
			GameElement ge = getMaze().get(getMaze().getPacman().getPosition());
			if(ge instanceof Interactable) {
				((Interactable) ge).takenBy(getMaze().getPacman());
			}
		}
		getMaze().getPacman().move(_tickProgression);
	}
}
