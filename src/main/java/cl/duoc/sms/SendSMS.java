package cl.duoc.sms;

import java.util.Arrays;

import com.textmagic.sdk.RestClient;
import com.textmagic.sdk.RestException;
import com.textmagic.sdk.resource.instance.TMNewMessage;

public class SendSMS {

	public static void main(String[] args) {
		RestClient client = new RestClient("alejandroarevalo", "C2O0g7b2agtN2zgVWAMZPO4EnvyMEi");
		TMNewMessage m = client.getResource(TMNewMessage.class);
		m.setText("Hello from TextMagic Java");
		m.setPhones(Arrays.asList(new String[] { "+56991623740" }));
		try {
			m.send();
		} catch (final RestException e) {
			System.out.println(e.getErrors());
			throw new RuntimeException(e);
		}
		System.out.println(m.getId());
	}
}
