package utils;

public class Exoplanet {

	
	int radius;
	int mass;
	int orbital_period;
	String Detection_method;
	String planet_name;

	public int getRadius() {
		return radius;
	}
	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	public int getMass() {
		return mass;
	}
	public void setMass(Integer mass) {
		this.mass = mass;
	}
	public int getOrbital_period() {
		return orbital_period;
	}
	public void setOrbital_period(int orbital_period) {
		this.orbital_period = orbital_period;
	}
	public void setDetection_method(String discovery){
		this.Detection_method = discovery;
	}
	public String getDetection_method(){
		return Detection_method;
	}
	public void setPlanet_name(String Planet)
	{
		this.planet_name= Planet; 
	}
	public String getPlanet() {
		return planet_name;
	}
}
