package com.example.calculator;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ArrayList;


import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    private ArrayList<String> stack = new ArrayList<>();
    public TextField displayTextField;
    private boolean resultDisplayed = false;


    public void seven(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "7");
    }

    public void eight(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "8");
    }

    public void nine(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "9");
    }

    public void multiply(ActionEvent actionEvent) {
        double first = 0;
        if (stack.size() > 0)
            first = Double.parseDouble(stack.remove(stack.size()-1));
        String secondOperand = displayTextField.getText();
        double second = 0;
        if (operandValid(secondOperand)) {
            second = Double.parseDouble(secondOperand);
        }
        double result = first * second;
        String firstOperand = "" + result;
        displayTextField.setText(firstOperand);
        resultDisplayed = true;
    }

    public void four(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "4");
    }

    public void five(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "5");
    }

    public void six(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "6");
    }

    public void divide(ActionEvent actionEvent) {
        double first = 0;
        if (stack.size() > 0)
            first = Double.parseDouble(stack.remove(stack.size()-1));
        String secondOperand = displayTextField.getText();
        double second = 0;
        if (operandValid(secondOperand)) {
            second = Double.parseDouble(secondOperand);
        }
        if (second != 0) {
            double result = first / second;
            result = Math.round(result * 4.0) / 4.0;
            String firstOperand = "" + result;
            displayTextField.setText("" + firstOperand);
        } else {
            displayTextField.setText("");
        }
        resultDisplayed = true;
    }

    public void one(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "1");
    }

    public void two(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "2");
    }

    public void three(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "3");
    }

    public void subtract(ActionEvent actionEvent) {
        double first = 0;
        if (stack.size() > 0)
            first = Double.parseDouble(stack.remove(stack.size()-1));
        String secondOperand = displayTextField.getText();
        double second = 0;
        if (operandValid(secondOperand)) {
            second = Double.parseDouble(secondOperand);
        }
        double result = first - second;
        String firstOperand = "" + result;
        displayTextField.setText(firstOperand);
        resultDisplayed = true;
    }

    public void zero(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + "0");
    }

    public void point(ActionEvent actionEvent) {
        eraseDisplay();
        displayTextField.setText(displayTextField.getText() + ".");
    }

    public void enter(ActionEvent actionEvent) {
        stack.add(displayTextField.getText());
        displayTextField.setText("");
    }

    public void add(ActionEvent actionEvent) {
        double first = 0;
        if (stack.size() > 0)
            first = Double.parseDouble(stack.remove(stack.size()-1));
        String secondOperand = displayTextField.getText();
        double second = 0;
        if (operandValid(secondOperand)) {
            second = Double.parseDouble(secondOperand);
        }
        double result = first + second;
        String firstOperand = "" + result;
        displayTextField.setText(firstOperand);
        resultDisplayed = true;
    }

    public void changeSign(ActionEvent actionEvent) {
        String display = displayTextField.getText();
        if (display.startsWith("-"))
            display = display.substring(1);
        else
            display = "-" + display;
        displayTextField.setText(display);
    }
    private boolean operandValid(String operand) {
        if (operand.contains("0") ||
                operand.contains("1") ||
                operand.contains("2") ||
                operand.contains("3") ||
                operand.contains("4") ||
                operand.contains("5") ||
                operand.contains("6") ||
                operand.contains("7") ||
                operand.contains("8") ||
                operand.contains("9"))
            return true;
        return false;
    }
    private void eraseDisplay() {
        if (resultDisplayed) {
            stack.add(displayTextField.getText());
            displayTextField.setText("");
            resultDisplayed = false;
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // The following will force the field to be numeric only.
        // Limits imposed are an optional minus sign, up to 7 significant
        // digits, an optional decimal point follwed by up to 4 digits.
        displayTextField.textProperty().addListener(
                (ObservableValue<? extends String> observable,
                 String oldValue, String newValue) -> {
                    if (!newValue.matches(
                            "(\\-{0,1})\\d{0,7}([\\.]\\d{0,4})?")) {
                        displayTextField.setText(oldValue);
                    }
                });

    }

    public void clearArrayList(ActionEvent actionEvent) {
        stack.clear();
        displayTextField.setText("");
        resultDisplayed = false;
    }
}