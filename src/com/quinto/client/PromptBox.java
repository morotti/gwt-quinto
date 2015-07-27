package com.quinto.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class PromptBox extends DialogBox {

	String answer;

	public PromptBox(String question, String defaultanswer) {
		setHTML(question);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		setWidget(verticalPanel);
		verticalPanel.setSize("153px", "59px");

		final TextBox textBox = new TextBox();
		textBox.setText(defaultanswer);
		verticalPanel.add(textBox);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("149px", "23px");

		Button okButton = new Button("Ok");
		okButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				answer = textBox.getText();
				PromptBox.this.hide();
			}
		});
		horizontalPanel.add(okButton);

		Button cancelButton = new Button("Cancel");
		cancelButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				answer = null;
				PromptBox.this.hide();
			}
		});
		horizontalPanel.add(cancelButton);
	}

	public String getAnswer() {
		return answer;
	}
}
