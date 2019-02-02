package net.feragon.pacman.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.feragon.pacman.PacmanGDX;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 28*16;
		config.height = 33*16;
		config.resizable = false;

		new LwjglApplication(new PacmanGDX(), config);
	}
}
