package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.JsonPathException;

import net.minidev.json.JSONArray;

public class Debug {
	
	static boolean isJsonArray(Object queriedDescription) {
		try {
			new net.minidev.json.JSONArray();
		} catch (JsonPathException ex1) {
			return false;
		}
		return true;
	}
	
	public static void main(String args[]) throws IOException{
		
		URL url = new URL("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		} else {
			System.out.println("API Resonse Code: 200");
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String a = null;
		String output;
		System.out.println("API response body is: ");
		while ((output = br.readLine()) != null) {
			//System.out.println(output);
			a = output;
		}
		System.out.println(a);
		
//		Object queriedName = JsonPath.read(a, "$.Name");
//		System.out.println("Name data is : " + queriedName.toString());
//		
//		
		Object queriedDescription = JsonPath.read(a, "$.Promotions[?(@.Name=='Basic')].Description");
		
		Boolean flag = isJsonArray(queriedDescription);
		System.out.println(flag);
		Object queriedDescription1 = JsonPath.read(a, "$.Promotions[?(@.Name=='Basic')].Description");
		
		ArrayList<String> list = new ArrayList<String>();     
		JSONArray jsonArray = (JSONArray)queriedDescription1; 
		if (jsonArray != null) { 
		   int len = jsonArray.size();
		   for (int i=0;i<len;i++){ 
		    list.add(jsonArray.get(i).toString());
		   } 
		} 
		System.out.println(list.get(0).toString());


}}
