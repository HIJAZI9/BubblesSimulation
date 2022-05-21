package models;

//Represent 3d models stored in memory
public class RawModel {
private int vaoID; //id of 3d model
private int vertexCount; // number of 3d object's vertex

public RawModel(int vaoID , int vertexCount) {
	this.vaoID = vaoID;
	this.vertexCount = vertexCount;
}

public int getVaoID() {
	return vaoID;
}

public void setVaoID(int vaoID) {
	this.vaoID = vaoID;
}

public int getVertexCount() {
	return vertexCount;
}

public void setVertexCount(int vertexCount) {
	this.vertexCount = vertexCount;
}

}
