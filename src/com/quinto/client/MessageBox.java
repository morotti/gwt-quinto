package com.quinto.client;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Label;

public class MessageBox extends PopupPanel {

	public MessageBox(String msg) {
		super(true, true);
		setGlassEnabled(true);

		Label label = new Label(msg);
		setWidget(label);
	}

}
