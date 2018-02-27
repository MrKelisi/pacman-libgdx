package net.feragon.pacman.view;

import java.util.EnumMap;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.Direction;
import net.feragon.pacman.model.Pacman;

public class PacmanTexture implements ITexturable {
	private EnumMap<Direction, AnimatedTexture> _textures;
	private Pacman _pacman;
	
	public PacmanTexture() {
		_pacman = null;
		_textures = new EnumMap<Direction, AnimatedTexture>(Direction.class);
		
		_textures.put(Direction.LEFT, new AnimatedTexture(
				3, 
				new Texture("images/pacmanLeft-2.png"),
				new Texture("images/pacmanLeft.png"),
				new Texture("images/pacman-3.png")
		));
		
		_textures.put(Direction.UP, new AnimatedTexture(
				3, 
				new Texture("images/pacmanUp-2.png"),
				new Texture("images/pacmanUp.png"),
				new Texture("images/pacman-3.png")
		));
		
		_textures.put(Direction.RIGHT, new AnimatedTexture(
				3, 
				new Texture("images/pacmanRight-2.png"),
				new Texture("images/pacmanRight.png"),
				new Texture("images/pacman-3.png")
		));
		
		_textures.put(Direction.DOWN, new AnimatedTexture(
				3, 
				new Texture("images/pacmanDown-2.png"),
				new Texture("images/pacmanDown.png"),
				new Texture("images/pacman-3.png")
		));
		
		if(_textures.size() != Direction.values().length) {
			throw new IllegalStateException("Toutes les directions ne sont pas définies");
		}
	}
	
	/**
	 * Définit le pacman à afficher
	 * @param pacman
	 */
	public void setPacman(Pacman pacman) {
		_pacman = pacman;
	}

	/**
	 * Met à jour les textures 
	 * @param timeElapsed Temps écoulé depuis la dernière mise à jour 
	 */
	public void update(double timeElapsed) {
		for(AnimatedTexture texture : _textures.values()) {
			texture.update(timeElapsed);
		}
	}
	
	@Override
	public void dispose() {
		for(AnimatedTexture texture : _textures.values()) {
			texture.dispose();
		}
	}

	@Override
	public Texture getTexture() {
		return _textures.get(_pacman.direction()).getTexture();
	}

}
