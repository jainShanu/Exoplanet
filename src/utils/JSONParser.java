package utils;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {
	
	public Exoplanet jsonParse(String jsonString) throws JSONException{
        //for debugging 
		System.out.println(jsonString);
		
		JSONObject jObject = new JSONObject(jsonString);
		
		JSONObject radiusObject = jObject.getJSONObject("radius");
		String radius = radiusObject.getString("value");
		
		JSONObject massObject = jObject.getJSONObject("mass");
		String mass = massObject.getString("value");
		
		JSONObject orbital_periodObject = jObject.getJSONObject("orbital_period");
		String orbital_period = orbital_periodObject.getString("value");
		
		String detection_method = jObject.getString("detection_method");
		
		String planet_name = jObject.getString("name");
		
		Exoplanet exoplanet = new Exoplanet();
		String radius2 = radius;
		if(radius!= null || !(radius2.isEmpty()) )
			exoplanet.setRadius(float.(radius));
		else 
		{
			exoplanet.setRadius(-1);
		}
		String mass2 = mass;
		if(mass!= null || !(mass2.isEmpty()))
		{
			exoplanet.setMass(Integer.parseInt(mass));
		}
		else
		{
			exoplanet.setMass(-1);
		}
		String orbital_period2 = orbital_period;
		if(orbital_period!= null || !(orbital_period2.isEmpty()) )
		{
			exoplanet.setOrbital_period(Integer.parseInt(orbital_period) );
		}
		else
		{
			exoplanet.setOrbital_period(-1);
		}
		exoplanet.setDetection_method(detection_method);
		exoplanet.setPlanet_name(planet_name);
		return exoplanet;
	}

}
