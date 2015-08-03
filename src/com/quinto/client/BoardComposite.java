package com.quinto.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.NumberLabel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class BoardComposite extends Composite {

	Board board;
	Grid grid;

	private NumberLabel<Integer> blacksCountLabel;
	private NumberLabel<Integer> whitesCountLabel;
	private NumberLabel<Integer> clicksCountLabel;
	private NumberLabel<Integer> pointsLabel;
	private NumberLabel<Integer> levelLabel;

	public BoardComposite(int side) {

		board = new Board(3, 3);
		grid = new Grid(3, 3);

		FlowPanel flowPanel = new FlowPanel();
		
		FlowPanel flowPanel_2 = new FlowPanel();
		flowPanel_2.setStyleName("statspanel");
		flowPanel.add(flowPanel_2);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		flowPanel_2.add(horizontalPanel);
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setSize("", "");
		horizontalPanel.setStyleName("levelstatspanel");

		Grid grid_1 = new Grid(3, 2);
		grid_1.setBorderWidth(0);
		horizontalPanel.add(grid_1);
		horizontalPanel.setCellVerticalAlignment(grid_1, HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setCellHorizontalAlignment(grid_1, HasHorizontalAlignment.ALIGN_CENTER);
		grid_1.setSize("64px", "64px");

		Label lblNewLabel_1 = new Label("Blacks: ");
		grid_1.setWidget(0, 0, lblNewLabel_1);

		blacksCountLabel = new NumberLabel<Integer>();
		blacksCountLabel.setStyleName("boldtext");
		grid_1.setWidget(0, 1, blacksCountLabel);

		Label lblNewLabel_4 = new Label("Whites: ");
		grid_1.setWidget(1, 0, lblNewLabel_4);

		whitesCountLabel = new NumberLabel<Integer>();
		whitesCountLabel.setStyleName("boldtext");
		grid_1.setWidget(1, 1, whitesCountLabel);

		Label lblNewLabel = new Label("Clicks: ");
		grid_1.setWidget(2, 0, lblNewLabel);

		clicksCountLabel = new NumberLabel<Integer>();
		clicksCountLabel.setStyleName("boldtext");
		grid_1.setWidget(2, 1, clicksCountLabel);
		grid_1.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_1.getCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);
		grid_1.getCellFormatter().setVerticalAlignment(0, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_1.getCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_1.getCellFormatter().setHorizontalAlignment(1, 1, HasHorizontalAlignment.ALIGN_LEFT);
		grid_1.getCellFormatter().setVerticalAlignment(1, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_1.getCellFormatter().setVerticalAlignment(2, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_1.getCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_LEFT);
		grid_1.getCellFormatter().setVerticalAlignment(2, 1, HasVerticalAlignment.ALIGN_MIDDLE);
		grid_1.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_LEFT);
		grid_1.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_LEFT);
		grid_1.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_LEFT);

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		flowPanel_2.add(horizontalPanel_1);
		horizontalPanel_1.setStyleName("gamestatspanel");
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setStyleName("statsbox");
		horizontalPanel_1.add(verticalPanel);
		verticalPanel.setSize("64px", "64px");

		Label lblNewLabel_3 = new Label("POINTS");
		lblNewLabel_3.setStyleName("boldtext");
		verticalPanel.add(lblNewLabel_3);

		pointsLabel = new NumberLabel<Integer>();
		pointsLabel.setStyleName("bigboldtext");
		verticalPanel.add(pointsLabel);
		pointsLabel.setValue(new Integer(0));

		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.setStyleName("statsbox");
		verticalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setSize("64px", "64px");

		Label lblNewLabel_2 = new Label("LEVEL");
		lblNewLabel_2.setStyleName("boldtext");
		verticalPanel_2.add(lblNewLabel_2);

		levelLabel = new NumberLabel<Integer>();
		levelLabel.setStyleName("bigboldtext");
		verticalPanel_2.add(levelLabel);
		flowPanel.add(grid);
		grid.setSize("", "");

		grid.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Cell cell = grid.getCellForEvent(event);

				int x = cell.getCellIndex();
				int y = cell.getRowIndex();

				BoardComposite.this.click(x, y);
			}
		});
		initWidget(flowPanel);
		flowPanel.setSize("", "");

		grid.setStyleName("board");
		grid.setBorderWidth(0);
		
		FlowPanel flowPanel_1 = new FlowPanel();
		flowPanel_1.setStyleName("levelmanagementpanel");
		flowPanel.add(flowPanel_1);
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		flowPanel_1.add(horizontalPanel_3);
		horizontalPanel_3.setStyleName("changelevelpanel");
		horizontalPanel_3.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		Button previousLevelButton = new Button("Previous Level");
		horizontalPanel_3.add(previousLevelButton);
		
		Button nextLevelButton = new Button("Next Level");
		horizontalPanel_3.add(nextLevelButton);
		
		HorizontalPanel horizontalPanel_4 = new HorizontalPanel();
		flowPanel_1.add(horizontalPanel_4);
		horizontalPanel_4.setStyleName("retrypanel");
		horizontalPanel_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanel_4.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
				Button retryButton = new Button("Retry");
				horizontalPanel_4.add(retryButton);
				retryButton.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						int level = levelLabel.getValue().intValue();
						gotoLevel(level);
					}
				});

		gotoLevel(1);
	}

	public void generateGrid(int width, int height) {
		grid.clear();
		grid.resize(height, width);
		board.generate(width, height);

		// add text widget to each cell
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//grid.setWidget(y, x, new Label("(" + x + "," + y + ")"));

				grid.getCellFormatter().setAlignment(y, x, HasHorizontalAlignment.ALIGN_CENTER,
						HasVerticalAlignment.ALIGN_MIDDLE);

				grid.setText(y, x, "");
			}
		}

		// update color
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				updateCell(x, y);
			}
		}

		updateCounters();
		resetClicks();
	}

	public void click(int x, int y) {
		board.click(x, y);

		updateCell(x, y);

		if (y > 0)
			updateCell(x, y - 1);

		if (y < board.getHeight() - 1)
			updateCell(x, y + 1);

		if (x > 0)
			updateCell(x - 1, y);

		if (x < board.getWidth() - 1)
			updateCell(x + 1, y);

		updateCounters();
		incrementClicks();

		if (board.isWon()) {
			onVictory();
		}
	}

	private void onVictory() {
		int points = pointsLabel.getValue().intValue();
		int level = levelLabel.getValue().intValue();
		int clicks = clicksCountLabel.getValue().intValue();
		int width = grid.getColumnCount();
		int height = grid.getRowCount();

		// update points
		points += estimatePoints(level, width, height, clicks);
		pointsLabel.setValue(new Integer(points));

		// estimate rating
		int rating = estimateRating(width, height, clicks);

		// popup victorybox
		final VictoryBox victoryBox = new VictoryBox(
				"Level " + Integer.toString(level) + " completed !", rating);
		victoryBox.center();

		// autoclose the victory box and switch to the next level after a few seconds
		Timer t = new Timer() {
			@Override
			public void run() {
				victoryBox.hide();

				int level = levelLabel.getValue().intValue();
				BoardComposite.this.gotoLevel(level + 1);
			}
		};

		t.schedule(2000);

	}

	/**
	 * 
	 * @param width
	 * @param height
	 * @param clicks
	 * @return rating between 0 and 3
	 */
	private int estimateRating(int width, int height, int clicks) {
		int minClicks = getMinClicks(width, height);

		// player did the minimum possible clicks => awesome
		if (clicks <= minClicks)
			return 3;

		// player did more clicks than the number of cells on the grid => not optimal
		// (clicking twice a cell cancel the action)
		if (clicks > width * height)
			return 1;

		// something between
		return 2;
	}

	private static int estimatePoints(int level, int width, int height, int clicks) {
		int points = 0;
		int minClicks = getMinClicks(width, height);

		points += level;
		points += Math.max(0, level + minClicks - clicks);

		// add a 0 to make more impressive scores
		return points * 10;
	}

	private static int getMinClicks(int width, int height) {
		// @formatter:off
		
		// square grids
		if(width == 1 && height == 1)       return 1;
		else if (width == 2 && height == 2)	return 4;
		else if (width == 3 && height == 3)	return 5;
		else if (width == 4 && height == 4)	return 10;
		else if (width == 5 && height == 5)	return 15;
		else if (width == 6 && height == 6)	return 28;
		else if (width == 7 && height == 7)	return 27;
		else if (width == 8 && height == 8)	return 40;
		else if (width == 8 && height == 8)	return 39;
		
		// rectangular grids
		else if (width == 2 && height == 1)	return 1;
		else if (width == 3 && height == 2)	return 4;
		else if (width == 4 && height == 3)	return 10;
		else if (width == 5 && height == 4)	return 10;

		// default
		else return (int) Math.floor(width * height * 0.60);
		
		// @formatter:on
	}

	protected void gotoLevel(int level) {
		levelLabel.setValue(new Integer(level));

		if (level == 1) {
			// level 1 is tutorial: click on the center cell to understand the game.
			// X-X
			// ---
			// X-X
			generateGrid(3, 3);

			// issue : the grid autosizes itself based on content => the 'click me !' cell gets bigger than all other cells
			// hack : fill all empty cells with non-breakable spaces 
			for (int y = 0; y < grid.getRowCount(); y++) {
				for (int x = 0; x < grid.getColumnCount(); x++) {
					grid.setHTML(y, x,
							"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
			}

			grid.setHTML(1, 1, "Click me !");

			board.flip(0, 0);
			board.flip(0, 2);
			board.flip(2, 0);
			board.flip(2, 2);

			updateAllCells();
			updateCounters();
		}
		else {
			// level -> [x,y]
			//     2 -> [2,2]
			//     3 -> [3,2] x++
			//     4 -> [3,3] y++

			int width = ((level + 2) / 2) + (level % 2);
			int height = ((level + 2) / 2);

			generateGrid(width, height);
		}
	}

	public void updateCell(int x, int y) {
		if (board.get(x, y) == true) {
			grid.getCellFormatter().setStyleName(y, x, "black-cell");
		}
		else {
			grid.getCellFormatter().setStyleName(y, x, "white-cell");
		}
	}

	public void updateAllCells() {
		for (int y = 0; y < grid.getRowCount(); y++) {
			for (int x = 0; x < grid.getColumnCount(); x++) {
				updateCell(x, y);
			}
		}
	}

	public void updateCounters() {
		whitesCountLabel.setValue(new Integer(board.countWhites()));
		blacksCountLabel.setValue(new Integer(board.countBlacks()));
	}

	public void incrementClicks() {
		int clicks = clicksCountLabel.getValue().intValue();
		clicksCountLabel.setValue(new Integer(clicks + 1));
	}

	public void resetClicks() {
		clicksCountLabel.setValue(new Integer(0));
	}

}
