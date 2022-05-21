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
		Entity bu1Merg1 = new Entity(myobj_textureModel, new Vector3f(14f,0f ,-10f), 0f, 0f, 0f, 1f);
		Entity bu2Merg1 = new Entity(myobj_textureModel, new Vector3f(-14f,0f ,-10f), 0f, 0f, 0f, 1f);

		//bubble 1 and 2 will merged together
		Entity bu3Merg2 = new Entity(myobj_textureModel, new Vector3f(14f,-4f ,-10f), 0f, 0f, 0f, 1f);
		Entity bu4Merg2 = new Entity(myobj_textureModel, new Vector3f(-14f,-4f ,-10f), 0f, 0f, 0f, 1f);

		//bubble 3 and 4 will blow up
		Entity bubble3 = new Entity(myobj_textureModel, new Vector3f(14f,0f ,-10f), 0f, 0f, 0f, 1f);
		Entity bubble4 = new Entity(myobj_textureModel, new Vector3f(-14f,0f ,-10f), 0f, 0f, 0f, 1f);
		
		//These bubbles are the result of the explosion of bubble 3 and 4
		Entity explosion1 = new Entity(myobj_textureModel, new Vector3f(0f,0f ,-10f), 0f, 0f, 0f, 0.25f);
		Entity explosion2 = new Entity(myobj_textureModel, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 0.25f);
		Entity explosion3 = new Entity(myobj_textureModel, new Vector3f(-0.5f,0f ,-10f), 0f, 0f, 0f, 0.25f);
		Entity explosion4 = new Entity(myobj_textureModel, new Vector3f(0f,0.5f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion5 = new Entity(myobj_textureModel, new Vector3f(0f,-0.5f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion6 = new Entity(myobj_textureModel, new Vector3f(0f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion7 = new Entity(myobj_textureModel, new Vector3f(0f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion8 = new Entity(myobj_textureModel, new Vector3f(0f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		Entity explosion9 = new Entity(myobj_textureModel, new Vector3f(0f,0f ,-10f), 0f, 0f, 0f,  0.25f);
		
		//these bubbles will moves up at random movement
		Entity bubble5 = new Entity(myobj_textureModel, new Vector3f(-10f,-12f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble6 = new Entity(myobj_textureModel, new Vector3f(-7f,-10f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble7 = new Entity(myobj_textureModel, new Vector3f(-3f,-12f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble8 = new Entity(myobj_textureModel, new Vector3f(0f,-10f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble9 = new Entity(myobj_textureModel, new Vector3f(3f,-12f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble10 = new Entity(myobj_textureModel, new Vector3f(6f,-10f ,-7f), 0f, 0f, 0f, 1f);
		Entity bubble11 = new Entity(myobj_textureModel, new Vector3f(9f,-12f ,-7f), 0f, 0f, 0f, 1f);
		
		
		//these bubbles are the result of merging bu1Merg1  and bu2Merg1
		RawModel myobj_FG = OBJLoader.loadObjModel("beforeCompleteCollision0" , loader);
		ModelTexture myobj_FG__texture = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture.setReflectivity(0.5f);
		myobj_FG__texture.setShineDamper(5f);
		TextureModel myobj_FG__textureModel = new TextureModel(myobj_FG, myobj_FG__texture);
		Entity merg1_0 = new Entity(myobj_FG__textureModel, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		RawModel myobj_FG1 = OBJLoader.loadObjModel("beforeCompleteCollision1" , loader);
		ModelTexture myobj_FG__texture1 = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture1.setReflectivity(0.5f);
		myobj_FG__texture1.setShineDamper(5f);
		TextureModel myobj_FG__textureModel1 = new TextureModel(myobj_FG1, myobj_FG__texture1);
		Entity merg1_1 = new Entity(myobj_FG__textureModel1, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		RawModel myobj_FG2 = OBJLoader.loadObjModel("beforeCompleteCollision2" , loader);
		ModelTexture myobj_FG__texture2 = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture2.setReflectivity(0.5f);
		myobj_FG__texture2.setShineDamper(5f);
		TextureModel myobj_FG__textureModel2 = new TextureModel(myobj_FG2, myobj_FG__texture2);
		Entity merg1_2 = new Entity(myobj_FG__textureModel2, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);

		
		RawModel myobj_FG3 = OBJLoader.loadObjModel("beforeCompleteCollision3" , loader);
		ModelTexture myobj_FG__texture3 = new ModelTexture(loader.loadTexture("firstBubble"));
		myobj_FG__texture3.setReflectivity(0.5f);
		myobj_FG__texture3.setShineDamper(5f);
		TextureModel myobj_FG__textureModel3 = new TextureModel(myobj_FG3, myobj_FG__texture3);
		Entity merg1_3 = new Entity(myobj_FG__textureModel3, new Vector3f(0.5f,0f ,-10f), 0f, 0f, 0f, 1f);
 
        		//these bubbles are the result of merging bu3Merg2  and bu4Merg2
				RawModel myobj_FG4 = OBJLoader.loadObjModel("beforeCompleteCollision0" , loader);
				ModelTexture myobj_FG__texture4 = new ModelTexture(loader.loadTexture("firstBubble"));
				myobj_FG__texture4.setReflectivity(0.5f);
				myobj_FG__texture4.setShineDamper(5f);
				TextureModel myobj_FG__textureModel4 = new TextureModel(myobj_FG4, myobj_FG__texture4);
				Entity merg2_0 = new Entity(myobj_FG__textureModel4, new Vector3f(0.5f,-4f ,-10f), 0f, 0f, 0f, 1f);

				RawModel myobj_FG5 = OBJLoader.loadObjModel("beforeCompleteCollision1" , loader);
				ModelTexture myobj_FG__texture5 = new ModelTexture(loader.loadTexture("firstBubble"));
				myobj_FG__texture5.setReflectivity(0.5f);
				myobj_FG__texture5.setShineDamper(5f);
				TextureModel myobj_FG__textureModel5 = new TextureModel(myobj_FG5, myobj_FG__texture5);
				Entity merg2_1 = new Entity(myobj_FG__textureModel5, new Vector3f(0.5f,-4f ,-10f), 0f, 0f, 0f, 1f);

				RawModel myobj_FG6 = OBJLoader.loadObjModel("beforeCompleteCollision2" , loader);
				ModelTexture myobj_FG__texture6 = new ModelTexture(loader.loadTexture("firstBubble"));
				myobj_FG__texture6.setReflectivity(0.5f);
				myobj_FG__texture6.setShineDamper(5f);
				TextureModel myobj_FG__textureModel6 = new TextureModel(myobj_FG6, myobj_FG__texture6);
				Entity merg2_2 = new Entity(myobj_FG__textureModel6, new Vector3f(0.5f,-4f ,-10f), 0f, 0f, 0f, 1f);

				
				RawModel myobj_FG7 = OBJLoader.loadObjModel("beforeCompleteCollision3" , loader);
				ModelTexture myobj_FG__texture7 = new ModelTexture(loader.loadTexture("firstBubble"));
				myobj_FG__texture7.setReflectivity(0.5f);
				myobj_FG__texture7.setShineDamper(5f);
				TextureModel myobj_FG__textureModel7 = new TextureModel(myobj_FG7, myobj_FG__texture7);
				Entity merg2_3 = new Entity(myobj_FG__textureModel7, new Vector3f(0.5f,-4f ,-10f), 0f, 0f, 0f, 1f);
		
		
		
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
		
		float before_complete_collision1 = 1.0f;
		float scale_after_collision1 = 1.3f;
		
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
           
           //merging bu3merg2 and bu4merg2		
           if(bu3Merg2.getPosition().x > 1.3f) { //move bu1Merg1 towards bu2Merg1
				bu3Merg2.increasePosition(-0.007f, 0f, 0f);    
              }
			if(bu4Merg2.getPosition().x < -1.3f) {//move bu2Merg1 towards bu1Merg1
				bu4Merg2.increasePosition(0.007f, 0f, 0f);
				renderer.render(bu3Merg2 ,shader);
		        renderer.render(bu4Merg2 ,shader);      
			}
			else { // when the distance between bu1Merg1 and 2 becomes 2.6
				if(before_complete_collision1 <= 1.18) {
					if(before_complete_collision1<1.04) {
					before_complete_collision1 +=0.001f;
					   renderer.render(merg2_0 ,shader);		   
					}
					else if(before_complete_collision1<=1.08) {
						before_complete_collision1 +=0.001f;
						 renderer.render(merg2_1 ,shader);
					}
					else if(before_complete_collision1<=1.12) {
						before_complete_collision1 +=0.001f;
						 renderer.render(merg2_2 ,shader);
					}
					else if(before_complete_collision1<=1.18) {
						before_complete_collision1 +=0.001f;
						 renderer.render(merg2_3 ,shader);
					}
					
				}
				else {//display one bubble instead of tow bubbles.
					if(scale_after_collision1 <1.5f) {//keep scaling
					bu3Merg2.setPosition(new Vector3f(0f,-4f,-10f));
					scale_after_collision1+=0.001f;
					bu3Merg2.setScale(scale_after_collision1);
					renderer.render(bu3Merg2 ,shader);
					}
					else { //move the one bubble collision upward
						bu3Merg2.increasePosition(0f, 0.01f,0f);
						renderer.render(bu3Merg2 ,shader);
					}
				}
			}		
		
            //merging bu1merg1 and bu2merg1			
           if(bu1Merg1.getPosition().x > 1.3f) { //move bu1Merg1 towards bu2Merg1
				bu1Merg1.increasePosition(-0.007f, 0f, 0f);    
              }
			if(bu2Merg1.getPosition().x < -1.3f) {//move bu2Merg1 towards bu1Merg1
				bu2Merg1.increasePosition(0.007f, 0f, 0f);
				renderer.render(bu1Merg1 ,shader);
		        renderer.render(bu2Merg1 ,shader);      
			}
			else { // when the distance between bu1Merg1 and 2 becomes 2.6
				if(before_complete_collision <= 1.18) {
					if(before_complete_collision<1.04) {
					before_complete_collision +=0.001f;
					   renderer.render(merg1_0 ,shader);		   
					}
					else if(before_complete_collision<=1.08) {
						before_complete_collision +=0.001f;
						 renderer.render(merg1_1 ,shader);
					}
					else if(before_complete_collision<=1.12) {
						before_complete_collision +=0.001f;
						 renderer.render(merg1_2 ,shader);
					}
					else if(before_complete_collision<=1.18) {
						before_complete_collision +=0.001f;
						 renderer.render(merg1_3 ,shader);
					}
					
				}
				else {//display one bubble instead of tow bubbles.
					if(scale_after_collision <1.5f) {//keep scaling
					bu1Merg1.setPosition(new Vector3f(0f,0f,-10f));
					scale_after_collision+=0.001f;
					bu1Merg1.setScale(scale_after_collision);
					renderer.render(bu1Merg1 ,shader);
					}
					else { //move the one bubble collision upward
						bu1Merg1.increasePosition(0f, 0.01f,0f);
						renderer.render(bu1Merg1 ,shader);
					}
				}
			}		
		
			//***********************************************************
			//Move two bubbles towards each other and then blow them up.
			//***********************************************************
			if(bu1Merg1.getPosition().y >1.0f) {
			if(bubble3_move > -13f) { //move bubble 3 towards bubble 4
				bubble3_move -=0.01f;
				bubble3.increasePosition(-0.01f , 0.0f , 0.0f);
		           renderer.render(bubble3, shader);
				
			}
			if(bubble4_move < 13f) {//move bubble 4 towards bubble 3
				bubble4_move += 0.01f;
				bubble4.increasePosition(0.01f , 0.0f , 0.0f);
		           renderer.render(bubble4, shader);
			}
			else { //display 8 bubbles as result of explosion
				explosion1.increasePosition((float)Math.random()/100, (float)Math.random()/100 , (float) Math.random()/100);
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
				//restore all bubbles
				if(explosion1.getPosition().y> 7f && explosion1.getPosition().y< 7.1f) {
					//restore merged bubbles 1 ,2
					bu1Merg1.setPosition(new Vector3f(14f,0f ,-10f));
					bu2Merg1.setPosition(new Vector3f(-14f,0f ,-10f));
					bu1Merg1.setScale(1.0f);
					merg1_0.setPosition(new Vector3f(0.5f,0f ,-10f));
					merg1_1.setPosition(new Vector3f(0.5f,0f ,-10f));
					merg1_2.setPosition(new Vector3f(0.5f,0f ,-10f));
					merg1_3.setPosition(new Vector3f(0.5f,0f ,-10f));
				    before_complete_collision = 1.0f;
				    scale_after_collision = 1.3f;
				  //restore merged bubbles 3 ,4
					bu3Merg2.setPosition(new Vector3f(14f,-4f ,-10f));
					bu4Merg2.setPosition(new Vector3f(-14f,-4f ,-10f));
					bu3Merg2.setScale(1.0f);
					merg2_0.setPosition(new Vector3f(0.5f,-4f ,-10f));
					merg2_1.setPosition(new Vector3f(0.5f,-4f ,-10f));
					merg2_2.setPosition(new Vector3f(0.5f,-4f ,-10f));
					merg2_3.setPosition(new Vector3f(0.5f,-4f ,-10f));
				    before_complete_collision1 = 1.0f;
				    scale_after_collision1 = 1.3f;
					
					//restore collision bubbles
					bubble3.setPosition(new Vector3f(14f,0f ,-10f));
					bubble4.setPosition(new Vector3f(-14f,0f ,-10f));
					bubble3_move=0.0f;
					bubble4_move=0.0f;
					explosion1.setPosition( new Vector3f(0f,0f ,-10f));
					explosion2.setPosition( new Vector3f(0.5f,0f ,-10f));
					explosion3.setPosition( new Vector3f(-0.5f,0f ,-10f));
					explosion4.setPosition(new Vector3f(0f,0.5f ,-10f));
					explosion5.setPosition(new Vector3f(0f,-0.5f ,-10f));
					explosion6.setPosition(new Vector3f(0f,0f ,-10f));
					explosion7.setPosition(new Vector3f(0f,0f ,-10f));
					explosion8.setPosition(new Vector3f(0f,0f ,-10f));
					explosion9.setPosition(new Vector3f(0f,0f ,-10f));
				    //restore the 9 bubbles
					 bubble5.setPosition  ( new Vector3f(-10f,-12f ,-7f));
					 bubble6.setPosition ( new Vector3f(-7f,-10f ,-7f));
					 bubble7.setPosition( new Vector3f(-3f,-12f ,-7f));
					 bubble8.setPosition( new Vector3f(0f,-10f ,-7f));
					 bubble9 .setPosition ( new Vector3f(3f,-12f ,-7f));
					 bubble10.setPosition ( new Vector3f(6f,-10f ,-7f));
					 bubble11.setPosition ( new Vector3f(9f,-12f ,-7f));

					
					
				}
			}
			}
	           
           
			shader.stop();
			
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUP();
		loader.cleanUP();
		DisplayManager.closeDisplay();
		
	}

}
