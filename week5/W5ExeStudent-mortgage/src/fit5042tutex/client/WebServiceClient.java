package fit5042tutex.client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class WebServiceClient {
	private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://0.0.0.0:8080/W5ExeStudent-mortgage/webresources";

    public WebServiceClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("mortgage");
    }

    public String getHtml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void setPostName() throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED).post(null);
    }
    
    public void setPostData(String principle, String interest, String year) throws ClientErrorException {
        Form form = new Form();
        form.param("principle", principle);
        form.param("interest", interest);
        form.param("year", year);
        webTarget.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
    }
    
    public void putHtml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML));
    }
    
    public void close() {
        client.close();
    }
}
