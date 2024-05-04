package com.example.demo;

import javafx.scene.paint.Color;
public class NOTGate extends Gate2 {
    public NOTGate() {
        super("NOT.png");
    }

    @Override
    void updateOutput() {
        //update inputs and output colors based on their state
        output = !input;
        super.updateOutput();
    }
}