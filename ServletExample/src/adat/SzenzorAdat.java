package adat;

import java.util.Date;

public class SzenzorAdat {		// t, h, spl, datum
	
	private double temp;		// t: homerseklet
	private double humidity;	// h: paratartalom
	private double spl;			// decibel
	private Date datum;
	
	public SzenzorAdat(double t, double h, double spl, Date datum) {
		
		super();
		this.temp = t;
		this.humidity = h;
		this.spl = spl;
		this.datum = datum;
	}

	@Override
	public String toString() {
		
		return temp + ";" + humidity + ";" + spl + ";" + datum;
	}
	
	
}
