package pilvo.test.cases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pilvo.base.BaseSetup;
import pilvo.businesslogic.SendMessageAssertions;

public class PilvoMessagingTest extends BaseSetup {

	@Test
	public void testGetAllNumbers() {

		testSteps.log(Status.INFO,
				"Testing the Pilvo Send SMS API Flow and validating correct amt deducted for sending Sms");
		log.info("Testing the Pilvo Send SMS API Flow and validating correct amt deducted for sending Sms");
		SendMessageAssertions sendmessage = new SendMessageAssertions();
		sendmessage.sendMessageFlowValidations();

	}

}
