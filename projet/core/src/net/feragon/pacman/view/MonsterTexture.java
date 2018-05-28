package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;

import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.Monster;

public class MonsterTexture implements ITexturable {
	private Texture _texture;
	private AnimatedTexture _weakTexture;
	private Texture _eyesTexture;
	private double _oldWeakTime;
	
	public MonsterTexture(Texture texture) {
		if(texture == null) {
			throw new NullPointerException("Texture null");
		}
		
		_oldWeakTime = Monster.WEAK_TIME;
		
		_weakTexture = new AnimatedTexture(1, new Texture("images/ghostEscaping.png")); //TODO: générer qu'une fois
		_weakTexture.addTexture(texture);
		
		_texture = texture;

		_eyesTexture = new Texture("images/ghostDead.png"); //TODO: générer qu'une fois
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
