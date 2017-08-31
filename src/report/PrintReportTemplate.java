package report;

public abstract class PrintReportTemplate {

	abstract void printFirst();
	abstract void printTwo() ;
	abstract void printThree();
	abstract StringBuilder printFour();
	
	public StringBuilder printReport(){
		printFirst();
		printTwo();
		printThree();
		return printFour();
	}
}

