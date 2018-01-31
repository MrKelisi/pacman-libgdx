package net.feragon.pacman.model;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class LevelFactory {
	private static final int BLOCK = '1';
	private static final int POINT = '0';
	private static final int BONUS = 'B';
	private static final int PACMAN = 'P';
	private static final int RED = 'W';
	private static final int CYAN = 'X';
	private static final int YELLOW = 'Y';
	private static final int PINK = 'Z';
	
	private int width;
	private int height;
	private ArrayList<Block> blocs;
	private ArrayList<Point> points;
	private Pacman pacman;
	
	public LevelFactory(String fileName, World world) {
		blocs = new ArrayList<Block>();
		points = new ArrayList<Point>();
		loadLevel(fileName, world);
	}

	public ArrayList<Block> getBlocs() {
		return blocs;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void loadLevel(String fileName, World world) {
		int x = 0;
		int y = 0;
		String file = Gdx.files.internal(fileName).readString();
		
		for(char c : file.toCharArray()) {
			Vector2 position = new Vector2(x, y);
			
			switch (c) {
				case BLOCK:
					blocs.add(new Block(position, world));
					break;
				
				case PACMAN:
					pacman = new Pacman(position, world);
					break;
					
				case POINT:
					points.add(new Point(position, world));
					break;
					
				case '\n':
					y++;
					x = -1;
					break;
			}
			x++;	
		}
	
		for(Block ge : blocs) {
			correctPosition(ge, y);
		}
		
		for(Point ge : points) {
			correctPosition(ge, y);
		}
	
		correctPosition(pacman, y);
		
		width = x;
		height = y + 1;
	}

	public Pacman getPacman() {
		return pacman;
	}
	
	private void correctPosition(GameElement ge, int y) {
		ge.setPosition(new Vector2(ge.getPosition().x, y - ge.getPosition().y));
	}
}
