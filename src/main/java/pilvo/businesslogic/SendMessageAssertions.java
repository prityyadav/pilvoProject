package pilvo.businesslogic;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import pilvo.common.utils.DataManager;
import pilvo.response.pojos.UserNumberDetails;

public class SendMessageAssertions {

	private CoreBusinessLogic coreLogic;
	private SoftAssert softAssert;
	public Logger log;
	public ExtentTest testSteps;

	public SendMessageAssertions() {
		coreLogic = new CoreBusinessLogic();
		softAssert = new SoftAssert();
	}

	public void sendMessageFlowValidations() {

		String totalCashCredits = coreLogic.getCashCreditsAmt();

		List<UserNumberDetails> userdetails = coreLogic.getPhoneNumbers();

		try {
			if (userdetails != null && userdetails.size() > 1) {
				String messageUuid = coreLogic.getMessageUuid(userdetails.get(0).getNumber(),
						userdetails.get(1).getNumber(), DataManager.getInstance().getTextMsg());
				String rateDeducted = coreLogic.getRateDeducted(messageUuid);
				String outBoundRate = coreLogic.getOutBoundPrice(userdetails.get(0).getCountry());
				softAssert.assertEquals(rateDeducted, outBoundRate,
						"Rate and the price deducted for the sending message is not same");
				String cashCreditsAfterDeduction = coreLogic.getCashCreditsAmt();

				if (Float.parseFloat(cashCreditsAfterDeduction) + Float.parseFloat((rateDeducted)) == Float
						.parseFloat(totalCashCredits)) {
					softAssert.assertTrue(true,
							"Cash credit is deducted correctly from the total cash credits after sending msg ");
				} else
					softAssert.fail(
							"Cash credit is not deducted correctly from the total cash credits after sending msg ");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
