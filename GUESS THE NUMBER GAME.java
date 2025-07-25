import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.Random;

public class GuessTheNumberGame extends JFrame {

private int randomNumber;

private int attempts;

private JLabel instructionLabel;

private JTextField guessField;

private JButton guessButton;

private JLabel feedbackLabel;

public GuessTheNumberGame() {

setTitle("Guess the Number Game");

setSize(400, 200);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setLayout(new FlowLayout());

randomNumber = generateRandomNumber();

attempts = 0;

instructionLabel = new JLabel("Guess a number between 1 and 100:");
guessField = new JTextField(10);

guessButton = new JButton("Guess");

feedbackLabel = new JLabel("You have 0 attempts.");

guessButton.addActionListener(new GuessButtonListener());

add(instructionLabel);

add(guessField);

add(guessButton);

add(feedbackLabel);

setLocationRelativeTo(null); // Center the window

setVisible(true);

}

private int generateRandomNumber() {

Random rand = new Random();

return rand.nextInt(100) + 1;

}

private class GuessButtonListener implements ActionListener {

public void actionPerformed(ActionEvent e) {

try {

int userGuess = Integer.parseInt(guessField.getText());

attempts++;

if (userGuess < 1 || userGuess > 100) {

feedbackLabel.setText("Please enter a number between 1 and 100.");

} else if (userGuess < randomNumber) {
feedbackLabel.setText("Too low! Attempts: " + attempts);

} else if (userGuess > randomNumber) {

feedbackLabel.setText("Too high! Attempts: " + attempts);

} else {

feedbackLabel.setText("Correct! You guessed it in " + attempts + "

attempts.");

}

guessButton.setEnabled(false);

} catch (NumberFormatException ex) {

feedbackLabel.setText("Please enter a valid number.");

}

}

}

public static void main(String[] args) {

new GuessTheNumberGame();

}

}
