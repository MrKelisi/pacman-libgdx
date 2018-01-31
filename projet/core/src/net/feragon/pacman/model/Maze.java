package net.feragon.pacman.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import com.badlogic.gdx.math.Vector2;

public class Maze implements Iterable<GameElement> {
	private int width;
	private int height;
	private World world;
	private HashMap<Vector2, GameElement> blocs;
	private HashMap<Vector2, GameElement> points;
	private ArrayList<GameElement> elements;
	private Pacman pacman;
	
	public Maze(World world) {
		width = 0;
		height = 0;
		this.world = world;
		blocs = new HashMap<Vector2, GameElement>();
		points = new HashMap<Vector2, GameElement>();
		elements = new ArrayList<GameElement>();
		
		loadDemoLevel();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Block get(int x, int y) {
		GameElement block = blocs.get(new Vector2(x, y));
		if(block instanceof Block) {
			return (Block) block;
		}
		
		return null;
	}
	
	private void loadDemoLevel() {
		LevelFactory level = new LevelFactory("levels/demo.txt", world);
	
		width = level.getWidth();
		height = level.getHeight();
		
		for(GameElement ge : level.getBlocs()) {
			blocs.put(ge.getPosition(), ge);
			elements.add(ge);
		}
		
		for(GameElement ge : level.getPoints()) {
			points.put(ge.getPosition(), ge);
			elements.add(ge);
		}
		
		pacman = level.getPacman();
	}
	
	public Pacman getPacman() {
		return pacman;
	}

	public Iterator<GameElement> iterator() {
		return elements.iterator();
	}
}
