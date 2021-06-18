package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.App.Carga;
import com.mygdx.game.Pantalla.*;
import com.mygdx.game.Utiles.Render;

public class MiJuego extends Game {


	@Override
	public void create () {
		Render.app=this;
		Render.batch=new SpriteBatch();
			Carga.guardarItems();
			Carga.guardarHabilidades();
			this.setScreen(new PantallaCarga());
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		Render.batch.dispose();
	}
}