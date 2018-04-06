package junk;

import java.io.Serializable;

public class IntegratedAmenityDetail implements Serializable,Comparable<IntegratedAmenityDetail> {
	
	
	private String code;
	private String name;
	private HotelAmenityType type;
	private boolean free;
	private boolean displayable;
	private boolean filterable;
	private String amenityTypeStr;

	public enum HotelAmenityType {
		INTERNET(10), BREAKFAST(9), POOL(8), PARKING(9), PET(8), FITNESS(7), SHUTTLE(6), BUSINESS(5), SPA(4), CASINO(3), RESTAURANT(2), SMOKING(1), HANDICAP(0), UNKNOWN(
				-1);

		private int rank;

		HotelAmenityType(int rank) {
			this.rank = rank;
		}

		public int getRank() {
			return this.rank;
		}
	}

	public IntegratedAmenityDetail(String code, String name, HotelAmenityType type) {
		this.code = code;
		this.name = name;
		this.type = type;
	}


	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public HotelAmenityType getType() {
		return type;
	}

	public boolean isFree() {
		return free;
	}

	public boolean isDisplayable() {
		return displayable;
	}

	public boolean isFilterable() {
		return filterable;
	}

	public void setFree(Boolean free) {
		this.free = free;
	}

	public void setDisplayable(Boolean displayable) {
		this.displayable = displayable;
	}

	public void setFilterable(Boolean filterable) {
		this.filterable = filterable;
	}

	public String getAmenityTypeStr() {
		return amenityTypeStr;
	}

	public void setAmenityTypeStr(String amenityTypeStr) {
		this.amenityTypeStr = amenityTypeStr;
	}

	@Override
	public int compareTo(IntegratedAmenityDetail o) {
		if (this.isDisplayable() && !o.isDisplayable()) {
			return -1;
		} else if (!this.isDisplayable() && o.isDisplayable()) {
			return 1;
		}

		if (this.isFree() && !o.isFree()) {
			return -1;
		} else if (!this.isFree() && o.isFree()) {
			return 1;
		}

		if (this.getType().getRank() > o.getType().getRank()) {
			return -1;
		} else if (this.getType().getRank() < o.getType().getRank()) {
			return 1;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntegratedAmenityDetail other = (IntegratedAmenityDetail) obj;
		if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

}
