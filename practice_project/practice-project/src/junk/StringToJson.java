package junk;
import org.json.*;

public class StringToJson {
	
	public static void main(String[] args) throws JSONException {
		//Without executionMode
		String response1 = "{\n" + 
				"	\"requestId\": \"bes-ELVIS_ASYNC_RULE_EXEC-7d42a0961650abd8d2661f46fff08602\",\n" + 
				"	\"primaryUserType\": \"SELLER\",\n" + 
				"	\"seller\": {\n" + 
				"		\"userId\": 1123354107\n" + 
				"	},\n" + 
				"	\"client\": \"SYI\",\n" + 
				"	\"siteId\": -1,\n" + 
				"	\"rlogId\": \"t6a%60ubosot2%3F%3Ctofdbp%60jqjv7*15273%3C5%29pqtfwpu%29pie%29fgg%7E-fij-1657d42a3c5-0x62aa\",\n" + 
				"	\"syncElvisEvaluationTimeout\": false,\n" + 
				"	\"browserHeaderInfo\": {\n" + 
				"	},\n" + 
				"	\"environmentInfo\": {\n" + 
				"		\"pageId\": 0,\n" + 
				"		\"commandName\": \"\",\n" + 
				"		\"returnURL\": \"\",\n" + 
				"		\"endUserApplicationId\": 46319,\n" + 
				"		\"applicationId\": 46319,\n" + 
				"		\"cobrandId\": 0,\n" + 
				"		\"machineGroupId\": -1,\n" + 
				"		\"clientIp\": \"136.243.23.133\",\n" + 
				"		\"oldCookieId\": 0,\n" + 
				"		\"successPayPalTransaction\": false,\n" + 
				"		\"siteId\": 77,\n" + 
				"		\"userChannelType\": \"UNKNOWN\",\n" + 
				"		\"deviceOsType\": \"UNKNOWN\"\n" + 
				"	},\n" + 
				"	\"trueIp\": \"136.243.23.133\",\n" + 
				"	\"saleInfo\": {\n" + 
				"		\"saleId\": 232907264902\n" + 
				"	},\n" + 
				"	\"modelScores\": {\n" + 
				"		\"ATO_SYI_MONGOOSE_SCORE\": 2\n" + 
				"	},\n" + 
				"	\"sellerTags\": \"Autor Bryant, Bonnie \",\n" + 
				"	\"disableReportAndActions\": false\n" + 
				"}";
		
		//With executionMode
		String response2 = "{\n" + 
				"	\"requestId\": \"bes-ELVIS_ASYNC_RULE_EXEC-7d42a0961650abd8d2661f46fff08602\",\n" + 
				"	\"primaryUserType\": \"SELLER\",\n" + 
				"	\"seller\": {\n" + 
				"		\"userId\": 1123354107\n" + 
				"	},\n" + 
				"	\"client\": \"SYI\",\n" + 
				"	\"executionMode\": \"Evalutaion\",\n" + 
				"	\"siteId\": -1,\n" + 
				"	\"rlogId\": \"t6a%60ubosot2%3F%3Ctofdbp%60jqjv7*15273%3C5%29pqtfwpu%29pie%29fgg%7E-fij-1657d42a3c5-0x62aa\",\n" + 
				"	\"syncElvisEvaluationTimeout\": false,\n" + 
				"	\"browserHeaderInfo\": {\n" + 
				"	},\n" + 
				"	\"environmentInfo\": {\n" + 
				"		\"pageId\": 0,\n" + 
				"		\"commandName\": \"\",\n" + 
				"		\"returnURL\": \"\",\n" + 
				"		\"endUserApplicationId\": 46319,\n" + 
				"		\"applicationId\": 46319,\n" + 
				"		\"cobrandId\": 0,\n" + 
				"		\"machineGroupId\": -1,\n" + 
				"		\"clientIp\": \"136.243.23.133\",\n" + 
				"		\"oldCookieId\": 0,\n" + 
				"		\"successPayPalTransaction\": false,\n" + 
				"		\"siteId\": 77,\n" + 
				"		\"userChannelType\": \"UNKNOWN\",\n" + 
				"		\"deviceOsType\": \"UNKNOWN\"\n" + 
				"	},\n" + 
				"	\"trueIp\": \"136.243.23.133\",\n" + 
				"	\"saleInfo\": {\n" + 
				"		\"saleId\": 232907264902\n" + 
				"	},\n" + 
				"	\"modelScores\": {\n" + 
				"		\"ATO_SYI_MONGOOSE_SCORE\": 2\n" + 
				"	},\n" + 
				"	\"sellerTags\": \"Autor Bryant, Bonnie \",\n" + 
				"	\"disableReportAndActions\": false\n" + 
				"}";
		
		JSONObject jsonResponse = new JSONObject(response2);
		
		jsonResponse.put("executionMode", "Evalutaion");
		
		
		String modifiedResponse = jsonResponse.toString();
		System.out.println(modifiedResponse);
		
	}

}
