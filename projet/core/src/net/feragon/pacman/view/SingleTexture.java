package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.GameElement;

public class SingleTexture implements ITexturable {
	private Texture _texture;
	
	/**
	 * Crée une texture non animée
	 * @param texture Texture utilisée
	 */
	public SingleTexture(Texture texture) {
		if(texture == null) {
			throw new NullPointerException("Texture null");
		}
		
		_texture = texture;
	}


	@Override
	public Texture getTexture(GameElement element) {
		return _texture;
	}


	@Override
	public void dispose() {
		_texture.dispose();
	}
}
