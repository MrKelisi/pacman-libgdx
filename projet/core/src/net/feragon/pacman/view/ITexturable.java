package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

import net.feragon.pacman.model.GameElement;

public interface ITexturable extends Disposable {
	/**
	 * @param element instance associée
	 * @return Texture Texture de l'élément
	 */
	Texture getTexture(GameElement element);
}
