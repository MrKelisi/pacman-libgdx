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
	private HashMap<Class<? extends GameElement>, ITexturable> textures;
	
	private TextureFactory() {
		textures = new HashMap<Class<? extends GameElement>, ITexturable>();
		
		textures.put(Pacman.class, new PacmanTexture());
		addSingleTexture(Block.class, "images/bloc.png");
		addSingleTexture(Point.class, "images/pellet.png");
		addSingleTexture(SuperPellet.class, "images/superpellet.png");
		addSingleTexture(RedMonster.class, "images/ghost1.png");
		addSingleTexture(PinkMonster.class, "images/ghost2.png");
		addSingleTexture(CyanMonster.class, "images/ghost3.png");
		addSingleTexture(YellowMonster.class, "images/ghost4.png");
	}
	
	private void addSingleTexture(Class<? extends GameElement> c, String path) {
		textures.put(c, new SingleTexture(new Texture(path)));
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
		for(ITexturable texture : textures.values()) {
			texture.dispose();
		}
	}
	
	public Texture getTexture(Class<? extends GameElement> c) {
		return textures.get(c).getTexture();
	}
	
	/**
	 * Donne l'object ITexturable associé à la classe
	 * @param c Classe de l'élément
	 * @return ITexturable
	 */
	public ITexturable getITexturable(Class<? extends GameElement> c) {
		return textures.get(c);
	}
}
