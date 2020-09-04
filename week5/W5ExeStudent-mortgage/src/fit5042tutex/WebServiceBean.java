package fit5042tutex;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fit5042tutex.client.WebServiceClient;


@Named(value = "webServiceBean")
@SessionScoped
public class WebServiceBean implements Serializable {
	
	private String principle;
	private String interest;
	private String year;
	private WebServiceClient webServiceClient;
	

	public WebServiceBean() {
		
	}
	
	
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

	
	public void setWebServiceClient() {
		webServiceClient = new WebServiceClient();
		webServiceClient.setPostData(getPrinciple(),getInterest(),getYear());
	}
}