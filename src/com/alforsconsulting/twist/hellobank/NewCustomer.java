package com.alforsconsulting.twist.hellobank;

// JUnit Assert framework can be used for verification

import net.sf.sahi.client.Browser;

import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.twist.core.execution.TwistScenarioDataStore;

public class NewCustomer {

	private Browser browser;

	@Autowired
	private TwistScenarioDataStore scenarioStore;

	public NewCustomer(Browser browser) {
		this.browser = browser;
	}

	public void createCustomer(String name) throws Exception {
		browser.navigateTo("http://localhost:8080/cicd2/helloBank.jsp");
		browser.textbox("createName").setValue(name);
		browser.submit("createSubmit").click();		
	}

}
