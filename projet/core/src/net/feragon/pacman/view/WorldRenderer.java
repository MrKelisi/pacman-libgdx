package net.feragon.pacman.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.feragon.pacman.model.EndGameException;
import net.feragon.pacman.model.GameElement;
import net.feragon.pacman.model.Pacman;
import net.feragon.pacman.model.World;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

public class WorldRenderer {
	private SpriteBatch spriteBatch;
	private World world;
	private Vector2 size;
	private OrthographicCamera camera;
    private BitmapFont font = new BitmapFont();
	
	public WorldRenderer(final World world) {
		spriteBatch = new SpriteBatch();
		this.world = world;
		size = new Vector2(16, 16);
		
		camera = new OrthographicCamera();
		float width = world.getWidth() * size.x;
		float height = (world.getHeight()+2) * size.y;
		
		camera.setToOrtho(false, width, height);
		camera.position.set(width/2, height/2, 0);
	}
	
	/**
	 * Render a game frame
	 * @param timeElapsed Time elapsed since last frame
	 * @throws EndGameException If the player won or lost
	 */
	public void render(float timeElapsed) throws EndGameException {
		world.update(timeElapsed);
		
		TextureFactory.getInstance().update(timeElapsed);
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		
		spriteBatch.setProjectionMatrix(camera.combined);
		
		spriteBatch.begin();
		for(GameElement ge : world) {
			if(ge.isShown()) {
				spriteBatch.draw(TextureFactory.getInstance().getTexture(ge), ge.getPosition().x * size.x, (ge.getPosition().y+2) * size.y, size.x, size.y);
			}
		}

        font.draw(spriteBatch, "Score : " + world.getMaze().getPacman().points(), 8, 22);

		font.draw(spriteBatch, "Remaining lifes : " + world.getMaze().getPacman().getLifes(), 320, 22);
		
		spriteBatch.end();
	}
	
	/**
	 * Libère les ressources
	 */
	public void dispose() {
		spriteBatch.dispose();
	}
}
