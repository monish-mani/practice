package junk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URLConnection;

import org.json.JSONObject;


//https://jsonplaceholder.typicode.com/posts
public class jsonProcessing {

	public static void main(String[] args) throws IOException {
		jsonProcessing jsp = new jsonProcessing();
		jsp.extractWebTierUrl(null);
	}
	
	
	
	private String extractWebTierUrl(JSONObject calActivity){
		String clientInfoData = "RemoteIP=10.156.158.164&Server=www.lstsynlvs.stratus.ebay.com&ContentLength=5306&Script=/lstsynlvs&Agent=Java/1.6.0";
		String webTierUrl = null;
		
		Pattern pattern = Pattern.compile("Server=[a-zA-Z0-9].*.com");
		Matcher matcher = pattern.matcher(clientInfoData);
		
		if(matcher.find()) {
			System.out.println(matcher.group(0).split("=")[1]);
		}
		
		return null;
	}
	
	
	

	public static JSONObject readJsonFromUrl(String url) throws IOException {

		InputStream is = null;
		try {
			// is = new URL(url).openStream();
			URL urll = new URL(url);
			URLConnection con = urll.openConnection();
			con.setConnectTimeout(100000);
			con.setReadTimeout(100000);
			is = con.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

			String jsonText = readAll(rd);
			return new JSONObject(jsonText);
		} catch (Exception e) {
			System.out.println("Exception while getting the data from URL: " + url);
			e.printStackTrace();
		} finally {
			if (is != null)
				is.close();
		}

		return null;
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	public static String readJsonFromUrl2() {

	      try {
	         URL url = new URL( "http://appmon.vip.ebay.com/logview/rlogid/t6ovrtzkjqp%3F%3Ctofjtwv%7Fiosu*2%3C0%3F%3A76%29pqtfwpu%29pie%29fgg~-fij-16480b04267-0x19e/eventDetail" );
	         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	         conn.setRequestMethod( "GET" );
	         conn.setRequestProperty( "Accept", "application/json" );

	         conn.connect();

	         BufferedReader br = new BufferedReader( new InputStreamReader(
	                 conn.getInputStream(), "UTF-8" ) );

	         StringBuilder sb = new StringBuilder( 2048 );
	         for( String line; (line = br.readLine()) != null; ) {
	            sb.append( line );
	         }
	         conn.disconnect();

	         return sb.toString();

	      } catch( IOException ex ) {
	         return ex.toString();
	      }

	   }
	

}
