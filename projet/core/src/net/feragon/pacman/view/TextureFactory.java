package net.feragon.pacman.view;

import java.util.HashMap;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.*;

public class TextureFactory implements IUpdateable {
	private static TextureFactory instance = null;
	private HashMap<Class<? extends GameElement>, ITexturable> textures;
	private Texture ghostEscaping;
	private Texture ghostDead;
	
	private TextureFactory() {
		ghostEscaping = new Texture("images/ghostEscaping.png");
		ghostDead = new Texture("images/ghostDead.png");
		
		textures = new HashMap<Class<? extends GameElement>, ITexturable>();
		
		textures.put(Pacman.class, new PacmanTexture());
		addSingleTexture(Block.class, "images/bloc.png");
		addSingleTexture(Point.class, "images/pellet.png");
		addSingleTexture(SuperPellet.class, "images/superpellet.png");
		textures.put(RedMonster.class, new MonsterTexture(new Texture("images/ghost1.png"), ghostEscaping, ghostDead));
		textures.put(PinkMonster.class, new MonsterTexture(new Texture("images/ghost2.png"), ghostEscaping, ghostDead));
		textures.put(CyanMonster.class, new MonsterTexture(new Texture("images/ghost3.png"), ghostEscaping, ghostDead));
		textures.put(YellowMonster.class, new MonsterTexture(new Texture("images/ghost4.png"), ghostEscaping, ghostDead));
		addSingleTexture(Blank.class, "images/dark.png");
	}
	
	/**
	 * Ajoute une texture simple
	 * @param c Classe
	 * @param path Chemin de la texture
	 */
	private void addSingleTexture(Class<? extends GameElement> c, String path) {
		textures.put(c, new SingleTexture(new Texture(path)));
	}
	
	/**
	 * @return Instance de TextureFactory
	 */
	public static TextureFactory getInstance() {
		if(instance == null) {
			instance = new TextureFactory();
		}
		return instance;
	}
	
	/**
	 * Remet l'instance à zéro
	 */
	public void reset() {
		instance = null;
	}
	
	@Override
	public void finalize() {
		dispose();
	}

	/**
	 * Libère les textures
	 */
	private void dispose() {
		for(ITexturable texture : textures.values()) {
			texture.dispose();
		}
		
		ghostEscaping.dispose();
		ghostDead.dispose();
	}
	
	/**
	 * @param c Classe
	 * @param ge Élément concerné
	 * @return Texture demandée
	 */
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

	@Override
	public void update(double timeElapsed) {
		for(ITexturable texture : textures.values()) {
			if(texture instanceof IUpdateable) {
				((IUpdateable) texture).update(timeElapsed);
			}
		}
	}
}
