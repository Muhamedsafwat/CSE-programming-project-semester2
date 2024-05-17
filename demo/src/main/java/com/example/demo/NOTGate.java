package com.example.demo;

public class NOTGate extends Gate2 {
    public NOTGate() {
        super("NOT.png");
        inputButton.setParentNot(this);
    }
    @Override
    public void updateOutput() {
        //update inputs and output colors based on their state
       output = !input;
       super.updateOutput();
    }
}