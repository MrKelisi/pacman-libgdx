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

	public Iterator<GameElement> iterator() {
		return new Iterator<GameElement>() {
			private Iterator<GameElement> blocs = getMaze().getBlocs().iterator();
			private Iterator<GameElement> points = getMaze().getElements().iterator();
			private Iterator<? extends GameElement> monsters = getMaze().getMonsters().iterator();
			boolean pacmanGiven = false;
			
			private Iterator<? extends GameElement> getNextIterator() {
				if(blocs.hasNext()) {
					return blocs;
				}
				
				if(points.hasNext()) {
					return points;
				}
				if(monsters.hasNext()) {
					return monsters;
				}
				
				return null;
			}
			
			@Override
			public boolean hasNext() {
				return !pacmanGiven;
			}

			@Override
			public GameElement next() {
				Iterator<? extends GameElement> ge = getNextIterator();
				if(ge == null) {
					if(!pacmanGiven) {
						pacmanGiven = true;
						return getMaze().getPacman();
					}
					else {
						throw new RuntimeException("Il n'y a plus d'éléments");
					}
				}
				
				return ge.next();
			}
		};
	}
}
