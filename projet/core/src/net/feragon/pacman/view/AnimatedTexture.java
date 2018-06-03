package net.feragon.pacman.view;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.IUpdateable;

public class AnimatedTexture implements ITexturable, IUpdateable {
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
	
	@Override
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
	public Texture getTexture(GameElement element) {
		return _textures.get((int) Math.floor(_progression));
	}

	/**
	 * Change la vitesse
	 * @param fps Nombre d'images par seconde
	 */
	public void setFps(double fps) {
		this._fps = fps;
	}
}
