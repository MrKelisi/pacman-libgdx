package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
	private static TextureFactory instance = new TextureFactory();
	private Texture pacman;
	private Texture bloc;
	private Texture point;
	
	private TextureFactory() {
		pacman = new Texture("images/pacman-3.png");
		bloc = new Texture("images/bloc.png");
		point = new Texture("images/pellet.png");
	}
	
	public static TextureFactory getInstance() {
		return instance;
	}

	public Texture getTexturePacman() {
		return pacman;
	}

	public Texture getTextureBloc() {
		return bloc;
	}
	
	public Texture getTexturePoint() {
		return point;
	}

	public void dispose() {
		pacman.dispose();
		bloc.dispose();
	}

}
