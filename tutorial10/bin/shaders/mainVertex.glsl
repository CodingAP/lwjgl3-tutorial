#version 460 core

in vec3 position;
in vec3 color;
in vec2 textureCoord;

out vec3 passColor;
out vec2 passTextureCoord;

uniform mat4 model;

void main() {
	gl_Position = vec4(position, 1.0) * model;
	passColor = color;
	passTextureCoord = textureCoord;
}