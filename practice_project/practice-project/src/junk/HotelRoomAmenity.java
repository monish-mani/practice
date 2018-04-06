package junk;

public class HotelRoomAmenity {
	
	public enum HotelRoomAmenityType {
		BREAKFAST, INTERNET, KITCHEN, FRIDGE, MICROWAVE, WHIRLPOOL,PARKING
	}
	
	private String code;
	private String name;
	private HotelRoomAmenityType type;
	private boolean isFree;
		
	public HotelRoomAmenity(String code, String name, HotelRoomAmenityType type, boolean isFree) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.isFree = isFree;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public HotelRoomAmenityType getType() {
		return type;
	}

	public void setType(HotelRoomAmenityType type) {
		this.type = type;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append("HotelRoomAmenity [code=");
	    builder.append(code);
	    builder.append(", name=");
	    builder.append(name);
	    builder.append(", type=");
	    builder.append(type);
	    builder.append(", isFree=");
	    builder.append(isFree);
	    builder.append("]");
	    return builder.toString();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelRoomAmenity other = (HotelRoomAmenity) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
    

	
	
	


}
