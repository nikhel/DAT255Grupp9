package com.me.space;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpaceInvaders extends Game {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	private FPSLogger fpsLogger;
	public static final String LOG = SpaceInvaders.class.getSimpleName();
	
	
	
	@Override
	public void create() {	
		
		Gdx.app.log(SpaceInvaders.LOG, "Creating Game");
		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		fpsLogger = new FPSLogger();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
	}

	@Override
	public void dispose() {
		Gdx.app.log(SpaceInvaders.LOG, "Disposing game");
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		fpsLogger.log();
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log(SpaceInvaders.LOG, "Rezising Game to: " + width + " x " + height);
		
	}

	@Override
	public void pause() {
		Gdx.app.log(SpaceInvaders.LOG, "Pausing game");
	}

	@Override
	public void resume() {
		Gdx.app.log(SpaceInvaders.LOG, "Resuming game");
	}
}
