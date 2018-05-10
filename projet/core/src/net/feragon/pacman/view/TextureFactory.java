package net.feragon.pacman.view;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.*;

public class TextureFactory {
	private static TextureFactory instance = null;
	private HashMap<Class<? extends GameElement>, ITexturable> textures;
	private Texture blank;
	
	private TextureFactory() {
		textures = new HashMap<Class<? extends GameElement>, ITexturable>();
		
		textures.put(Pacman.class, new PacmanTexture());
		addSingleTexture(Block.class, "images/bloc.png");
		addSingleTexture(Point.class, "images/pellet.png");
		addSingleTexture(SuperPellet.class, "images/superpellet.png");
		textures.put(RedMonster.class, new MonsterTexture(new Texture("images/ghost1.png")));
		textures.put(PinkMonster.class, new MonsterTexture(new Texture("images/ghost2.png")));
		textures.put(CyanMonster.class, new MonsterTexture(new Texture("images/ghost3.png")));
		textures.put(YellowMonster.class, new MonsterTexture(new Texture("images/ghost4.png")));
		addSingleTexture(Blank.class, "images/dark.png");
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
	
	public Texture getTexture(Class<? extends GameElement> c, GameElement ge) {
		return textures.get(c).getTexture(ge);
	}
	
	/**
 	 * Donne la texture de l'objet demandé
 	 * @param instance Instance de l'objet
     * @return Texture
	 */
	public <T extends GameElement> Texture getTexture(T instance) {
		return textures.get(instance.getClass()).getTexture(instance);
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
