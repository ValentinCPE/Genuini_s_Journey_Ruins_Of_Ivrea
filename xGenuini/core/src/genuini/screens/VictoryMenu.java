/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genuini.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import genuini.game.ScreenEnum;
import genuini.game.ScreenManager;
import static genuini.main.MainGame.V_HEIGHT;
import static genuini.main.MainGame.V_WIDTH;
import static genuini.main.MainGame.contentManager;




/**
 *
 * @author Adrien
 */
public class VictoryMenu extends AbstractScreen{
    private TextButton menuButton;
    private Table table;
    private final boolean debug=false;
    private final int buttonWidth;
    private final int buttonHeight;


    private TextField gameOver;
    
    public VictoryMenu(){
        super();
        buttonWidth=V_WIDTH/15;
        buttonHeight=V_HEIGHT/20;
        contentManager.getSound("victory").play();

    }
    
    @Override
    public void buildStage() {
        menuButton=new TextButton("Menu", skinManager.createButtonSkin(buttonWidth,buttonHeight));
        menuButton.setPosition((V_WIDTH-buttonWidth)/2, (V_HEIGHT-buttonHeight)/2 - 50);
        

        
        stage.addActor(menuButton);

        
        gameOver = new TextField("Congratulations, the demonstration is finished !", skinManager.textFieldSkin(buttonWidth, buttonHeight, Color.WHITE, false, Color.CLEAR, Color.CLEAR, Color.DARK_GRAY, 1f));
        table = new Table();
        table.setSize(V_WIDTH,V_HEIGHT/8);
        table.add(gameOver).width(550);
        table.setPosition(1, V_HEIGHT/2);
        table.center();
        // table.align(Align.right | Align.bottom);
        if(debug){
            table.debug();// Enables debug lines for tables.
        }
        stage.addActor(table);
    }
    
    
    
    @Override
    public void show() {
      Gdx.input.setInputProcessor(stage);
      menuButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
               contentManager.getMusic("deathMusic").stop();
               ScreenManager.getInstance().showScreen( ScreenEnum.MAIN_MENU);
            }
        });
    }
    
    
    
    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();  
    }
    
    
}
