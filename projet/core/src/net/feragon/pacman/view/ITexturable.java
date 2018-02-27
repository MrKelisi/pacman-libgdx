package net.feragon.pacman.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public interface ITexturable extends Disposable {
	/**
	 * @return Texture
	 */
	Texture getTexture();
}
