package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {

	public static final int WIDTH =1024;
	public static final int HEIGH =800;
	public static final int FPS_CAP = 320;
	
	public static void createDisplay() {
		
		ContextAttribs attribs = new ContextAttribs(3,2)
		//.attribs.withForwardCompatible(true)
	    //.attribs.withProfileCore(true);
		.withForwardCompatible(true)
		.withProfileCore(true);
		
		//width , high , bitDepth , refresh rate
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGH));
			Display.create(new PixelFormat() , attribs);
			Display.setTitle("bubbles simulation");
			
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// x , y , width , heigh
		GL11.glViewport(0,0, WIDTH, HEIGH);
	}
	public static void updateDisplay() {
	    Display.sync(FPS_CAP);
	    Display.update();
	}
	
	public static void closeDisplay() {
      Display.destroy();
	}
	
}
