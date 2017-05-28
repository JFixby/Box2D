
package org.box2d.r3.gdx;

import org.box2d.jfixby.api.PolygonShape;

import com.badlogic.gdx.math.Vector2;
import com.jfixby.scarabei.api.collections.Collection;
import com.jfixby.scarabei.api.floatn.Float2;
import com.jfixby.scarabei.api.geometry.ClosedPolygonalChain;
import com.jfixby.scarabei.api.geometry.Geometry;

public class GdxPolygonShape extends GdxShape implements PolygonShape {

	private com.badlogic.gdx.physics.box2d.PolygonShape gdx_shape;
	final ClosedPolygonalChain chain;

	public GdxPolygonShape () {
		this.gdx_shape = new com.badlogic.gdx.physics.box2d.PolygonShape();
		chain = Geometry.newClosedPolygonalChain();
	}

	public GdxPolygonShape (com.badlogic.gdx.physics.box2d.PolygonShape gdx_shape2) {
		this.gdx_shape = gdx_shape2;
		chain = Geometry.newClosedPolygonalChain();
	}

	@Override
	public void setAsBox (double half_width, double half_height) {
		gdx_shape.setAsBox((float)half_width, (float)half_height);
	}

	Vector2[] tmp = null;

	private Vector2[] wrap (Collection<Float2> vertices) {
		int N = vertices.size();

		if (tmp == null) {
			tmp = new Vector2[N];
		}
		if (tmp.length != N) {
			tmp = new Vector2[N];
		}
		for (int i = 0; i < N; i++) {
			tmp[i] = new Vector2();
			tmp[i].x = (float)vertices.getElementAt(i).getX();
			tmp[i].y = (float)vertices.getElementAt(i).getY();
			// = ((GdxPoint2D) vertices.getElementAt(i)).getGdxPoint();
		}
		return tmp;
	}

	@Override
	public com.badlogic.gdx.physics.box2d.PolygonShape getGdxShape () {
		return gdx_shape;
	}

	@Override
	public void update (com.badlogic.gdx.physics.box2d.Shape gdx_shape) {
		this.gdx_shape = (com.badlogic.gdx.physics.box2d.PolygonShape)gdx_shape;
	}

	final Vector2 tmpV = new Vector2();

	@Override
	public ClosedPolygonalChain getClosedPolygonalChain () {

		final int N = this.gdx_shape.getVertexCount();
		chain.setSize(N);
		for (int i = 0; i < N; i++) {
			this.gdx_shape.getVertex(i, tmpV);
			chain.getVertex(i).relative().setXY(tmpV.x, tmpV.y);
		}

		return chain;
	}

	@Override
	public void setVertices (Collection<Float2> vertices) {
		gdx_shape.set(this.wrap(vertices));
	}
}
