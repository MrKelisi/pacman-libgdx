package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.Monster;

public class MonsterTexture implements ITexturable {
	private Texture _texture;
	private AnimatedTexture _weakTexture;
	private Texture _eyesTexture;
	private double _oldWeakTime;
	
	/**
	 * Create an ITexturable for monsters
	 * @param texture Monster texture, this class will take ownership
	 * @param escaping Escaping texture
	 * @param dead Dead texture
	 */
	public MonsterTexture(Texture texture, Texture escaping, Texture dead) {
		if(texture == null) {
			throw new NullPointerException("Texture null");
		}
		
		_oldWeakTime = Monster.WEAK_TIME;
		
		_weakTexture = new AnimatedTexture(1, escaping);
		_weakTexture.addTexture(texture);
		
		_texture = texture;

		_eyesTexture = dead;
	}

	@Override
	public void dispose() {
		_texture.dispose();
	}

	@Override
	public Texture getTexture(GameElement element) {
		if(!(element instanceof Monster)) {
			throw new IllegalArgumentException("L'instance de l'élément doit être un Monster");
		}
		
		Monster monster = (Monster) element;
		if(monster.isDead()) {
			return _eyesTexture;
		}

		double weakTime = monster.getWeakTime();
		if(weakTime > 0) {
			if(_oldWeakTime < weakTime) {
				_oldWeakTime = Monster.WEAK_TIME;
			}
			
			_weakTexture.setFps(Monster.WEAK_TIME - weakTime);
			_weakTexture.update(_oldWeakTime - weakTime);
			
			_oldWeakTime = weakTime;
			
			return _weakTexture.getTexture(null);
		}
		
		return _texture;
	}

}
