package pilvo.businesslogic;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.jayway.restassured.response.Response;

import pilvo.common.utils.CommonUtils;
import pilvo.response.pojos.AccountDetails;
import pilvo.response.pojos.PhoneNmber;
import pilvo.response.pojos.Pricing;
import pilvo.response.pojos.RetrieveMessage;
import pilvo.response.pojos.SendMessage;
import pilvo.response.pojos.UserNumberDetails;
import pilvo.servicehelper.ServiceHelper;

public class CoreBusinessLogic {

	ServiceHelper serviceHelper;
	final int numberOfPhoneNumbers = 2;

	Object body = null;

	// Get Phone Numbers
	public List<UserNumberDetails> getPhoneNumbers() {

		List<UserNumberDetails> details = new ArrayList<UserNumberDetails>();
		try {
			Response response = ServiceHelper.getResponseAllNumbers();
			PhoneNmber numbers = CommonUtils.deserialize(response, PhoneNmber.class);

			if (numbers.getObjects() != null && numbers.getObjects().size() > 1) {
				for (int i = 0; i < numberOfPhoneNumbers; i++) {
					UserNumberDetails userNumberDetail = new UserNumberDetails();
					userNumberDetail.setNumber(numbers.getObjects().get(i).getNumber());
					userNumberDetail.setCountry(numbers.getObjects().get(i).getCountry());
					details.add(userNumberDetail);
				}

			} else {
				// Log that phone number api has given null response
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return details;

	}

	public String getMessageUuid(String srcNumber, String dstNumber, String text) {

		// SendMessage message and return message_uuid;
		SendMessage message = null;
		try {
			body = ImmutableMap.of("src", srcNumber, "text", text, "dst", dstNumber);
			Response send_response = ServiceHelper.sendMessagesToNumbers(body);
			message = CommonUtils.deserialize(send_response, SendMessage.class);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return message.getMessage_uuid().get(0);
	}

	// Get the Rate deducted amt.
	public String getRateDeducted(String message_uuid) {
		RetrieveMessage retrieve_msg = null;
		try {
			Response retrieve_response = ServiceHelper.getRetrieveMessage(message_uuid);
			retrieve_msg = CommonUtils.deserialize(retrieve_response, RetrieveMessage.class);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return retrieve_msg.getTotal_rate();

	}

	// Get Out Bound Price
	public String getOutBoundPrice(String country) {
		Pricing price = null;
		try {
			Response price_response = ServiceHelper.getPriceForCountry(country);
			price = CommonUtils.deserialize(price_response, Pricing.class);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return price.getMessage().getOutbound().getRate();

	}

	// Get Cash Credit Amt
	public String getCashCreditsAmt() {

		AccountDetails details = null;
		try {
			Response accountdetails_response = serviceHelper.getAccountDeatils();
			details = CommonUtils.deserialize(accountdetails_response, AccountDetails.class);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return details.getCash_credits();
	}

}
