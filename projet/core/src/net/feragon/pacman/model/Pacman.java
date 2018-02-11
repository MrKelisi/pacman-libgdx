package net.feragon.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import net.feragon.pacman.view.TextureFactory;

public class Pacman extends GameElement {
	public Pacman(Vector2 position, World world) {
		super(position, world);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return TextureFactory.getInstance().getTexturePacman();
	}

	public void update(float timeElapsed) {
		
	}
}
