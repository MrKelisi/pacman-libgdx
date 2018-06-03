package net.feragon.pacman.model;

import com.badlogic.gdx.math.Vector2;

public abstract class GameElement {
	private Vector2 position;
	protected World world;
	private boolean show = true;
	
	public GameElement(Vector2 position, World world) {
		this.position = position;
		this.world = world;
	}

	/**
	 * @return Position de l'élément
	 */
	public Vector2 getPosition() {
		return position;
	}
	
	/**
	 * Change la position
	 * @param position Nouvelle position
	 */
	public void setPosition(Vector2 position) {
		this.position = position;
	}

	/**
	 * @return Vrai si l'élément doit s'afficher
	 */
	public boolean isShown() {
		return show;
	}

	/**
	 * Définit l'affichage de l'élément
	 * @param sh Vrai si l'élément doit être affiché
	 */
	public void setShow(boolean sh) {
		show = sh;
	}
}
