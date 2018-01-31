package net.feragon.pacman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.feragon.pacman.PacmanGDX;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 496;
		config.width = 448;
		new LwjglApplication(new PacmanGDX(), config);
	}
}
