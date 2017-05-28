package org.box2d.r3.jbox2d.d;

import org.box2d.jfixby.api.Filter;
import org.box2d.jfixby.api.FixtureDef;
import org.box2d.jfixby.api.Shape;

public class JFixtureDef implements FixtureDef, Filter {
	final org.jbox2d.d.dynamics.FixtureDef gdx_fixture;

	public JFixtureDef() {
		this.gdx_fixture = new org.jbox2d.d.dynamics.FixtureDef();
	}

	@Override
	public void setDensity(double density) {
		this.gdx_fixture.density =  density;
	}

	@Override
	public void setRestitution(double restitution) {
		this.gdx_fixture.restitution =  restitution;
	}

	@Override
	public void setFriction(double friction) {
		this.gdx_fixture.friction =  friction;
	}

	@Override
	public void setIsSensor(boolean is_sensor) {
		this.gdx_fixture.isSensor = is_sensor;
	}

	@Override
	public Filter filter() {
		return this;
	}

	@Override
	public void setShape(Shape boxPoly) {
		this.gdx_fixture.shape = ((JShape) boxPoly).getGdxShape();
	}

	@Override
	public void setCategoryBits(short categoryBits) {
		this.gdx_fixture.filter.categoryBits = categoryBits;
	}

	@Override
	public void setMaskBits(short maskBits) {
		this.gdx_fixture.filter.maskBits = maskBits;
	}

	public org.jbox2d.d.dynamics.FixtureDef getGdxFixture() {
		return this.gdx_fixture;
	}

	@Override
	public double getDensity() {
		return this.gdx_fixture.density;
	}

}
