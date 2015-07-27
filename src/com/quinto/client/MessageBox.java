package com.quinto.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class MessageBox extends DialogBox {

	public MessageBox(String msg) {
		setHTML(msg);

		Button btnNewButton = new Button("Close");
		btnNewButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				MessageBox.this.hide();
			}
		});
		setWidget(btnNewButton);
		btnNewButton.setSize("100%", "100%");
	}

}
