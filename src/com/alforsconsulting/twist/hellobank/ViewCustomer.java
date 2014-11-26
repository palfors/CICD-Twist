package com.alforsconsulting.twist.hellobank;

// JUnit Assert framework can be used for verification

import static junit.framework.Assert.assertTrue;
import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;

import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.twist.core.execution.TwistScenarioDataStore;

public class ViewCustomer {

	private Browser browser;

	@Autowired
	private TwistScenarioDataStore scenarioStore;

	public ViewCustomer(Browser browser) {
		this.browser = browser;
	}

	public void logIn(String name) throws Exception {
		browser.navigateTo("http://localhost:8080/cicd2/helloBank.jsp");
		browser.textbox("loginName").setValue(name);
		browser.submit("loginSubmit").click();

		String validationString = "Customer: " + name;
		boolean success = false;
		ElementStub customerInfoDiv = browser.div("customerInfo");
		if (customerInfoDiv != null) {
			success = customerInfoDiv.containsText(validationString);
		}				
		
		assertTrue("Unable to login as customer: " + name, success);		
	}

}
