#version 330 core

layout(location = 0) in vec3 position;

out vec3 color;

void main() {
	gl_Position = vec4(position, 1.0);
	color = vec3(position.x, position.y - position.x, position.y);
}