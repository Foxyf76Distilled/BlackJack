
package image.view;

import image.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.util.Random;

import com.sun.prism.paint.Color;

import java.util.ArrayList;

public class OpenImageController {

	public Main main;

	public int userValue;

	public int CPUValue;

	public int streakValue;

	public ArrayList<Integer> userCards = new ArrayList();
	public ArrayList<Integer> CPUCards = new ArrayList();

	@FXML
	public Button play;

	@FXML
	public Button hit;

	@FXML
	public Button stand;

	@FXML
	public Label userValueLabel;

	@FXML
	public Label CPUValueLabel;

	@FXML
	public HBox displayUserCards;

	@FXML
	public HBox displayCPUCards;

	@FXML
	public Label verdict;

	@FXML
	public Line upper;

	@FXML
	public Line lower;

	@FXML
	public Label streak;

	@FXML
	public Label userMoneyLabel;
	public int userMoney = 30;

	@FXML
	public Label CPUMoneyLabel;
	public int CPUMoney = 30;

	@FXML
	public TextField bet;

	@FXML
	public Button betButton;

	@FXML
	public Label totalBetLabel;
	public int totalBet;

	public int counter = 0;

	public void play() {
		// betButton.setDisable(false);
		// bet.setDisable(false);
		totalBet = 0;
		userMoneyLabel.setText(String.valueOf(userMoney));
		CPUMoneyLabel.setText(String.valueOf(CPUMoney));
		displayUserCards.getChildren().clear();
		displayCPUCards.getChildren().clear();
		upper.setVisible(false);
		lower.setVisible(false);
		verdict.setVisible(false);
		userCards.clear();
		CPUCards.clear();
		generateUserHand();
		generateCPUHand();
		CPUValueLabel.setText("?");
		play.setDisable(true);
		hit.setDisable(false);
		stand.setDisable(false);
	}

	public int generateUserHand() {
		counter++;
		displayUserCards.setSpacing(20);
		Random r = new Random();
		int Low = 1;
		int High = 11;
		int Result = r.nextInt(High - Low) + Low;
		userValue = Result;
		userCards.add(userValue);
		// userValue = userValue + Result;
		Label card = new Label();
		card.setText(" " + String.valueOf(Result) + " ");
		card.setStyle("-fx-font: 34 arial; -fx-background-color: WHITE");
		card.setMinWidth(75);
		card.setMinHeight(125);
		card.setAlignment(Pos.CENTER);
		displayUserCards.getChildren().add(card);
		getTotalUser();
		return userValue;
	}

	public void generateCPUHand() {
		Random r = new Random();
		int Low = 1;
		int High = 11;
		int Result = r.nextInt(High - Low) + Low;
		CPUValue = Result;
		System.out.println("Generated new card: " + Result);
		CPUCards.add(CPUValue);
		System.out.println("Array total: " + getTotalCPU());
		Label card = new Label();
		card.setText(" " + String.valueOf(Result) + " ");
		card.setStyle("-fx-font: 34 arial; -fx-background-color: WHITE");
		card.setMinWidth(75);
		card.setMinHeight(125);
		card.setAlignment(Pos.CENTER);
		card.setText(" ? ");
		displayCPUCards.getChildren().add(card);
	}

	public int getTotalUser() {
		int total = 0;
		for (int i = 0; i < userCards.size(); i++) {
			total = total + userCards.get(i);
			userValueLabel.setText(String.valueOf(total));
		}
		if (total > 21) {
			userValueLabel.setText(String.valueOf(total) + "-" + "BUST");
			hit.setDisable(true);
		}
		return total;
	}

	public int getTotalCPU() {
		int totalCPU = 0;
		for (int i = 0; i < CPUCards.size(); i++) {
			totalCPU = totalCPU + CPUCards.get(i);
		}
		return totalCPU;
	}

	public void hitCPU() {
		int total = getTotalCPU();
		int store = 0;
		while (total >= 0 && total < 14) {
			generateCPUHand();
			total = getTotalCPU();
			System.out.println("\nCurrent Total: " + total);

		}
		if (total == 14) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 14 - Percentage chance value: \n" + chance);
			if (chance <= 0.50f) {
				System.out.println("Hand equals 14, drawing card 50% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}
		if (total == 15) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 15 - Percentage chance value: \n" + chance);
			if (chance <= 0.40f) {
				System.out.println("Hand equals 15, drawing card 40% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}
		if (total == 16) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 16 - Percentage chance value: \n" + chance);
			if (chance <= 0.30f) {
				System.out.println("Hand equals 16, drawing card 30% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}
		if (total == 17) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 17 - Percentage chance value: \n" + chance);

			if (chance <= 0.20f) {
				System.out.println("Hand equals 17, drawing card 20% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}

		if (total == 18) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 18 - Percentage chance value: \n" + chance);

			if (chance <= 0.10f) {
				System.out.println("Hand equals 18, drawing card 10% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}
		if (total == 19) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 19 - Percentage chance value: \n" + chance);

			if (chance <= 0.05f) {
				System.out.println("Hand equals 19, drawing card 5% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}

		if (total == 20) {
			Random r = new Random();
			float chance = r.nextFloat();
			System.out.println("\nTotal is 20 - Percentage chance value: \n" + chance);
			if (chance <= 0.01f) {
				System.out.println("Hand equals 20, drawing card 1% of time");
				generateCPUHand();
				total = getTotalCPU();
				System.out.println("\nCurrent Total: " + total);
			}
		}

		while (total == 21) {
			CPUValueLabel.setText(String.valueOf(total));
			break;
		}
		if (total > 21) {
			CPUValueLabel.setText(total + " - BUST");
		} else {
			CPUValueLabel.setText(String.valueOf(total));
		}
	}

	public void showCPUHand() {
		hitCPU();
		displayCPUCards.getChildren().clear();
		displayCPUCards.setSpacing(20);
		for (int i = 0; i < CPUCards.size(); i++) {
			Label card = new Label();
			card.setStyle("-fx-font: 34 arial; -fx-background-color: WHITE");
			card.setMinWidth(75);
			card.setMinHeight(125);
			card.setAlignment(Pos.CENTER);
			card.setText(String.valueOf(" " + CPUCards.get(i)) + " ");
			displayCPUCards.getChildren().add(card);
		}
		determineWinner();
	}

	public int determineWinner() {
		int userTotal = getTotalUser();
		int CPUTotal = getTotalCPU();
		System.out.println("User: " + userTotal);
		System.out.println("CPU: " + CPUTotal);
		upper.setVisible(true);
		lower.setVisible(true);
		verdict.setVisible(true);

		if (userTotal <= 21 && userTotal > CPUTotal) {
			verdict.setText("YOU WIN!");
			streakValue++;
			streak.setText(String.valueOf(streakValue));
			userMoney = userMoney + totalBet;
			userMoneyLabel.setText(String.valueOf(userMoney));
		}

		if (userTotal <= 21 && CPUTotal > 21) {
			verdict.setText("YOU WIN!");
			streakValue++;
			streak.setText(String.valueOf(streakValue));
			userMoney = userMoney + totalBet;
			userMoneyLabel.setText(String.valueOf(userMoney));

		}

		if (CPUTotal <= 21 && CPUTotal > userTotal) {
			verdict.setText("YOU LOSE!");
			streakValue = 0;
			streak.setText(String.valueOf(streakValue));
			CPUMoney = CPUMoney + totalBet;
			CPUMoneyLabel.setText(String.valueOf(CPUMoney));

		}

		if (CPUTotal <= 21 && userTotal > 21) {
			verdict.setText("YOU LOSE!");
			streakValue = 0;
			streak.setText(String.valueOf(streakValue));
			CPUMoney = CPUMoney + totalBet;
			CPUMoneyLabel.setText(String.valueOf(CPUMoney));

		}

		if (userTotal == CPUTotal || userTotal > 21 && CPUTotal > 21) {
			verdict.setText("DRAW!");
			CPUMoney = 30;
			userMoney = 30;
			CPUMoneyLabel.setText(String.valueOf(CPUMoney));
			userMoneyLabel.setText(String.valueOf(userMoney));

		}

		if (userMoney == 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Game Over");
			alert.setHeaderText("Game Over!");
			alert.setContentText("You ran out of cash!");
			alert.showAndWait();
			userMoney = 30;
			CPUMoney = 30;
			streak.setText(String.valueOf(0));
		}
		totalBet = 0;
		totalBetLabel.setText(String.valueOf(totalBet));
		streak.setText(String.valueOf(streakValue));
		play.setDisable(false);
		stand.setDisable(true);
		hit.setDisable(true);
		return streakValue;
	}

	public void betting() {
		bettingUser();
		bettingCPU();
	}

	public int bettingUser() {
		int betAmount = Integer.valueOf(bet.getText());
		if (betAmount > userMoney) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Bet");
			alert.setHeaderText("Bet Exceeded Money");
			alert.setContentText("Your bet has exceeded you current cash total." + "\nPlease enter a lesser amount.");
			alert.showAndWait();
		} else {
			userMoney = userMoney - betAmount;
			userMoneyLabel.setText(String.valueOf(userMoney));
			totalBet = totalBet + betAmount;
			totalBetLabel.setText(String.valueOf(totalBet));
		}
		return totalBet;
	}

	public int bettingCPU() {

		if (getTotalCPU() == 11) {
			System.out.println("Total equals 11");
			Random r = new Random();
			float chance = r.nextFloat();
			if (chance <= 0.50f) {
				Random amount = new Random();
				int Low = 5;
				int High = CPUMoney;
				int Result = amount.nextInt(High - Low) + Low;
				CPUMoney = CPUMoney - Result;
				CPUMoneyLabel.setText(String.valueOf(CPUMoney));
				totalBet = totalBet + Result;
				totalBetLabel.setText(String.valueOf(totalBet));
			}
			return totalBet;
		}

		if (getTotalCPU() < 11) {
			System.out.println("Total is less than 11");
			Random amount = new Random();
			int Low = 3;
			int High = CPUMoney;
			int Result = amount.nextInt(High - Low) + Low;
			CPUMoney = CPUMoney - Result;
			CPUMoneyLabel.setText(String.valueOf(CPUMoney));
			totalBet = totalBet + Result;
			totalBetLabel.setText(String.valueOf(totalBet));
		}

		return totalBet;
	}

}
