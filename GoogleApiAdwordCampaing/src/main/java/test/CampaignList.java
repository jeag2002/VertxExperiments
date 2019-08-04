package test;


import static com.google.api.ads.common.lib.utils.Builder.DEFAULT_CONFIGURATION_FILENAME;

import com.google.api.ads.adwords.axis.factory.AdWordsServices;
import com.google.api.ads.adwords.axis.utils.v201809.SelectorBuilder;
import com.google.api.ads.adwords.axis.v201809.cm.ApiError;
import com.google.api.ads.adwords.axis.v201809.cm.ApiException;
import com.google.api.ads.adwords.axis.v201809.cm.Campaign;
import com.google.api.ads.adwords.axis.v201809.cm.CampaignPage;
import com.google.api.ads.adwords.axis.v201809.cm.CampaignServiceInterface;
import com.google.api.ads.adwords.axis.v201809.cm.Selector;
import com.google.api.ads.adwords.axis.v201809.mcm.Customer;
import com.google.api.ads.adwords.axis.v201809.mcm.CustomerServiceInterface;
import com.google.api.ads.adwords.lib.client.AdWordsSession;
import com.google.api.ads.adwords.lib.factory.AdWordsServicesInterface;
import com.google.api.ads.adwords.lib.selectorfields.v201809.cm.CampaignField;
import com.google.api.ads.common.lib.auth.OfflineCredentials;
import com.google.api.ads.common.lib.auth.OfflineCredentials.Api;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.OAuthException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import java.rmi.RemoteException;

/*
public class CampaignList{
	 private static final int PAGE_SIZE = 100;

	  public static void main(String[] args) {
	    AdWordsSession session;
	    try {
	      // Generate a refreshable OAuth2 credential.
	      Credential oAuth2Credential =
	          new OfflineCredentials.Builder()
	              .forApi(Api.ADWORDS)
	              .fromFile()
	              .build()
	              .generateCredential();

	      // Construct an AdWordsSession.
	      session =
	          new AdWordsSession.Builder().fromFile().withOAuth2Credential(oAuth2Credential).build();
	    } catch (ConfigurationLoadException cle) {
	      System.err.printf(
	          "Failed to load configuration from the %s file. Exception: %s%n",
	          DEFAULT_CONFIGURATION_FILENAME, cle);
	      return;
	    } catch (ValidationException ve) {
	      System.err.printf(
	          "Invalid configuration in the %s file. Exception: %s%n",
	          DEFAULT_CONFIGURATION_FILENAME, ve);
	      return;
	    } catch (OAuthException oe) {
	      System.err.printf(
	          "Failed to create OAuth credentials. Check OAuth settings in the %s file. "
	              + "Exception: %s%n",
	          DEFAULT_CONFIGURATION_FILENAME, oe);
	      return;
	    }

	    AdWordsServicesInterface adWordsServices = AdWordsServices.getInstance();

	    try {
	      runExample(adWordsServices, session);
	    } catch (ApiException apiException) {
	      // ApiException is the base class for most exceptions thrown by an API request. Instances
	      // of this exception have a message and a collection of ApiErrors that indicate the
	      // type and underlying cause of the exception. Every exception object in the adwords.axis
	      // packages will return a meaningful value from toString
	      //
	      // ApiException extends RemoteException, so this catch block must appear before the
	      // catch block for RemoteException.
	      System.err.println("Request failed due to ApiException. Underlying ApiErrors:");
	      if (apiException.getErrors() != null) {
	        int i = 0;
	        for (ApiError apiError : apiException.getErrors()) {
	          System.err.printf("  Error %d: %s%n", i++, apiError);
	        }
	      }
	    } catch (RemoteException re) {
	      System.err.printf(
	          "Request failed unexpectedly due to RemoteException: %s%n", re);
	    }
	  }

	  
	  // * Runs the example.
	  // *
	  // * @param adWordsServices the services factory.
	  // * @param session the session.
	  // * @throws ApiException if the API request failed with one or more service errors.
	  // * @throws RemoteException if the API request failed due to other errors.
	   
	  public static void runExample(
	      AdWordsServicesInterface adWordsServices, AdWordsSession session) throws RemoteException {
	    // Get the CampaignService.
	    CampaignServiceInterface campaignService =
	        adWordsServices.get(session, CampaignServiceInterface.class);
	    
	    CustomerServiceInterface customerService =
	    		adWordsServices.get(session, CustomerServiceInterface.class);
	    

	    int offset = 0;

	    // Create selector.
	    SelectorBuilder builder = new SelectorBuilder();
	    Selector selector = builder
	        .fields(CampaignField.Id, CampaignField.Name)
	        .orderAscBy(CampaignField.Name)
	        .offset(offset)
	        .limit(PAGE_SIZE)
	        .build();
	    
	    
	    
	    Customer[] data = customerService.getCustomers();
	    
	    if (data != null) {
	    	for(int i=0; i<data.length; i++) {
	    		System.out.println("Customer ["+i+"] (" + data[i].getCustomerId()+ ") (" + data[i].getDescriptiveName() + ")");
	    	}
	    }
	    

	    CampaignPage page;
	    do {
	      // Get all campaigns.
	      page = campaignService.get(selector);

	      // Display campaigns.
	      if (page.getEntries() != null) {
	        for (Campaign campaign : page.getEntries()) {
	          System.out.printf("Campaign with name '%s' and ID %d was found.%n", campaign.getName(),
	              campaign.getId());
	        }
	      } else {
	        System.out.println("No campaigns were found.");
	      }

	      offset += PAGE_SIZE;
	      selector = builder.increaseOffsetBy(PAGE_SIZE).build();
	    } while (offset < page.getTotalNumEntries());
	  }	
}
*/




public class CampaignList{

public static void main(String[] args) throws Exception {

   // Create an AdWordsSession instance, loading credentials from the
   // properties file:

  // Get an OAuth2 credential.
	/*
  Credential credential = new OfflineCredentials.Builder()
      .forApi(OfflineCredentials.Api.ADWORDS)
      .fromFile()
      .build()
      .generateCredential();

  // Construct an AdWordsSession.
  AdWordsSession session = new AdWordsSession.Builder()
      .fromFile()
      .withOAuth2Credential(credential)
      .build();
  */
  
   // Alternatively, you can specify your credentials in the constructor:
   

  // Get an OAuth2 credential.
  
  Credential credential = new OfflineCredentials.Builder()
     .forApi(OfflineCredentials.Api.ADWORDS)
     //Oauth2 intro data for Account Manager
     
     //Oauth2 intro for test Account
     .withClientSecrets("<api.adwords.clientId>", "<api.adwords.clientSecret>")
     .withRefreshToken("<api.adwords.refreshToken>")
     .build()
     .generateCredential();

  // Construct an AdWordsSession.
     AdWordsSession session = new AdWordsSession.Builder()
    		 		.withDeveloperToken("<api.adword.clientCustomerId>")  //--> DeveloperToken Account Manager (jeag200d@gmail.com)
    		 		.withClientCustomerId("<api.adwords.developerToken>")		   //--> Test account. (jeag2002@gmail.com)
    		 		.withOAuth2Credential(credential)
    		 		.build();
  

  
  // Instantiate the desired service class using the AdWordsServices utility and
  // a Class object representing your service.
   

  // Get the CampaignService.
  CampaignServiceInterface campaignService =
      new AdWordsServices().get(session, CampaignServiceInterface.class);

  
   //Create data objects and invoke methods on the service class instance. The
   //data objects and methods map directly to the data objects and requests for
   //the corresponding web service.
   

  // Create selector.
  Selector selector = new Selector();
  selector.setFields(new String[] {"Id", "Name"});

  // Get all campaigns.
  CampaignPage page = campaignService.get(selector);
}

}