package models;

import java.util.ArrayList;
import java.util.List;

public class Currency {
	List <String> currency = new ArrayList<>();
	

	public Currency() {
		super();
		currency.add("USD");
		currency.add("GBP");
		currency.add("EUR");
	}

	public List<String> getCurrency() {
		return currency;
	}

	public void setCurrency(List<String> currency) {
		this.currency = currency;
	}
	
	public Double Converter(String from, String to,String value)
	{
		Double result = null;
		if(from.equals("USD") )
		{
			if(to.equals("EUR"))
				result =  Double.valueOf(value)*0.84;
			if(to.equals("GBP"))
				result =  Double.valueOf(value)*0.72;
		}
		if(from.equals("EUR") )
		{
			if(to.equals("USD"))
				result =  Double.valueOf(value)*1.19;
			if(to.equals("GBP"))
				result =  Double.valueOf(value)*0.86;
		}
		if(from.equals("GBP") )
		{
			if(to.equals("USD"))
				result =  Double.valueOf(value)*1.38;
			if(to.equals("EUR"))
				result =  Double.valueOf(value)*1.17;
		}
		return result;
	}
	

}
