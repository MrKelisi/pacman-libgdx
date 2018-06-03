package net.feragon.pacman.view;

import java.util.EnumMap;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.Direction;
import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.IUpdateable;
import net.feragon.pacman.model.Pacman;

public class PacmanTexture implements ITexturable, IUpdateable {
	private EnumMap<Direction, AnimatedTexture> _textures;

	public PacmanTexture() {
        int fps = 7;
		_textures = new EnumMap<Direction, AnimatedTexture>(Direction.class);
		
		_textures.put(Direction.LEFT, new AnimatedTexture(
				fps,
				new Texture("images/pacmanLeft-2.png"),
				new Texture("images/pacmanLeft.png"),
				new Texture("images/pacman-3.png")
		));
		
		_textures.put(Direction.UP, new AnimatedTexture(
				fps,
				new Texture("images/pacmanUp-2.png"),
				new Texture("images/pacmanUp.png"),
				new Texture("images/pacman-3.png")
		));
		
		_textures.put(Direction.RIGHT, new AnimatedTexture(
				fps,
				new Texture("images/pacmanRight-2.png"),
				new Texture("images/pacmanRight.png"),
				new Texture("images/pacman-3.png")
		));
		
		_textures.put(Direction.DOWN, new AnimatedTexture(
				fps,
				new Texture("images/pacmanDown-2.png"),
				new Texture("images/pacmanDown.png"),
				new Texture("images/pacman-3.png")
		));
		
		if(_textures.size() != Direction.values().length) {
			throw new IllegalStateException("Toutes les directions ne sont pas définies");
		}
	}

	@Override
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
	public Texture getTexture(GameElement element) {
		if(!(element instanceof Pacman)) {
			throw new IllegalArgumentException("L'élément doit être une instance de Pacman");
		}
		
		return _textures.get(((Pacman) element).direction()).getTexture(null);
	}

}
