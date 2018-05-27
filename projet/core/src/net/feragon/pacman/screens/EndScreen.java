package net.feragon.pacman.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import net.feragon.pacman.PacmanGDX;

public class EndScreen implements Screen {

    private Stage _stage;
    private PacmanGDX _game;

    private Label title;
    private TextButton replayButton;
    private TextButton exitButton;

    public EndScreen(PacmanGDX game, int score) {
        _game = game;
        _stage = new Stage();

        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/ubuntu.fnt"));


        Label.LabelStyle titleStyle = new Label.LabelStyle();
        titleStyle.font = font;
        titleStyle.fontColor = new Color(0,255,40,255);

        title = new Label("You won!\nYour score is "+score, titleStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        _stage.addActor(title);


        TextButton.TextButtonStyle playButtonStyle = new TextButton.TextButtonStyle();
        playButtonStyle.font = font;
        playButtonStyle.fontColor = new Color(255, 255, 255, 255);
        playButtonStyle.overFontColor = new Color(0, 0, 255, 255);

        replayButton = new TextButton("Replay?", playButtonStyle);
        replayButton.setWidth(Gdx.graphics.getWidth()/2);
        replayButton.setPosition(Gdx.graphics.getWidth()/2-replayButton.getWidth()/2,Gdx.graphics.getHeight()/2-replayButton.getHeight()/2);
        replayButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                _game.setUpPlayModeScreen();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        _stage.addActor(replayButton);


        TextButton.TextButtonStyle exitButtonStyle = new TextButton.TextButtonStyle();
        exitButtonStyle.font = font;
        exitButtonStyle.fontColor = new Color(255, 255, 255, 255);
        exitButtonStyle.overFontColor = new Color(255, 0, 0, 255);

        exitButton = new TextButton("Quit", exitButtonStyle);
        exitButton.setWidth(Gdx.graphics.getWidth()/2);
        exitButton.setPosition(Gdx.graphics.getWidth()/2-exitButton.getWidth()/2,Gdx.graphics.getHeight()/2-2*exitButton.getHeight());
        exitButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        _stage.addActor(exitButton);
    }

    public Label getTitle() {
        return title;
    }
    public TextButton getPlayButton() {
        return replayButton;
    }
    public TextButton getExitButton() {
        return exitButton;
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