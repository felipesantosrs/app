package report;

import java.time.LocalDateTime;

import java.time.Month;
import java.util.Map;

import domains.EnergyType;

/**
 * PrintEnergyReport is responsable to write the report inside the file
 * @author Felipe
 *
 */
public class PrintEnergyReport extends PrintReportTemplate {
	private static final String BREAK = "\n";

	private LogicEnergyReport out;
	private StringBuilder br;
	private String fileName;

	public PrintEnergyReport(LogicEnergyReport out, String fileName) {
		this.out = out;
		this.fileName = fileName;
	}

	public LogicEnergyReport getOut() {
		return out;
	}

	public void setOut(LogicEnergyReport out) {
		this.out = out;
	}

	public void printFirst() {
		br = new StringBuilder();
		br.append("File name processed "+ fileName + BREAK);
		br.append("File created on " + LocalDateTime.now() + BREAK);
		br.append("### 1: Number of unique customers" + BREAK);
		br.append(out.custumersCount());
	}

	public void printTwo() {
		br.append(
				BREAK + "### 2: Breakdown of the number of customers that have electricity only, gas only, and both electricity and gas"
						+ BREAK);
		out.customersEnergyType().forEach(c -> {
			c.entrySet().forEach(d -> {
				br.append(d.getKey() + " : " + d.getValue() + BREAK);
			});
		});

	}

	public void printThree() {
		br.append(BREAK + "### 3: Breakdown of the number of customers that have electricity only, gas only, and both electricity and gas"+ BREAK);
		Map<EnergyType, Map<Long, Long>> result = out.energyTypeToCustomerRows();
		result.entrySet().forEach(c -> {
			br.append(BREAK + BREAK + "**** " + c.getKey() + ": " + BREAK);
			c.getValue().entrySet().forEach(d -> {
				br.append(d.getKey() + ": " + d.getValue() + BREAK);
			});
		});

	}

	public StringBuilder printFour() {
		br.append(BREAK + "### 4: Average consumption per Bill Month per resource" + BREAK);
		Map<EnergyType, Map<Month, String>> result = out.energyTypeToMonthToAverageCompensation();
		result.entrySet().forEach(c -> {
			br.append(BREAK + BREAK + "**** " + c.getKey() + ": " + BREAK);
			c.getValue().entrySet().forEach(d -> {
				br.append(d.getKey() + ": " + d.getValue() + BREAK);
			});
		});
		return br;
	}

	
	
	
	public StringBuilder getBr() {
		return br;
	}

	public void setBr(StringBuilder br) {
		this.br = br;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
