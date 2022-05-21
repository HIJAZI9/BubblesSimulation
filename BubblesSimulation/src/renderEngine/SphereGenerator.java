package renderEngine;

import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class SphereGenerator{
    public static List<Float> generateSpherePositions(GL11 gl, double d, int stack, int slice) {
        List<Float> coords = new ArrayList<Float>();
        float r0, r1, alpha0, alpha1, x0, x1, y0, y1, z0, z1, beta;
        float stackStep = (float) (Math.PI / stack);
        float sliceStep = (float) (Math.PI / slice);
        for (int i = 0; i < stack; ++i) {
            alpha0 = (float) (-Math.PI / 2 + i * stackStep);
            alpha1 = alpha0 + stackStep;
            r0 = (float) (d * Math.cos(alpha0));
            r1 = (float) (d * Math.cos(alpha1));

            y0 = (float) (d * Math.sin(alpha0));
            y1 = (float) (d * Math.sin(alpha1));

            for (int j = 0; j < (slice << 1); ++j) {
                beta = j * sliceStep;//  w ww  .  j  a va 2  s.c o  m
                x0 = (float) (r0 * Math.cos(beta));
                x1 = (float) (r1 * Math.cos(beta));

                z0 = (float) (-r0 * Math.sin(beta));
                z1 = (float) (-r1 * Math.sin(beta));

                coords.add(x0);
                coords.add(y0);
                coords.add(z0);
                coords.add(x1);
                coords.add(y1);
                coords.add(z1);
            }

        }
   return coords;
    }
    
    public static float [] generateSphereUV(int size_of_uv) {
    	float uv [] = {0 , 0  , 1 , 0 ,  0 , 1 , 1 , 1 };
    	int j=0;
    	
    	float uv_arr [] = new float [size_of_uv];
    	for (int i=0 ; i<size_of_uv ; i++) {
    	   uv_arr[i] = uv[j];
    	   j++;
    	   j=j% uv.length;
    	}
    	
    	return uv_arr;
    	
    	
    }
}