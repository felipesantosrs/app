package domains;

import java.util.Arrays;

import infra.ExecuteAppException;

public enum ReportType {

	CSV_ENERGY("csv");

	private String report;

	ReportType(String report) {
		this.report = report;
	}

	public String report() {
		return report;
	}
	
	public static ReportType findByName(final String report) throws ExecuteAppException{
		 return  Arrays.stream(ReportType.values())
			        .filter(e -> e.report.contains(report))
			        .findAny()
			        .orElseThrow(() -> new ExecuteAppException(String.format("Unsupported type %s.", report)));
	}

}
