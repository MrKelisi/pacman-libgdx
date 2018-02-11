package net.feragon.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import net.feragon.pacman.view.TextureFactory;

public class Point extends GameElement {
	private boolean isSuperPellet;
	
	public Point(Vector2 position, World world, boolean isSuperPellet) {
		super(position, world);
		this.isSuperPellet = isSuperPellet;
	}
	
	@Override
	public Texture getTexture() {
		if(isSuperPellet) {
			return TextureFactory.getInstance().getSuperPellet();
		}
		else {
			return TextureFactory.getInstance().getTexturePoint();
		}
	}

}
