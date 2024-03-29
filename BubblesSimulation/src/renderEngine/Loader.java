package renderEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import models.RawModel;

public class Loader {
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();
	private List<Integer> textures = new ArrayList<Integer>();
	
	
 public RawModel loadToVAO(float [] positions,float [] textureCoords, float [] normals,int [] indeces) {
	 int vaoID = createVAO();
	 bindIndecesBuffer(indeces);
	 vaos.add(vaoID);
	 storeDataInAttributeList(0, 3,positions);
	 storeDataInAttributeList(1, 2,textureCoords);
	 storeDataInAttributeList(2, 3,normals);
	 unbindVAO();
	 return new RawModel(vaoID , indeces.length);
 }
 
 public int loadTexture(String filename) {
	 Texture texture =null;
	 try {
		texture = TextureLoader.getTexture("PNG" , new FileInputStream("res/"+filename +".png" ));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int textureID= texture.getTextureID();
	textures.add(textureID);
	return textureID;
 }
 
 public void cleanUP() {
	 for(int vao : vaos) {
		 GL30.glDeleteVertexArrays(vao);
	 }
	 for(int vbo : vbos) {
		 GL30.glDeleteVertexArrays(vbo);
	 }
	 for(int texture : textures) {
		 GL11.glDeleteTextures(texture);
	 }
	 
 }
 private int createVAO() {
	 int vaoID=GL30.glGenVertexArrays(); // generate vao
	 GL30.glBindVertexArray(vaoID); //activiate vao
	 return vaoID;
 }
 
 private void storeDataInAttributeList(int attributeNumber, int coordinateSize , float [] data) {
	 int vboID = GL15.glGenBuffers();
	 vbos.add(vboID);
	 GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
	//convert data to float buffer
	 FloatBuffer buffer = storeDataInFloatBuffer(data);
	 GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer,GL15.GL_STATIC_DRAW);
    
    //load vbo on vao
	 //attribute number ,  3 means x,y,z ,  type of coordinates ,  0 : the data not normalized , 0 not other data between vertex
	 GL20.glVertexAttribPointer(attributeNumber,coordinateSize, GL11.GL_FLOAT, false, 0,0);
	 
	 //unbind current vbo
	 GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,0);
 }   
 private void bindIndecesBuffer(int [] indeces) {
	 int vboID = GL15.glGenBuffers();
	 vbos.add(vboID);
	 GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vboID);
	 IntBuffer buffer = storeDataInIntBuffer(indeces);
	 GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER,buffer, GL15.GL_STATIC_DRAW);
 }
 
 private IntBuffer storeDataInIntBuffer(int [] data ) {
	 IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
	 buffer.put(data);
	 buffer.flip();
	 return buffer;
	 
	 
 }
 
 private void unbindVAO() {
	 GL30.glBindVertexArray(0);
 }
 
 
 
 private FloatBuffer storeDataInFloatBuffer(float [] data) {
	 FloatBuffer buffer  =  BufferUtils.createFloatBuffer(data.length);
	 buffer.put(data);
	 buffer.flip();
	 return buffer;
	 
 }
}
