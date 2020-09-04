package fit5042tutex;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("mortgage")
public class MortgageCalculator {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;
    
    @EJB
    private MortgageCalculatorBean mortgageCalculator;
    
    public double calculateMortgage(String principle, String interest, String year) {
    	double P = Double.valueOf(principle);
    	double I = Double.valueOf(interest);
    	int T = Integer.valueOf(year);
    	double mortgage = P * (Math.pow((1 + I), T));
    	return mortgage;
    }
    
    double amount = calculateMortgage(mortgageCalculator.getPrinciple(),mortgageCalculator.getInterest(),mortgageCalculator.getYear());

    @GET
    @Produces("text/html")
    public String getHtml() {
        // TODO return proper representation object
    	String result = "<html><body><h1> Mortgage amount is $" + amount + "!</h1></body></html>";
    	return result;
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    public void setPostData( @FormParam("principle") String principle,@FormParam("interest") String interest,@FormParam("year") String year) {
     mortgageCalculator.setPrinciple(principle);
     mortgageCalculator.setInterest(interest);
     mortgageCalculator.setYear(year);
    }
    
    
    /**
     * PUT method for updating or creating an instance of MortgageCalculator
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }

}