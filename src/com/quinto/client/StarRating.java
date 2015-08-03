package com.quinto.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;

public class StarRating extends Composite {

	private Image left;
	private Image center;
	private Image right;

	private final String yellow = "star_yellow.svg";
	private final String grey = "star_grey.svg";

	public StarRating(int rating) {

		Grid grid = new Grid(1, 3);
		initWidget(grid);

		left = new Image(yellow);
		left.setStyleName("starbox");
		grid.setWidget(0, 0, left);

		center = new Image(yellow);
		center.setStyleName("starbox");
		grid.setWidget(0, 1, center);

		right = new Image(yellow);
		right.setStyleName("starbox");
		grid.setWidget(0, 2, right);

		setRating(rating);
	}

	/**
	 * 
	 * @param rating
	 *            between 0 and 3 stars
	 */
	public void setRating(int rating) {
		// left star
		{
			if (rating >= 1)
				left.setUrl(yellow);
			else
				left.setUrl(grey);
		}

		// center star
		{
			if (rating >= 2)
				center.setUrl(yellow);
			else
				center.setUrl(grey);
		}

		// right star
		{
			if (rating >= 3)
				right.setUrl(yellow);
			else
				right.setUrl(grey);
		}

	}

}
