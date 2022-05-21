package bubblesSimulation;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import models.RawModel;
import models.TextureModel;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DisplayManager.createDisplay();
		
		//create objects of loader and renderer
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

				
		RawModel myobj = OBJLoader.loadObjModel("firstBubble" , loader);
		ModelTexture myobj_texture = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_texture.setReflectivity(0.2f);
		myobj_texture.setShineDamper(5f);
		TextureModel myobj_textureModel = new TextureModel(myobj, myobj_texture);
		
		//bubble 1 and 2 will merged together
		Entity bubble1 = new Entity(myobj_textureModel, new Vector3f(3f,0f ,-10f), 0f, 0f, 0f, 1f);
		Entity bubble2 = new Entity(myobj_textureModel, new Vector3f(-3f,0f ,-10f), 0f, 0f, 0f, 1f);

		//bubble 3 and 4 will blow up
		Entity bubble3 = new Entity(myobj_textureModel, new Vector3f(-6f,0f ,-10f), 0f, 0f, 0f, 1f);
		Entity bubble4 = new Entity(myobj_textureModel, new Vector3f(-10f,0f ,-10f), 0f, 0f, 0f, 1f);
		
		//These bubbles are the result of the explosion.
		Entity explosion1 = new Entity(myobj_textureModel, new Vector3f(-8f,0f ,-10f), 0f, 0f, 0f, 0.25f);
		Entity explosion2 = new Entity(myobj_textureModel, new Vector3f(-8.5f,0f ,-10f), 0f, 0f, 0f, 0.25f);
		Entity explosion3 = new Entity(myobj_textureModel, new Vector3f(-7.5f,0f ,-10f), 0f, 0f, 0f, 0.25f);
		Entity explosion4 = new Entity(myobj_textureModel, new Vector3f(-8f,0.5f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion5 = new Entity(myobj_textureModel, new Vector3f(-8f,-0.5f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion6 = new Entity(myobj_textureModel, new Vector3f(-8f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion7 = new Entity(myobj_textureModel, new Vector3f(-8f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion8 = new Entity(myobj_textureModel, new Vector3f(-8f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion9 = new Entity(myobj_textureModel, new Vector3f(-8f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		
		//these bubbles will moves up at random movement
		Entity bubble5 = new Entity(myobj_textureModel, new Vector3f(-10f,-12f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble6 = new Entity(myobj_textureModel, new Vector3f(-7f,-10f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble7 = new Entity(myobj_textureModel, new Vector3f(-3f,-12f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble8 = new Entity(myobj_textureModel, new Vector3f(0f,-10f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble9 = new Entity(myobj_textureModel, new Vector3f(3f,-12f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble10 = new Entity(myobj_textureModel, new Vector3f(6f,-10f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble11 = new Entity(myobj_textureModel, new Vector3f(9f,-12f ,-7f), 0f, 0f, 0f, 1f);
		
		
		
		RawModel myobj_FG = OBJLoader.loadObjModel("beforeCompleteCollision0" , loader);
		ModelTexture myobj_FG__texture = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture.setReflectivity(0.5f);
		myobj_FG__texture.setShineDamper(5f);
		TextureModel myobj_FG__textureModel = new TextureModel(myobj_FG, myobj_FG__texture);
		Entity bcc0 = new Entity(myobj_FG__textureModel, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		RawModel myobj_FG1 = OBJLoader.loadObjModel("beforeCompleteCollision1" , loader);
		ModelTexture myobj_FG__texture1 = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture1.setReflectivity(0.5f);
		myobj_FG__texture1.setShineDamper(5f);
		TextureModel myobj_FG__textureModel1 = new TextureModel(myobj_FG1, myobj_FG__texture1);
		Entity bcc1 = new Entity(myobj_FG__textureModel1, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		RawModel myobj_FG2 = OBJLoader.loadObjModel("beforeCompleteCollision2" , loader);
		ModelTexture myobj_FG__texture2 = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture2.setReflectivity(0.5f);
		myobj_FG__texture2.setShineDamper(5f);
		TextureModel myobj_FG__textureModel2 = new TextureModel(myobj_FG2, myobj_FG__texture2);
		Entity bcc2 = new Entity(myobj_FG__textureModel2, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		
		RawModel myobj_FG3 = OBJLoader.loadObjModel("beforeCompleteCollision3" , loader);
		ModelTexture myobj_FG__texture3 = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture3.setReflectivity(0.5f);
		myobj_FG__texture3.setShineDamper(5f);
		TextureModel myobj_FG__textureModel3 = new TextureModel(myobj_FG3, myobj_FG__texture3);
		Entity bcc3 = new Entity(myobj_FG__textureModel3, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		
		
		
		RawModel wallOBJ = OBJLoader.loadObjModel("wall" , loader);
		ModelTexture wall_texture = new ModelTexture(loader.loadTexture("background"));
		wall_texture.setReflectivity(0.5f);
		wall_texture.setShineDamper(100000f);
		TextureModel wall_textureModel = new TextureModel(wallOBJ, wall_texture);
		Entity wall = new Entity(wall_textureModel, new Vector3f(0f,0f ,-12f), 90f, 0f, 0f, 1f);
		
		
		
		
		
		Light light1 = new Light(new Vector3f(400f , 400f, 300.0f ) , new Vector3f(0.7f , 0.9f ,0.07f));
		Light light2 = new Light(new Vector3f(-50f , -50f, 300.0f ) , new Vector3f(0.7f , 0.8f ,0.7f));
		Camera camera = new Camera();
		Vector3f camera_position =camera.getPosition();
		camera_position.z +=6;
		camera.setPosition(camera_position);
		
		float before_complete_collision = 1.0f;
		
		float scale_after_collision = 1.3f;
		
		
		float bubble3_move=0.0f;
		float bubble4_move=0.0f;
		
		
		//loop until press on "X"
		while(! Display.isCloseRequested()) {
		
			
			
			camera.move();
			renderer.prepare();
           shader.start();
           shader.loadLight(light1);
           shader.loadLight(light2);
           shader.loadViewMatrix(camera);
		
           
           
           
           //********************game logic************************** 
           
           
           
           //display 7 bubbles moves from down to top
           bubble5.increasePosition(0f, 0.01f, 0f);
		   bubble6.increasePosition(0f, 0.01f, 0f);
		   bubble7.increasePosition(0f, 0.01f, 0f);
		   bubble8.increasePosition(0f, 0.01f, 0f);
	       bubble9.increasePosition(0f, 0.01f, 0f);
		   bubble10.increasePosition(0f, 0.01f, 0f);
		   bubble11.increasePosition(0f, 0.01f, 0f);
			
           bubble5.increasePosition((float)Math.random()/100, (float)Math.random()/10000, (float) Math.random()/100);
           renderer.render(bubble5, shader);
           bubble6.increasePosition((float)Math.random()/100, (float)Math.random()/10000, (float) Math.random()/100);
           renderer.render(bubble6, shader);
           bubble7.increasePosition((float)Math.random()/100, (float)Math.random()/1000, (float) Math.random()/100);
           renderer.render(bubble7, shader);
           bubble8.increasePosition((float)Math.random()/100, (float)Math.random()/1000, (float) Math.random()/100);
           renderer.render(bubble8, shader);
           bubble9.increasePosition((float)Math.random()/100, (float)Math.random()/1000, (float) Math.random()/100);
           renderer.render(bubble9, shader);
           bubble10.increasePosition((float)Math.random()/100, (float)Math.random()/1000, (float) Math.random()/100);
           renderer.render(bubble10, shader);
           bubble11.increasePosition((float)Math.random()/100, (float)Math.random()/1000, (float) Math.random()/100);
           renderer.render(bubble11, shader);
           
           //display background image
           renderer.render(wall, shader);
           
           
           
           //*************************************************************************
           //******************merge tow bubble in one bubble*************************
           //*************************************************************************
           if(bubble1.getPosition().x > 1.3f) { //move bubble1 towards bubble2
				bubble1.increasePosition(-0.007f, 0f, 0f);    
              }
			if(bubble2.getPosition().x < -1.3f) {//move bubble2 towards bubble1
				bubble2.increasePosition(0.007f, 0f, 0f);
				renderer.render(bubble1 ,shader);
		        renderer.render(bubble2 ,shader);      
			}
			else { // when the distance between bubble1 and 2 becomes 2.6
				if(before_complete_collision <= 1.18) {
					if(before_complete_collision<1.04) {
					before_complete_collision +=0.001f;
					   renderer.render(bcc0 ,shader);		   
					}
					else if(before_complete_collision<=1.08) {
						before_complete_collision +=0.001f;
						 renderer.render(bcc1 ,shader);
					}
					else if(before_complete_collision<=1.12) {
						before_complete_collision +=0.001f;
						 renderer.render(bcc2 ,shader);
					}
					else if(before_complete_collision<=1.18) {
						before_complete_collision +=0.001f;
						 renderer.render(bcc3 ,shader);
					}
					
				}
				else {//display one bubble instead of tow bubbles.
					if(scale_after_collision <1.5f) {//keep scaling
					bubble1.setPosition(new Vector3f(0f,0f,-10f));
					scale_after_collision+=0.001f;
					bubble1.setScale(scale_after_collision);
					renderer.render(bubble1 ,shader);
					}
					else { //move the one bubble collision upward
						bubble1.increasePosition(0f, 0.01f,0f);
						renderer.render(bubble1 ,shader);
					}
				}
			}		
		
			//***********************************************************
			//Move two bubbles towards each other and then blow them up.
			//***********************************************************
			if(bubble3_move > -1f) { //move bubble 3 towards bubble 4
				bubble3_move -=0.01f;
				bubble3.increasePosition(-0.01f , 0.0f , 0.0f);
		           renderer.render(bubble3, shader);
				
			}
			if(bubble4_move < 1f) {//move bubble 4 towards bubble 3
				bubble4_move += 0.01f;
				bubble4.increasePosition(0.01f , 0.0f , 0.0f);
		           renderer.render(bubble4, shader);
			}
			else { //display 8 bubbles as result of explosion
				explosion1.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion1, shader);
				explosion2.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion2, shader);
				explosion3.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion3, shader);
				explosion4.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion4, shader);
				explosion5.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion5, shader);
				explosion6.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion6, shader);
				explosion7.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion7, shader);
				explosion8.increasePosition((float)Math.random()/100, (float)Math.random()/100, (float) Math.random()/100);
				renderer.render(explosion8, shader);
			}

	           
           
			shader.stop();
			
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUP();
		loader.cleanUP();
		DisplayManager.closeDisplay();
		
	}

}
