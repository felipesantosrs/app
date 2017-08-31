package data;

import java.time.LocalDate;
import java.time.Month;

import domains.Decision;
import domains.EnergyType;
import domains.MeterReadType;

/**
 * Entity
 * @author Felipe
 *
 */
public class Energy {


	private Long custId;
	private EnergyType energyType;
	private Decision disconnectDoc;
	private LocalDate moveIn;
	private LocalDate moveOut;
	private String billYear;
	private Month billMonth;
	private Integer spanDays;
	private LocalDate meterReadDate;
	private MeterReadType meterReadType;
	private Double consumption;
	private Long exceptionCode;

	
	public Energy() {
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public EnergyType getEnergyType() {
		return energyType;
	}

	public void setEnergyType(EnergyType energyType) {
		this.energyType = energyType;
	}

	public Decision getDisconnectDoc() {
		return disconnectDoc;
	}

	public void setDisconnectDoc(Decision disconnectDoc) {
		this.disconnectDoc = disconnectDoc;
	}

	public LocalDate getMoveIn() {
		return moveIn;
	}

	public void setMoveIn(LocalDate moveIn) {
		this.moveIn = moveIn;
	}

	public LocalDate getMoveOut() {
		return moveOut;
	}

	public void setMoveOut(LocalDate moveOut) {
		this.moveOut = moveOut;
	}

	public String getBillYear() {
		return billYear;
	}

	public void setBillYear(String billYear) {
		this.billYear = billYear;
	}

	public Month getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(Month billMonth) {
		this.billMonth = billMonth;
	}

	public Integer getSpanDays() {
		return spanDays;
	}

	public void setSpanDays(Integer spanDays) {
		this.spanDays = spanDays;
	}

	public LocalDate getMeterReadDate() {
		return meterReadDate;
	}

	public void setMeterReadDate(LocalDate meterReadDate) {
		this.meterReadDate = meterReadDate;
	}

	public MeterReadType getMeterReadType() {
		return meterReadType;
	}

	public void setMeterReadType(MeterReadType meterReadType) {
		this.meterReadType = meterReadType;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	public Long getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(Long exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
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
		Energy other = (Energy) obj;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		return true;
	}

}
