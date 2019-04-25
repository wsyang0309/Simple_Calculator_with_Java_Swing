package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JPanel calculatorView;
    private JTextField result;
    private JButton clearButton;
    private JButton signButton;
    private JButton percentButton;
    private JButton divideButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton timesButton;
    private JButton minusButton;
    private JButton a9Button;
    private JButton a8Button;
    private JButton a7Button;
    private JButton plusButton;
    private JButton a3Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton equalButton;
    private JButton dotButton;
    private JButton a0Button;
    private int currentResult;
    private int currentNumber;
    private Operation.Operand operand;
    private boolean cleared;

    public Calculator(){

        cleared = true;
        setText(0);

        a0Button.addActionListener(new NumberButtonClicked(a0Button.getText()));
        a1Button.addActionListener(new NumberButtonClicked(a1Button.getText()));
        a2Button.addActionListener(new NumberButtonClicked(a2Button.getText()));
        a3Button.addActionListener(new NumberButtonClicked(a3Button.getText()));
        a4Button.addActionListener(new NumberButtonClicked(a4Button.getText()));
        a5Button.addActionListener(new NumberButtonClicked(a5Button.getText()));
        a6Button.addActionListener(new NumberButtonClicked(a6Button.getText()));
        a7Button.addActionListener(new NumberButtonClicked(a7Button.getText()));
        a8Button.addActionListener(new NumberButtonClicked(a8Button.getText()));
        a9Button.addActionListener(new NumberButtonClicked(a9Button.getText()));
        clearButton.addActionListener(new ClearButtonClicked());
        equalButton.addActionListener(new EqualButtonClicked());
        plusButton.addActionListener(new AddButtonClicked());
        timesButton.addActionListener(new MultiplyButtonClicked());
        minusButton.addActionListener(new MinusButtonClicked());
        divideButton.addActionListener(new DivideButtonClicked());
        signButton.addActionListener(new SignButtonClicked());


    }

    public JPanel getCalculatorView(){
        return calculatorView;
    }

    public void setText(int number){
        result.setText(" " + number);
    }

    public boolean checkEqualValid(){
        if(currentNumber == -1 || operand == null)
            return false;
        return true;
    }

    private class NumberButtonClicked implements ActionListener {
        private String text;

        public NumberButtonClicked(String text){
            this.text =text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            currentNumber = Integer.parseInt(this.text);

            if(cleared){
                currentResult = currentNumber;
                setText(currentResult);
                currentNumber = -1;
                cleared = false;
            }

        }
    }

    private class ClearButtonClicked implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentResult = 0;
            currentNumber = 0;
            cleared = true;
            setText(0);
        }
    }

    private class SignButtonClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            currentResult *= -1;
            setText(currentResult);
        }
    }

    private class DivideButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            operand = Operation.Operand.DIVIDE;
        }
    }

    private class MultiplyButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            operand = Operation.Operand.MULTIPLY;
        }
    }
    private class AddButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            operand = Operation.Operand.ADD;
        }
    }
    private class MinusButtonClicked implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            operand = Operation.Operand.MINUS;
        }
    }

    private class EqualButtonClicked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (checkEqualValid()) {
                switch (operand) {
                    case ADD:
                        currentResult += currentNumber;
                        currentNumber = -1;
                        operand = null;
                        setText(currentResult);
                        break;
                    case MINUS:
                        currentResult -= currentNumber;
                        currentNumber = -1;
                        operand = null;
                        setText(currentResult);
                        break;
                    case MULTIPLY:
                        currentResult *= currentNumber;
                        currentNumber = -1;
                        operand = null;
                        setText(currentResult);
                        break;
                    case DIVIDE:
                        currentResult /= currentNumber;
                        currentNumber = -1;
                        operand = null;
                        setText(currentResult);
                        break;
                }
                result.setText(" " + currentResult);
            }
        }
    }

}
