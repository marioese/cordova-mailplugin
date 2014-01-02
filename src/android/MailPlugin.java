package net.appvanced.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

public class MailPlugin extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callback) {
		if (action.equals("send")) {
			try {
				String user = "", password = "", from = "", to = "", subject = "", body = "";
				int len = args.length();
				for(int i = 2; i < len; i++) {
					switch(i) {
						case 0:
							user = args.getString(i);
							break;
						case 1:
							password = args.getString(i);
							break;
						case 2:
							from = args.getString(i);
							break;
						case 3:
							to = args.getString(i);
							break;
						case 4:
							subject = args.getString(i);
							break;
						case 5:
							body = args.getString(i);
							break;
					}
				}
				
				Mail mail = new Mail(user, password);
				mail.setFrom(from);
				mail.setBody(body);
				mail.setSubject(subject);
				mail.setTo(new String[] { to });
				mail.send();
				
				callback.success("Mail has been sent to: " + to);

				return true;
			} catch (final Exception e) {
				callback.error(e.getMessage());
			}
		}
		
		return false;
	}
}

