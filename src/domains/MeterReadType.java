package domains;

import java.util.Arrays;

public enum MeterReadType {
	A("A"), E("E");

	private String readType;

	private MeterReadType(String readType) {
		this.readType = readType;
	}

	public String readType() {
		return readType;
	}
	
	public static MeterReadType findByType(final String type){
		 return  Arrays.stream(MeterReadType.values())
			        .filter(e -> e.name().equals(type))
			        .findAny().orElse(null);
	}

}
