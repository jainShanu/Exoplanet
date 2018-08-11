package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	
	public static List<String> read(String fileName) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
		String line = null;
		List<String> queriesList = new ArrayList<String>();
		while((line = bufferedReader.readLine())!= null){
			String data[] = line.split(",");
			queriesList.add(data[1] + " " + data[2]);
		}
		bufferedReader.close();
		return queriesList;
	}
	
}
