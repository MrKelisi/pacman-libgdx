package net.feragon.pacman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;

public class Maze implements Iterable<GameElement> {
	private int width;
	private int height;
	private World world;
	private HashMap<Class<? extends GameElement>, ArrayList<GameElement>> elements;
	private Pacman pacman;
	
	public Maze(World world) {
		width = 0;
		height = 0;
		this.world = world;
		loadDemoLevel();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Block get(int x, int y) {
		/*GameElement block = blocs.get(new Vector2(x, y));
		if(block instanceof Block) {
			return (Block) block;
		}*/
		
		return null;
	}
	
	private void loadDemoLevel() {
		LevelFactory level = new LevelFactory("levels/demo.txt", world);
	
		width = level.getWidth();
		height = level.getHeight();
		
		elements = level.getElements();
	}
	
	public Pacman getPacman() {
		return pacman;
	}

	@Override
	public Iterator<GameElement> iterator() {
		return new Iterator<GameElement>() {
			private Iterator<ArrayList<GameElement>> iterators = elements.values().iterator();
			private Iterator<GameElement> iterator = null;
			
			private Iterator<GameElement> getIterator() {
				while((iterator == null || !iterator.hasNext()) && iterators.hasNext()) {
					iterator = iterators.next().iterator();
				}
				
				if(iterator.hasNext()) {
					return iterator;
				}
				else {
					return null;
				}
			}
			
			@Override
			public boolean hasNext() {
				return getIterator() != null;
			}

			@Override
			public GameElement next() {
				Iterator<GameElement> i = getIterator();
				if(i == null) {
					throw new RuntimeException("Il n'y a plus d'éléments");
				}
				
				return i.next();
			}
		};
	}
}
