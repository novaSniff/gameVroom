package gameVroom;

import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL11.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.Display;



public class Shader {
	static int shaderProgram = glCreateProgram();
	static int vertexShader = glCreateShader(GL_VERTEX_SHADER);
	static int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
	static StringBuilder vertexShaderSource = new StringBuilder();
	static StringBuilder fragmentShaderSource = new StringBuilder();
	
	static void readAndShade(){
	BufferedReader reader = null;
	try{
		reader = new BufferedReader(new FileReader("src/gameVroom/vshader.vs"));
		String line;
		while((line = reader.readLine()) != null){
			vertexShaderSource.append(line).append('\n');
		}
	}catch(IOException e){
		System.err.println("Vert don't vert O:");
		Display.destroy();
		System.exit(1);
	}finally{
		if(reader != null){
			try{
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	BufferedReader reader2 = null;
	try{
		reader2 = new BufferedReader(new FileReader("src/gameVroom/fshader.fs"));
		String line;
		while((line = reader2.readLine()) != null){
			fragmentShaderSource.append(line).append('\n');
		}
	}catch(IOException e){
		System.err.println("Frag don't frag O:");
		Display.destroy();
		System.exit(1);
	}finally{
		if(reader2 != null){
			try{
				reader2.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	glShaderSource(vertexShader, vertexShaderSource);
	glCompileShader(vertexShader);
	if(glGetShaderi(vertexShader, GL_COMPILE_STATUS)==GL_FALSE){
		System.err.println("Vertex shader wasn't able to compile");
	}
	
	if(glGetShaderi(vertexShader, GL_INFO_LOG_LENGTH)==GL_TRUE){
		System.err.println(GL_INFO_LOG_LENGTH);
	}
	glShaderSource(fragmentShader, fragmentShaderSource);
	glCompileShader(fragmentShader);
	if(glGetShaderi(fragmentShader, GL_COMPILE_STATUS)==GL_FALSE){
		System.err.println("Fragment shader wasn't able to compile");
	}
	
	}
	
	static void beginGLSL(){
		glAttachShader(shaderProgram,vertexShader);
		glAttachShader(shaderProgram, fragmentShader);
		glLinkProgram(shaderProgram);
		glValidateProgram(shaderProgram);
		
	}
	static void endGLSL(){
		glDeleteProgram(shaderProgram);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);
	}
}
