package utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class URLBuilder {
	
	public static URL getURL(String query) throws MalformedURLException, UnsupportedEncodingException{
		
		return new URL(API_DETAILS.BASE_URL+URLEncoder.encode(query,"UTF-8")+API_DETAILS.FORMAT);
		
	}

}
