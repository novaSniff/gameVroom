package gameVroom;

import static org.lwjgl.opengl.GLUConstants.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.glUseProgram;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.*;

import static gameVroom.Camera.*;

public class MainThing {
	
	
	public static void main(String[] argv){
		initDisplay();
		gLoop();
		cleanUp();
}
	
final public static int winHeight = 600;
final public static int winWidth = 800;
	
	public static void gLoop(){
	
		
		Camera cam = new Camera(70,(float)winWidth/(float) winHeight,0.3f,1000);
		Shader shader = new Shader();
		Renderie renderie = new Renderie();
		
		
		initProjection();
		
		try {
			Texture texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/wood.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {
			 // TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		shader.readAndShade();
		Shader.beginGLSL();
		
		while(!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			
			glLoadIdentity();
			glUseProgram(shader.shaderProgram);
			cam.look();
			cam.useView();
			cam.mover();
			
			
			renderie.thing();
		
			
			
			Display.update();
			
			Display.sync(60);
		}
		
		Shader.endGLSL();
	}
	


	private Texture loadTexture(String key){
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/" + key + ".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void cleanUp(){
		Display.destroy();
		Mouse.destroy();
	}

	public static void initDisplay(){
		try{
			Display.setDisplayMode(new DisplayMode(winWidth,winHeight));
			Display.setResizable(true);
			Display.setTitle("gamiethingiy");
			Display.create();
			Mouse.create();
			
			}catch(LWJGLException e){
				e.printStackTrace();
				System.exit(0);
			}
	
		
	}
	
	public static void culling(){
		glEnable(GL_CULL_FACE);
		
		glCullFace(GL_BACK);
	}

}


	