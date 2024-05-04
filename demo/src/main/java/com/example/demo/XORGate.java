package com.example.demo;
import javafx.scene.paint.Color;
public class XORGate extends Gate{
    public XORGate() {
        super("XOR.png");
    }
    @Override
    void updateOutput () {
        //update inputs and output colors based on their state
        output = input1 ^ input2;

        super.updateOutput();
    }
}