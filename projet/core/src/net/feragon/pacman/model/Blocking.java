package net.feragon.pacman.model;

public interface Blocking {
	/**
	 * @return Vrai si le bloc laisse passer les monstres
	 */
	boolean allowMonsters();
}
