package report;

import java.io.BufferedReader;

import document.IDocument;
import domains.ReportType;

public class ReportOutputFactory {
	
	public PrintReportTemplate getReportOutputFactory(final ReportType type, final IDocument<?> document, final BufferedReader br,final  String fileName ) {
		switch (type) {
		case CSV_ENERGY:
			return new PrintEnergyReport(new LogicEnergyReport(document, br), fileName);
		default:
			return null;
		}
	}

}
