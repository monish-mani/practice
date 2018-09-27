package junk;

public class ReplayRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		modifyRequestIdForReplay();
	}
	
	
	private static void modifyRequestIdForReplay(){
		StringBuilder serviceRequest = new StringBuilder("\"{\"requestId\":\"dca773781640a93c2ba59b55ffffe6c6\",\"primaryUserType\":\"SELLER\",\"seller\"");
		final String REQUEST_ID = "requestId";
		final String REPLAY = "replay_";
		int i=0;
		int j=0;
		
		while(i < serviceRequest.length() && j < REQUEST_ID.length()){
			if(serviceRequest.charAt(i) != REQUEST_ID.charAt(j)){
				j=0;
			}else {
				j++;
			}
			i++;
		}
		if(j == REQUEST_ID.length() && i < serviceRequest.length()){
			i = i + 3;
			serviceRequest.insert(i,REPLAY);
		}else{
			//CALLogUtil.logCalEvent("Not able to append replay to requestId during replay request",null, "0");
		}
		
		System.out.println(serviceRequest.toString());
	}

}
