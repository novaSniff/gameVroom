package gameVroom;

import org.lwjgl.util.glu.GLU;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.*;


public class Renderie {
	
	public void thing(){
		
		
		
			glPushMatrix();
			glTranslatef(0,0,-10 );
		
			glBegin( GL_TRIANGLES );
			glColor3f( 1.0f, 0.0f, 0.0f ); glVertex3f( 0.0f, 1.f, 0.0f );
			glColor3f( 0.0f, 1.0f, 0.0f ); glVertex3f( -1.0f, -1.0f, 1.0f );
			glColor3f( 0.0f, 0.0f, 1.0f ); glVertex3f( 1.0f, -1.0f, 1.0f);

			glColor3f( 1.0f, 0.0f, 0.0f ); glVertex3f( 0.0f, 1.0f, 0.0f);
			glColor3f( 0.0f, 1.0f, 0.0f ); glVertex3f( -1.0f, -1.0f, 1.0f);
			glColor3f( 0.0f, 0.0f, 1.0f ); glVertex3f( 0.0f, -1.0f, -1.0f);

			glColor3f( 1.0f, 0.0f, 0.0f ); glVertex3f( 0.0f, 1.0f, 0.0f);
			glColor3f( 0.0f, 1.0f, 0.0f ); glVertex3f( 0.0f, -1.0f, -1.0f);
			glColor3f( 0.0f, 0.0f, 1.0f ); glVertex3f( 1.0f, -1.0f, 1.0f);


			glColor3f( 1.0f, 0.0f, 0.0f ); glVertex3f( -1.0f, -1.0f, 1.0f);
			glColor3f( 0.0f, 1.0f, 0.0f ); glVertex3f( 0.0f, -1.0f, -1.0f);
			glColor3f( 0.0f, 0.0f, 1.0f ); glVertex3f( 1.0f, -1.0f, 1.0f);

			glEnd();
			glPopMatrix();
		
		
		
		
	}



	
}

