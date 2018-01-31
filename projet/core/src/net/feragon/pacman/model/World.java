package net.feragon.pacman.model;

import java.util.Iterator;

public class World implements Iterable<GameElement> {
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

	public Pacman getPacman() {
		return laby.getPacman();
	}

	public Iterator<GameElement> iterator() {
		return laby.iterator();
	}
}
