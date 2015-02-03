package gameVroom;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;
import gameVroom.MainThing;
public class Camera {

private float x;
private float y;
private float z;

private float rx;
private float ry;
private float rz;

private static float fov;

private static float aspect;

private static float near;
private static float far;

private static float speed = 0.01f;

public static int mouseAmountX = Mouse.getDX();
public static int mouseAmountY = Mouse.getDY();

public Camera(float fov, float aspect, float near, float far){
	
	x = 0;
	y = 0;
	z = 0;
	rx = 0;
	ry = 0;
	rz = 0;
	
	this.fov = fov;
	this.aspect = aspect;
	this.near = near;
	this.far = far;
	initProjection();
	
	
	
}

public void mover(){
	if(Keyboard.isKeyDown(Keyboard.KEY_W)){
		move(1,0.05f);
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_S)){
		move(1,-0.05f);
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_A)){
		move(0,0.05f);
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_D)){
	move(0,-0.05f);
	}
}

public void look(){
	if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
		rx -= 1;
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
		rx += 1;
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
		ry -= 1;
	}
	if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
		ry += 1;
	}
	
	
	
}
static void initProjection(){
	
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluPerspective(fov,aspect,near,far);
	glMatrixMode(GL_MODELVIEW);
	glEnable(GL_DEPTH_TEST);
}

public void useView(){
	
	glRotatef(rx,1,0,0);
	glRotatef(ry,0,1,0);
	glRotatef(rz,0,0,1);
	glTranslatef(x,y,z);
}

//positional getters
public float getX(){
	return x;
}
public float getY(){
	return y;
}
public float getZ(){
	return z;
}

//positional setters
public void setX(float x){
	this.x = x;
}
public void setY(float y){
	this.y = y;
}
public void setZ(float z){
	this.z = z;
}


//rotational getters
public float getRX(){
	return rx;
}

public float getRY(){
	return ry;
}

public float getRZ(){
	return rz;
}

//rotational setters
public void setRX(float rx){
	this.rx = rx;
}
public void setRY(float ry){
	this.ry = ry;
}
public void setRZ(float rz){
	this.rz = rz;
}

//directional movers

public void move(float dir, float speed){
	
	z += speed * Math.sin(Math.toRadians(ry + 90 * dir));
	x+= speed * Math.cos(Math.toRadians(ry + 90 * dir));
}
public void moveX(float speed){
	x+=speed * Math.sin(Math.toRadians(ry+90));
	z+=speed * Math.cos(Math.toRadians(ry+90));
}
public void moveY(float speed){
	
}
}