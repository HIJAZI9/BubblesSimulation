package entities;

import org.lwjgl.util.vector.Vector3f;

import models.TextureModel;

public class Entity {
private TextureModel model ; 
private Vector3f position;
private float roX , roY , roZ ; 
private float scale;
public Entity(TextureModel model, Vector3f position, float roX, float roY, float roZ, float scale) {
	this.model = model;
	this.position = position;
	this.roX = roX;
	this.roY = roY;
	this.roZ = roZ;
	this.scale = scale;
}

public void increasePosition(float dx, float dy, float dz ) {
	this.position.x+=dx;
	this.position.y+=dy;
	this.position.z+=dz;
}

public void increaseRotation(float roX ,float roY ,float roZ) {
 this.roX += roX;
 this.roY +=roY;
 this.roZ +=roZ;		
}



public TextureModel getModel() {
	return model;
}
public void setModel(TextureModel model) {
	this.model = model;
}
public Vector3f getPosition() {
	return position;
}
public void setPosition(Vector3f position) {
	this.position = position;
}
public float getRoX() {
	return roX;
}
public void setRoX(float roX) {
	this.roX = roX;
}
public float getRoY() {
	return roY;
}
public void setRoY(float roY) {
	this.roY = roY;
}
public float getRoZ() {
	return roZ;
}
public void setRoZ(float roZ) {
	this.roZ = roZ;
}
public float getScale() {
	return scale;
}
public void setScale(float scale) {
	this.scale = scale;
}

}
