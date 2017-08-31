package report;

import java.io.BufferedReader;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import data.Energy;
import document.IDocument;
import domains.EnergyType;
import utils.Utils;


/**
 * LogicEnergyReport- class responsable to make the logic calculation 
 * @author Felipe
 *
 */
public class LogicEnergyReport {

	private IDocument<Energy> document;
	private BufferedReader br;
	private List<Energy> rows; 
	
	@SuppressWarnings("unchecked")
	public LogicEnergyReport(final IDocument<?> document, final BufferedReader br) {
		this.document = (IDocument<Energy>) document;
		this.br = br;
	}

	public IDocument<Energy> getDocument() {
		return document;
	}

	public void setDocument(IDocument<Energy> document) {
		this.document = document;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}
	

	public List<Energy> getRows() {
		return rows;
	}

	public void setRows(List<Energy> rows) {  
		this.rows = rows;
	}

	
	private void rows() {
		setRows((List<Energy>) getDocument().reading(getBr()));
	}

	private List<Long> customersIds() {
		return getRows().parallelStream().distinct().map(Energy::getCustId).collect(Collectors.toList());
	}
	
	/**
	 * Count unique customers
	 * @return
	 */
	public Long custumersCount() {
		rows();
		return customersIds().parallelStream().count();
	}
	
	/**
	 * Methods responsible to calculate number of customers that have electricity only, gas only, and both electricity and gas
	 * @return - list of ids with EnergyType  
	 */
	public List<Map<Long, EnergyType>> customersEnergyType() {
		List<Map<Long, EnergyType>> list = new ArrayList<Map<Long, EnergyType>>();
		customersIds().forEach(id -> {
			boolean eletrical = countPredicate(id, EnergyType.ELETRICAL);
			boolean gas = countPredicate(id, EnergyType.GAS);
			Map<Long, EnergyType> custType = new HashMap<Long, EnergyType>();
			if (eletrical && gas) {
				custType.put(id, EnergyType.BOTH);
			} else if (eletrical) {
				custType.put(id, EnergyType.ELETRICAL);
			} else if (gas) {
				custType.put(id, EnergyType.GAS);
			}
			list.add(custType);
		}
	);

		return list;
	}

	private boolean countPredicate(Long id, EnergyType type) {
		return getRows().parallelStream().filter(predicateCustIdAndEnergyType(id, type)).count() > 0;
	}

	private Predicate<? super Energy> predicateCustIdAndEnergyType(Long id, EnergyType type) {
		return c -> c.getCustId().equals(id) && c.getEnergyType().equals(type);
	}
	/**
	 * Methods responsible to calculate the average consumption per Bill Month per resource
	 * @return {@link Map} energy type with {@link Map} of Month and Compensation
	 */
	public Map<EnergyType, Map<Month, String>> energyTypeToMonthToAverageCompensation() {
		return getRows().parallelStream().filter(e -> e.getBillMonth() != null)
				.collect(Collectors.groupingBy(Energy::getEnergyType,
						Collectors.groupingBy(Energy::getBillMonth,
								Collectors.collectingAndThen(Collectors.averagingDouble(Energy::getConsumption),
										average -> Utils.format(average)))));
	}

	
	/**
	 * Methods responsible to calculate the number of customers that have electricity only, gas only, and both electricity and gas
	 * @return {@link Map} energy type with {@link Map} of customer Id and count
	 */
	public Map<EnergyType, Map<Long, Long>> energyTypeToCustomerRows() {
		return getRows().parallelStream().filter(e -> e.getBillMonth() != null)
				.collect(Collectors.groupingBy(Energy::getEnergyType,
						Collectors.groupingBy(Energy::getCustId,(Collectors.counting()))));
	}

}
