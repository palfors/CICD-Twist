package com.alforsconsulting.twist.hellobank;

// JUnit Assert framework can be used for verification

import static junit.framework.Assert.assertTrue;
import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;

import org.springframework.beans.factory.annotation.Autowired;

import com.thoughtworks.twist.core.execution.TwistScenarioDataStore;

public class CreateAccount {

	private Browser browser;

	@Autowired
	private TwistScenarioDataStore scenarioStore;

	public CreateAccount(Browser browser) {
		this.browser = browser;
	}

	public void createCheckingAccount() throws Exception {
	}

	public void createCheckingAccountWithBalance(Double balance) throws Exception {
		browser.textbox("initialBalance").setValue(String.valueOf(balance));
		browser.submit(0).click();	
	}

	public void checkForAccountWith(String account) throws Exception {
		boolean success = false;
		ElementStub div = browser.div("accounts");
		if (div != null) {
			success = div.containsText(account);
		}		

		assertTrue("Expected account: " + account, success);		
	
	}

}
