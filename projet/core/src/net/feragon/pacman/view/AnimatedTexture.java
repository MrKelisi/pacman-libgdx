package net.feragon.pacman.view;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class AnimatedTexture implements ITexturable {
	private ArrayList<Texture> _textures;
	private double _fps;
	private double _progression;
	
	public AnimatedTexture(double fps, Texture... texture) {
		if(fps <= 0) {
			throw new IllegalArgumentException("FPS <= 0");
		}
		
		_fps = fps;
		_textures = new ArrayList<Texture>();
		_progression = 0;
		
		for(int i = 0; i < texture.length; i++) {
			addTexture(texture[i]);
		}
	}
	
	/**
	 * Ajoute une texture à l'animation
	 * @param texture Nouvelle texture
	 */
	public void addTexture(Texture texture) {
		if(texture == null) {
			throw new NullPointerException("Texture null");
		}
		
		_textures.add(texture);
	}
	
	/**
	 * Met à jour la texture
	 * @param timeElapsed Temps écoulé depuis la dernière mise à jour
	 */
	public void update(double timeElapsed) {
		_progression = (_progression + (timeElapsed * _fps)) % (double)_textures.size();
	}
	
	@Override
	public void dispose() {
		for(Texture texture : _textures) {
			texture.dispose();
		}
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return _textures.get((int) Math.floor(_progression));
	}

}
