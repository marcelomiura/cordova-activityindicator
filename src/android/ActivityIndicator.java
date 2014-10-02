package org.apache.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.plugin.AndroidProgressHUD;

public class ActivityIndicator extends CordovaPlugin {

	private AndroidProgressHUD activityIndicator = null;
	private String text = null;
	private Boolean cancelable = null;
	private CallbackContext callbackContext = null;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("show")) {
			String text = args.getString(0);
			Boolean cancelable = Boolean.parseBoolean(args.getString(1));
			show(text, cancelable, callbackContext);
			// callbackContext.success();
			return true;
		} else if (action.equals("hide")) {
			hide();
			callbackContext.success();
			return true;
		}

		return false;
	}

	/**
	 * This show the ProgressDialog
	 * @param text - Message to display in the Progress Dialog
	 */
	public void show(String text, Boolean cancelable, CallbackContext callbackContext) {
		this.text = text;
		this.cancelable = cancelable;
		this.callbackContext = callbackContext;

		cordova.getActivity().runOnUiThread(new Runnable() {
			public void run() {
				activityIndicator = AndroidProgressHUD.show(ActivityIndicator.this.cordova.getActivity(), ActivityIndicator.this.text, true, ActivityIndicator.this.cancelable, null);
				this.callbackContext.success();
			}
		});
	}

	/**
	 * This hide the ProgressDialog
	 */
	public void hide() {
		if (activityIndicator != null) {
			activityIndicator.dismiss();
			activityIndicator = null;
		}
	}
}