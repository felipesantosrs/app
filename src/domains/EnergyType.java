package domains;

import java.util.Arrays;

public enum EnergyType {
	ELETRICAL(1), GAS(2), BOTH(3);

	private Integer energyType;
	

	private EnergyType(Integer energyType) {
		this.energyType = energyType;
	}

	public Integer energyType() {
		return energyType;
	}

	  public static EnergyType fromInt(int i) {
				 return  Arrays.stream(EnergyType.values())
					        .filter(e -> e.energyType.equals(i))
					        .findAny()
					        .orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", i)));
			}

}
