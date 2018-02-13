package net.feragon.pacman.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import com.badlogic.gdx.math.Vector2;

public class Maze {
	private int width;
	private int height;
	private World world;
	private HashMap<Vector2, GameElement> blocs;
	private HashMap<Vector2, GameElement> elements;
	private ArrayList<Monster> monsters;
	private Pacman pacman;
	
	public Maze(World world) {
		width = 0;
		height = 0;
		this.world = world;
		blocs = new HashMap<Vector2, GameElement>();
		elements = new HashMap<Vector2, GameElement>();
		monsters = new ArrayList<Monster>();
		
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
		}
		
		for(GameElement ge : level.getPoints()) {
			elements.put(ge.getPosition(), ge);
		}
		
		monsters = level.getMonsters();
		pacman = level.getPacman();
	}
	
	public Pacman getPacman() {
		return pacman;
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	
	public Collection<GameElement> getBlocs() {
		return blocs.values();
	}
	
	public Collection<GameElement> getElements() {
		return elements.values();
	}
}
