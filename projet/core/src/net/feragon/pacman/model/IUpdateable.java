package net.feragon.pacman.model;

public interface IUpdateable {
	/**
	 * Update the class
	 * @param timeElapsed Time elapsed since last frame
	 */
	void update(double timeElapsed);
}
