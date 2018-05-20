package net.feragon.pacman.screens;

import com.badlogic.gdx.Game;
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

public class TitleScreen implements Screen {

    private Stage _stage;
    private Game _game;

    private Label title;
    private TextButton playButton;
    private TextButton exitButton;

    public TitleScreen(Game game) {
        _game = game;
        _stage = new Stage();

        BitmapFont font = new BitmapFont(Gdx.files.internal("fonts/ubuntu.fnt"));


        Label.LabelStyle titleStyle = new Label.LabelStyle();
        titleStyle.font = font;
        titleStyle.fontColor = new Color(255,255,0,255);

        title = new Label("Pacman Game!", titleStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight()*2/3);
        title.setWidth(Gdx.graphics.getWidth());
        _stage.addActor(title);


        TextButton.TextButtonStyle playButtonStyle = new TextButton.TextButtonStyle();
        playButtonStyle.font = font;
        playButtonStyle.fontColor = new Color(255, 255, 255, 255);
        playButtonStyle.overFontColor = new Color(0, 0, 255, 255);

        playButton = new TextButton("Play!", playButtonStyle);
        playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
        playButton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                ((PacmanGDX) _game).setUpGameScreen();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        _stage.addActor(playButton);


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
                System.exit(0);
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
        return playButton;
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
}
