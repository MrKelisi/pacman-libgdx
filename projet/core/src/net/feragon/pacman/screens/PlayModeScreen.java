package net.feragon.pacman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import net.feragon.pacman.PacmanGDX;

public class PlayModeScreen implements Screen {

    private Stage _stage;
    private PacmanGDX _game;

    private Label title;
    private Image arrows;
    private Image cursor;

    public PlayModeScreen(PacmanGDX game) {
        _game = game;
        _stage = new Stage();

        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/ubuntu.fnt"));
        Texture arrowsTexture = new Texture("images/arrows.png");
        Texture cursorTexture = new Texture("images/cursor.png");


        Label.LabelStyle titleStyle = new Label.LabelStyle();
        titleStyle.font = font;
        titleStyle.fontColor = new Color(255,255,0,255);

        title = new Label("Choose a game mode:", titleStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        _stage.addActor(title);


        arrows = new Image(arrowsTexture);
        arrows.setPosition(50, Gdx.graphics.getHeight()/4);
        arrows.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                _game.setUpGameScreen('a');
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        _stage.addActor(arrows);


        cursor = new Image(cursorTexture);
        cursor.setPosition(Gdx.graphics.getWidth() - cursorTexture.getWidth() - 50, Gdx.graphics.getHeight()/4);
        cursor.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                _game.setUpGameScreen('c');
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        _stage.addActor(cursor);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(_stage);
    }

    @Override
    public void render(float timeElapsed) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        _stage.act();
        _stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        _stage.dispose();
    }

	public Stage getStage() {
		return _stage;
	}
}
