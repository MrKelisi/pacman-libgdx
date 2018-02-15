package net.feragon.pacman.view;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.Block;
import net.feragon.pacman.model.CyanMonster;
import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.Pacman;
import net.feragon.pacman.model.PinkMonster;
import net.feragon.pacman.model.Point;
import net.feragon.pacman.model.RedMonster;
import net.feragon.pacman.model.SuperPellet;
import net.feragon.pacman.model.YellowMonster;

public class TextureFactory {
	private static TextureFactory instance = null;
	private HashMap<Class<? extends GameElement>, Texture> textures;
	
	private TextureFactory() {
		textures = new HashMap<Class<? extends GameElement>, Texture>();
		
		textures.put(Pacman.class, new Texture("images/pacman-3.png"));
		textures.put(Block.class, new Texture("images/bloc.png"));
		textures.put(Point.class, new Texture("images/pellet.png"));
		textures.put(SuperPellet.class, new Texture("images/superpellet.png"));
		textures.put(RedMonster.class, new Texture("images/ghost1.png"));
		textures.put(PinkMonster.class, new Texture("images/ghost2.png"));
		textures.put(CyanMonster.class, new Texture("images/ghost3.png"));
		textures.put(YellowMonster.class, new Texture("images/ghost4.png"));
	}
	
	public static TextureFactory getInstance() {
		if(instance == null) {
			instance = new TextureFactory();
		}
		return instance;
	}
	
	public void reset() {
		instance = null;
	}
	
	@Override
	public void finalize() {
		dispose();
	}

	private void dispose() {
		for(Texture texture : textures.values()) {
			texture.dispose();
		}
	}
	
	public Texture getTexture(Class<? extends GameElement> c) {
		return textures.get(c);
	}
}
