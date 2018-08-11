 package runner;

import http_requests.Api_Arcsecond;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import org.json.JSONException;
import reader.CSVReader;
import utils.Exoplanet;
import utils.JSONParser;
import sort.SortbyMass;
import sort.SortbyOrbitalPeriod;
import sort.SortbyRadius;

public class MainClass {

	public static void main(String[] args) throws IOException, JSONException{
		
		new CSVReader();
		System.out.println("input file name");
		Scanner scan = new Scanner(System.in);
		List<String> queriesList = null;
		try {
			queriesList = CSVReader.read(scan.nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Exoplanet> exoplanetList = new ArrayList<Exoplanet>();
		scan.close();
		for(int i = 0; i < queriesList.size(); i++){
			Api_Arcsecond api = new Api_Arcsecond();
			String jsonString = null;
			try {
				jsonString = api.execute(queriesList.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONParser parser = new JSONParser(); 
			Exoplanet exoplanet;
			try {
				exoplanet = parser.jsonParse(jsonString);
				exoplanetList.add(exoplanet);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// System.out.println(exoplanet.getMass()+" "+exoplanet.getOrbital_period()+" "+exoplanet.getRadius());
		}
		//Sort the radius, mass, orbitalPeriod, discovery_method
		Collections.sort(exoplanetList, new SortbyRadius());
		//print top 10 planet by radius
		for(int i=0;i<10;i++)
			System.out.println(exoplanetList.get(i).getPlanet());
		//print top 10 planets by mass
		Collections.sort(exoplanetList, new SortbyMass());
		for(int i=0;i<10;i++)
			System.out.println(exoplanetList.get(i).getPlanet());
		
		Collections.sort(exoplanetList, new SortbyOrbitalPeriod());
		for(int i=0;i<10;i++)
			System.out.println(exoplanetList.get(i).getPlanet());
		
//		print all the detection method of planets
		Map<String,Integer> detection_map = new TreeMap<String, Integer>();
		
		for(Exoplanet tempObj :exoplanetList ) {
			String temp = tempObj.getDetection_method();
			Integer count = detection_map.get(temp);
			detection_map.put(temp, (count==null)?1: count+1);
		}
		for(Map.Entry<String,Integer> entry:detection_map.entrySet())
		{
			System.out.println(entry.getKey()+ " : "+ entry.getValue());
		}				
	}	
}
