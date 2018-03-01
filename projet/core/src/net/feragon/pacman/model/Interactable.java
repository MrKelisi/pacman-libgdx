package net.feragon.pacman.model;

public interface Interactable {
	/**
	 * Méthode appelée lorsque que le joueur arrive sur l'élément
	 * @param pacman Joueur
	 */
	void takenBy(Pacman pacman);
}
