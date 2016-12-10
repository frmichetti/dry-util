package br.com.codecode.dryutil.factory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class HTTP {

	private static final String USER_AGENT = "Mozilla/5.0";

	private static final String ACCEPT_LANGUAGE = "UTF-8";
	
	private HTTP(){
		//STUB
	}


	/**
	 * // optional default is GET
	 * Set the method for the URL request, one of: 
	 * 
	 *GET 
	 *POST 
	 *HEAD 
	 *OPTIONS 
	 *PUT 
	 *DELETE 
	 *TRACE
	 *
	 *@param url
	 *@param method
	 *@param timeout
	 *
	 *@exception RuntimeException, IllegalArgumentException
	 */
	public static String doSend(URL url, String method, int timeout) {

		if(url==null || method.equals("")|| (timeout < 0)){
			throw new IllegalArgumentException("Missing or Incorrect Parameters !!!");
		}

		HttpURLConnection con;

		StringBuffer response;

		try {

			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod(method);

			con.setRequestProperty("User-Agent", USER_AGENT);

			con.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);

			con.setConnectTimeout(timeout);		

			int responseCode = con.getResponseCode();

			System.out.println("\nSending "+ method + " request to URL : " + url + "Timeout is set up to "+ timeout + " mili/s");

			System.out.println("Response Code : " + responseCode);			

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String inputLine;

				response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {

					response.append(inputLine);
				}
			}

		} catch (IOException e) {

			throw new RuntimeException("Could not create a connection ", e);
		}

		return response.toString();
	}

	/**
	 * // optional default is GET
	 * Set the method for the URL request, one of: 
	 * 
	 *GET 
	 *POST 
	 *HEAD 
	 *OPTIONS 
	 *PUT 
	 *DELETE 
	 *TRACE
	 *
	 *@param url
	 *@param method
	 *@param timeout
	 *@param parameter
	 *
	 *@exception RuntimeException, IllegalArgumentException
	 */
	public static String doSend(URL url, String parameter,String method, int timeout){

		if(url==null || parameter.equals("") || method.equals("")|| (timeout < 0)){
			throw new IllegalArgumentException("Missing or Incorrect Parameters !!!");
		}

		HttpURLConnection con;

		StringBuffer response = null;

		try {

			con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod(method);

			con.setRequestProperty("User-Agent", USER_AGENT);

			con.setRequestProperty("Accept-Language", ACCEPT_LANGUAGE);

			con.setRequestProperty("Content-Type", "application/json");

			con.setDoOutput(true);

			try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {

				wr.writeBytes(parameter);

				wr.flush();
			}

			int responseCode = con.getResponseCode();

			System.out.println("\nSending "+ method + " request to URL : " + url + "Timeout is set up to "+ timeout + " mili/s");

			System.out.println("With parameter : " + parameter);

			System.out.println("Response Code : " + responseCode);


			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {

				String inputLine;

				response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {

					response.append(inputLine);
				}
			}
		} catch (IOException e) {

			throw new RuntimeException("Could not create a connection ", e);
		}		

		return response.toString();

	}


	@Deprecated
	public static String sendGet(URL url) throws IOException {

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		con.setRequestProperty("Accept-Language", "UTF-8");        


		int responseCode = con.getResponseCode();

		System.out.println("\nSending 'GET' request to URL : " + url);

		System.out.println("Response Code : " + responseCode);


		StringBuffer response;

		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		}

		return response.toString();

	}

	@Deprecated
	public static String sendPost(URL url, String urlParameters) throws IOException {

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		//add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "UTF-8");
		con.setRequestProperty("Content-Type", "application/json");

		// Send post request
		con.setDoOutput(true);

		try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
			wr.writeBytes(urlParameters);
			wr.flush();
		}

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		StringBuffer response;
		try (BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()))) {
			String inputLine;
			response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
		}

		return response.toString();

	}

}
