
package org.box2d.r3.gdx;

import org.box2d.jfixby.api.Shape;

public abstract class GdxShape implements Shape {

	// public com.badlogic.gdx.physics.box2d.Shape shape;
	//
	abstract public com.badlogic.gdx.physics.box2d.Shape getGdxShape ();

	abstract public void update (com.badlogic.gdx.physics.box2d.Shape gdx_shape);
	// {
	// return shape;
	//
	// }
	//
	// public void update(com.badlogic.gdx.physics.box2d.Shape gdx_shape) {
	// this.shape = gdx_shape;
	// }

}
