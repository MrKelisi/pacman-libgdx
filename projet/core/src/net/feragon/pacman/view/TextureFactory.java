package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;

public class TextureFactory {
	private static TextureFactory instance = new TextureFactory();
	private Texture pacman;
	private Texture bloc;
	private Texture point;
	private Texture superPellet;
	
	private Texture redMonster;
	private Texture yellowMonster;
	private Texture pinkMonster;
	private Texture cyanMonster;
	
	private TextureFactory() {
		pacman = new Texture("images/pacman-3.png");
		bloc = new Texture("images/bloc.png");
		point = new Texture("images/pellet.png");
		superPellet = new Texture("images/superpellet.png");
		redMonster = new Texture("images/ghost1.png");
		pinkMonster = new Texture("images/ghost2.png");
		cyanMonster = new Texture("images/ghost3.png");
		yellowMonster = new Texture("images/ghost4.png");
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
	
	public Texture getSuperPellet() {
		return superPellet;
	}

	public Texture getRedMonster() {
		return redMonster;
	}

	public Texture getYellowMonster() {
		return yellowMonster;
	}

	public Texture getPinkMonster() {
		return pinkMonster;
	}

	public Texture getCyanMonster() {
		return cyanMonster;
	}

	public void dispose() {
		pacman.dispose();
		bloc.dispose();
		point.dispose();
		superPellet.dispose();
		cyanMonster.dispose();
		pinkMonster.dispose();
		yellowMonster.dispose();
		redMonster.dispose();
	}

}
