package document;

import static builder.EnergyBuilder.energy;

import java.util.function.Function;

import data.Energy;
import domains.Decision;
import domains.EnergyType;
import domains.MeterReadType;
import utils.Utils;
/**
 * Class responsable to handle Csv Energy
 * @author Felipe
 *
 */
public class DocumentCSVEnergy extends DocumentCSVTemplate<Energy> implements IDocument<Energy>{

	@Override
	Function<String, Energy> defaultFunction() {
		return (line) -> {
			String[] e = line.split("\\|");
			return energy().withCustId(Long.valueOf(e[0]))
					.withEnergyType(EnergyType.fromInt((Integer.valueOf(e[1]))))
					.withDisconnectDoc(Decision.valueOf(e[2]))
					.withMoveIn(Utils.convertStringtoLocalDate(e[3]))
					.withMoveOut(Utils.convertStringtoLocalDate(e[4]))
					.withBillYear(e[5])
					.withBillMonth(Utils.convertToMonth(e[6]))
					.withSpanDays(Integer.valueOf(e[7]))
					.withMeterReadDate(Utils.convertStringtoLocalDate(e[8]))
					.withMeterReadType(MeterReadType.findByType(e[9]))
					.withConsumption(Utils.convertStringToDouble(e[10]))
					.build();
		};

	}

		
}
