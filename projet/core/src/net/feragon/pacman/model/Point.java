package net.feragon.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import net.feragon.pacman.view.TextureFactory;

public class Point extends GameElement {
	public Point(Vector2 position, World world) {
		super(position, world);
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return getTexture().getWidth();
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return getTexture().getHeight();
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return TextureFactory.getInstance().getTexturePoint();
	}

}
