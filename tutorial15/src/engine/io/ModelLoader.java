package engine.io;

import org.lwjgl.assimp.AIFace;
import org.lwjgl.assimp.AIMesh;
import org.lwjgl.assimp.AIScene;
import org.lwjgl.assimp.AIVector3D;
import org.lwjgl.assimp.Assimp;

import engine.graphics.Material;
import engine.graphics.Mesh;
import engine.graphics.Vertex;
import engine.maths.Vector2f;
import engine.maths.Vector3f;

public class ModelLoader {
	public static Mesh loadModel(String filePath, String texturePath) {
		AIScene scene = Assimp.aiImportFile(filePath, Assimp.aiProcess_JoinIdenticalVertices | Assimp.aiProcess_Triangulate);
		
		if (scene == null) System.err.println("Couldn't load model at " + filePath);
		
		AIMesh mesh = AIMesh.create(scene.mMeshes().get(0));
		int vertexCount = mesh.mNumVertices();
		
		AIVector3D.Buffer vertices = mesh.mVertices();
		AIVector3D.Buffer normals = mesh.mNormals();
		
		Vertex[] vertexList = new Vertex[vertexCount];
		
		for (int i = 0; i < vertexCount; i++) {
			AIVector3D vertex = vertices.get(i);
			Vector3f meshVertex = new Vector3f(vertex.x(), vertex.y(), vertex.z());
			
			AIVector3D normal = normals.get(i);
			Vector3f meshNormal = new Vector3f(normal.x(), normal.y(), normal.z());
			
			Vector2f meshTextureCoord = new Vector2f(0, 0);
			if (mesh.mNumUVComponents().get(0) != 0) {
				AIVector3D texture = mesh.mTextureCoords(0).get(i);
				meshTextureCoord.setX(texture.x());
				meshTextureCoord.setY(texture.y());
			}
			
			vertexList[i] = new Vertex(meshVertex, meshNormal, meshTextureCoord);
		}
		
		int faceCount = mesh.mNumFaces();
		AIFace.Buffer indices = mesh.mFaces();
		int[] indicesList = new int[faceCount * 3];
		
		for (int i = 0; i < faceCount; i++) {
			AIFace face = indices.get(i);
			indicesList[i * 3 + 0] = face.mIndices().get(0);
			indicesList[i * 3 + 1] = face.mIndices().get(1);
			indicesList[i * 3 + 2] = face.mIndices().get(2);
		}
		
		return new Mesh(vertexList, indicesList, new Material(texturePath));
	}
}