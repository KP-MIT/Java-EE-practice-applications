package fit5042tutex;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MortgageCalculatorBean
 */
@Stateless
@LocalBean
public class MortgageCalculatorBean {
	
	private String principle="0.0";
    private String interest="0.0";
    private String year="0";
	public String getPrinciple() {
		return principle;
	}
	public void setPrinciple(String principle) {
		this.principle = principle;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
    
    
	
    
}
