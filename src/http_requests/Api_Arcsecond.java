package http_requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import utils.URLBuilder;



public class Api_Arcsecond {
	
	URL url;
	
	public String execute(String query) throws IOException{
		
		trustIssues();
		
		url = URLBuilder.getURL(query);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		InputStream inputStream = con.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        //adding line for debugging purpose
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
	}

	void trustIssues(){
		
		TrustManager[] trustAllCerts = new TrustManager[]{
		        new X509TrustManager() {

		            public java.security.cert.X509Certificate[] getAcceptedIssuers()
		            {
		                return null;
		            }
		            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
		            {
		                //No need to implement.
		            }
		            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
		            {
		                //No need to implement.
		            }
		        }
		};

		// Install the all-trusting trust manager
		try 
		{
		    SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} 
		catch (Exception e) 
		{
		    System.out.println(e);
		}
		
	}
	
}
