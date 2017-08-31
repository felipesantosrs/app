package builder;

import java.time.LocalDate;
import java.time.Month;

import data.Energy;
import domains.Decision;
import domains.EnergyType;
import domains.MeterReadType;

/**
 * Energy Builder - Design builder of Energy entity
 * @author Felipe
 *
 */
public class EnergyBuilder {
	private final Energy energy;

	private EnergyBuilder() {
		this.energy = new Energy();
	}

	public static EnergyBuilder energy() {
		return new EnergyBuilder();
	}

	public EnergyBuilder withCustId(final Long custId) {
		this.energy.setCustId(custId);
		return this;
	}

	public EnergyBuilder withEnergyType(final EnergyType energyType) {
		this.energy.setEnergyType(energyType);
		return this;
	}

	public EnergyBuilder withDisconnectDoc(final Decision disconnectDoc) {
		this.energy.setDisconnectDoc(disconnectDoc);
		return this;
	}

	public EnergyBuilder withMoveIn(final LocalDate moveIn) {
		this.energy.setMoveIn(moveIn);
		return this;
	}


	public EnergyBuilder withMoveOut(final LocalDate moveOut) {
		this.energy.setMoveOut(moveOut);
		return this;
	}
	

	public EnergyBuilder withBillYear(final String billYear) {
		this.energy.setBillYear(billYear);
		return this;
	}
	
	

	public EnergyBuilder withBillMonth(final Month billMonth) {
		this.energy.setBillMonth(billMonth);
		return this;
	}
	

	public EnergyBuilder withSpanDays(final Integer spanDays) {
		this.energy.setSpanDays(spanDays);
		return this;
	}
	
	
	public EnergyBuilder withMeterReadDate(final LocalDate meterReadDate) {
		this.energy.setMeterReadDate(meterReadDate);
		return this;
	}
	
	
	public EnergyBuilder withMeterReadType(final MeterReadType meterReadType) {
		this.energy.setMeterReadType(meterReadType);
		return this;
	}
	
	public EnergyBuilder withConsumption(final Double consumption) {
		this.energy.setConsumption(consumption);
		return this;
	}
	
	public EnergyBuilder withExceptionCode(final Long exceptionCode) {
		this.energy.setExceptionCode(exceptionCode);
		return this;
	}
	
	
	public Energy build() {
		return this.energy;
	}
}