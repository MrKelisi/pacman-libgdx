package net.feragon.pacman.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import net.feragon.pacman.PacmanGDX;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(28*16, 33*16);
		config.setResizable(false);

		new Lwjgl3Application(new PacmanGDX(), config);
	}
}
