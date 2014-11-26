package com.alforsconsulting.twist.hellobank;

// JUnit Assert framework can be used for verification

import static junit.framework.Assert.assertTrue;
import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;

import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.twist.core.execution.TwistScenarioDataStore;

public class CreateDuplicateCustomer {

	private Browser browser;

	@Autowired
	private TwistScenarioDataStore scenarioStore;

	public CreateDuplicateCustomer(Browser browser) {
		this.browser = browser;
	}

	public void createCustomer() throws Exception {
		browser.navigateTo("http://localhost:8080/cicd2/helloBank.jsp");
		browser.textbox("createName").setValue("Test Customer");
		browser.submit("createSubmit").click();		
	}

	public void checkForDuplicateMessage(String message) throws Exception {
		boolean success = false;
		ElementStub warningDiv = browser.div("warning");
		if (warningDiv != null) {
			success = warningDiv.containsText(message);
		}		

		assertTrue("Expected duplicate customer warning", success);		
	}

}
