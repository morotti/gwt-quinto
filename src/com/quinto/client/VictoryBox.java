package com.quinto.client;

import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class VictoryBox extends PopupPanel {

	public VictoryBox(String msg, int rating) {
		super(true, true);
		setGlassEnabled(true);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		Label label = new Label(msg);
		verticalPanel.add(label);

		StarRating starRating = new StarRating(rating);
		verticalPanel.add(starRating);
	}

}
