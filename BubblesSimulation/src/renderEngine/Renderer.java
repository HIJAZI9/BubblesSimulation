package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;

import entities.Entity;
import models.RawModel;
import models.TextureModel;
import shaders.StaticShader;
import textures.ModelTexture;
import toolbox.Maths;

public class Renderer {

	private static final float FOV=70;
	private static final float NEAR_PLANE = 1f;
	private static final float FAR_PLANE = 1000;
	private Matrix4f projectionMatrix;

	public Renderer(StaticShader shader){
		createProjectionMatrix();
		shader.start();
		shader.loadProjectionMatrix(projectionMatrix);
		shader.stop();
	}

	
	//we will call it for every frame
	public void prepare() {

		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	    GL11.glEnable(GL11.GL_SMOOTH);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glClearColor(0.5f, 0.7f, 0, 0); // red green blue alpha
		
	}
	
	public void render(Entity entity , StaticShader shader) {
		TextureModel model =entity.getModel();
		RawModel rawModel = model.getRawModel();	
		GL30.glBindVertexArray(rawModel.getVaoID()); //bind vao
		GL20.glEnableVertexAttribArray(0);   //enable vbo
		GL20.glEnableVertexAttribArray(1); 
		GL20.glEnableVertexAttribArray(2); 
		
		Matrix4f transformationMatrix = Maths.createTransformationMatrix(entity.getPosition(), entity.getRoX(), entity.getRoY(), entity.getRoZ(), entity.getScale());
		shader.loadTransformationMatrix(transformationMatrix);

		//shinees and reflectivity
		ModelTexture texture= model.getModelTexture();
		shader.loadShineVariable(texture.getShineDamper() , texture.getReflectivity());

		GL13.glActiveTexture(GL13.GL_TEXTURE0);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getModelTexture().getID());
		//GL11.GL_POINTS GL11.GL_LINES GL11. GL_TRIANGLES GL_TRIANGLE_FAN
		GL11.glDrawElements(GL11.GL_TRIANGLE_STRIP, rawModel.getVertexCount(), GL11.GL_UNSIGNED_INT, 0); //draw from first vertex to the last
		
		GL20.glDisableVertexAttribArray(2);
		GL20.glDisableVertexAttribArray(1);
		GL20.glDisableVertexAttribArray(0); //disable vbo
	    GL30.glBindVertexArray(0); //unbind vao
	   
	}
	
	private void createProjectionMatrix() {
		float aspectRatio = (float) DisplayManager.WIDTH/ (float) DisplayManager.HEIGH;
		float y_scale = (float) ((1f / Math.tan(Math.toRadians(FOV / 2f))) * aspectRatio);
		float x_scale = y_scale / aspectRatio;
		float frustum_length = FAR_PLANE - NEAR_PLANE;

		projectionMatrix = new Matrix4f();
		projectionMatrix.m00 = x_scale;
		projectionMatrix.m11 = y_scale;
		projectionMatrix.m22 = -((FAR_PLANE + NEAR_PLANE) / frustum_length);
		projectionMatrix.m23 = -1;
		projectionMatrix.m32 = -((2 * NEAR_PLANE * FAR_PLANE) / frustum_length);
		projectionMatrix.m33 = 0;
	}
	
}
