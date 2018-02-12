package net.feragon.pacman.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import net.feragon.pacman.view.TextureFactory;

public class Monster extends GameElement {
	public enum Type {
		RED,
		YELLOW,
		PINK,
		CYAN,
	}
	
	private Type type;
	
	public Monster(Vector2 position, World world, Type type) {
		super(position, world);
		this.type = type;
	}

	/**
	 * Donne le type du monstre
	 * @return Type
	 */
	public Type getType() {
		return type;
	}

	@Override
	public Texture getTexture() {
		TextureFactory tf = TextureFactory.getInstance();
		switch (this.type) {
			case CYAN:
				return tf.getCyanMonster();
				
			case RED:
				return tf.getRedMonster();
				
			case YELLOW:
				return tf.getYellowMonster();
				
			case PINK:
				return tf.getPinkMonster();
		}
		
		return null;
	}

}
