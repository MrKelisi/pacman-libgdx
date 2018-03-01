package net.feragon.pacman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;

public class Maze implements Iterable<GameElement> {
	private int width;
	private int height;
	private World world;
	private HashMap<Class<? extends GameElement>, ArrayList<GameElement>> _elements;
	private HashMap<Vector2, GameElement> _elementsPos;
	private Pacman pacman;
	private ArrayList<Class<? extends GameElement>> displayOrder;
	private ArrayList<Monster> _monsters;
	
	public Maze(World world) {
		width = 0;
		height = 0;
		this.world = world;
		_elementsPos = new HashMap<Vector2, GameElement>();
		_monsters = new ArrayList<Monster>();
		
		loadDemoLevel();
		
		
		displayOrder = new ArrayList<Class<? extends GameElement>>();
		displayOrder.add(Block.class);
		displayOrder.add(Point.class);
		displayOrder.add(SuperPellet.class);
		displayOrder.add(PinkMonster.class);
		displayOrder.add(RedMonster.class);
		displayOrder.add(CyanMonster.class);
		displayOrder.add(YellowMonster.class);
		displayOrder.add(Pacman.class);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	/**
	 * Donne l'objet à la position donnée
	 * @param pos Position
	 * @return GameElement
	 */
	public GameElement get(Vector2 pos) {
        return _elementsPos.get(pos);
	}
	
	private void loadDemoLevel() {
		LevelFactory level = new LevelFactory("levels/demo.txt", world);
	
		width = level.getWidth();
		height = level.getHeight();
		
		_elements = level.getElements();
		
		for(ArrayList<GameElement> gameElements : _elements.values()) {
			for(GameElement ge : gameElements) {
				_elementsPos.put(ge.getPosition(), ge);
				
				if(ge instanceof Monster) {
					_monsters.add((Monster) ge); 
				}
			}
		}
		
		pacman = (Pacman) _elements.get(Pacman.class).get(0);
	}
	
	public Pacman getPacman() {
		return pacman;
	}

	/**
	 * Donne la liste des monstres
	 * @return Liste des monstres
	 */
	public ArrayList<Monster> getMonsters() {
		return _monsters;
	}

	@Override
	public Iterator<GameElement> iterator() {
		return new Iterator<GameElement>() {
			private Iterator<Class<? extends GameElement>> order = displayOrder.iterator();
			private Iterator<GameElement> iterator = null;
			
			private Iterator<GameElement> getIterator() {
				while((iterator == null || !iterator.hasNext()) && order.hasNext()) {
					iterator = _elements.get(order.next()).iterator();
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
