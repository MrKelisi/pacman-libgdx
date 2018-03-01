package net.feragon.pacman.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class LevelFactory {
	private HashMap<Character, Class<? extends GameElement>> elementClasses;
	
	private int width;
	private int height;
	private HashMap<Class<? extends GameElement>, ArrayList<GameElement>> elements;
	
	public LevelFactory(String fileName, World world) {
		elements = new HashMap<Class<? extends GameElement>, ArrayList<GameElement>>();
		elementClasses = new HashMap<Character, Class<? extends GameElement>>();
		
		elementClasses.put('1', Block.class);
		elementClasses.put('0', Point.class);
		elementClasses.put('B', SuperPellet.class);
		elementClasses.put('P', Pacman.class);
		elementClasses.put('W', RedMonster.class);
		elementClasses.put('X', CyanMonster.class);
		elementClasses.put('Y', YellowMonster.class);
		elementClasses.put('Z', PinkMonster.class);
		elementClasses.put('V', Blank.class);

		
		loadLevel(fileName, world);
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
			
			Class<? extends GameElement> elementClass = elementClasses.get(c);
			if(elementClass == null) {
				if(c == '\n') {
					y++;
					x = -1;
				}
			}
			else {
				try {
					GameElement ge = elementClass.getConstructor(Vector2.class, World.class).newInstance(position, world);
					if(elements.containsKey(elementClass)) {
						elements.get(elementClass).add(ge);
					}
					else {
						ArrayList<GameElement> elementList = new ArrayList<GameElement>();
						elementList.add(ge);
						elements.put(elementClass, elementList);
					}
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			x++;	
		}
	
		for(ArrayList<GameElement> elementList : elements.values()) {
			for(GameElement ge : elementList) {
				correctPosition(ge, y);
			}
		}
		
		width = x;
		height = y + 1;
		
		if(!elements.containsKey(Pacman.class) || elements.get(Pacman.class).size() != 1) {
			throw new RuntimeException("Le niveau ne contient pas ou plusieurs de Pac-Man");
		}
	}
	
	private void correctPosition(GameElement ge, int y) {
		ge.setPosition(new Vector2(ge.getPosition().x, y - ge.getPosition().y));
	}

	public HashMap<Class<? extends GameElement>, ArrayList<GameElement>> getElements() {
		return elements;
	}
}
