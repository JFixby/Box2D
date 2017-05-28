
package org.box2d.r3.gdx;

import org.box2d.jfixby.api.BodyDef;
import org.box2d.jfixby.api.Box2DComponent;
import org.box2d.jfixby.api.Box2DWorld;
import org.box2d.jfixby.api.Box2DWorldSpecs;
import org.box2d.jfixby.api.CircleShape;
import org.box2d.jfixby.api.FixtureDef;
import org.box2d.jfixby.api.PolygonShape;

public class GDXBox2D implements Box2DComponent {

	public GDXBox2D () {
	}

	@Override
	public Box2DWorld newBox2DWorld (final Box2DWorldSpecs specs) {
		return new GdxWorld(specs);

	}

	@Override
	public Box2DWorldSpecs newBox2DWorldSpecs () {
		return new GdxWorldSpecs();
	}

	@Override
	public FixtureDef newFixtureDef () {
		return new GdxFixtureDef();
	}

	@Override
	public BodyDef newBodyDef () {
		return new GdxBodyDef();
	}

	@Override
	public PolygonShape newPolygonShape () {
		return new GdxPolygonShape();
	}

	@Override
	public CircleShape newCircleShape () {
		return new GdxCircleShape();
	}

}
