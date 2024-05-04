package com.example.demo;
import javafx.scene.paint.Color;
public class NANDGate  extends Gate{
    public NANDGate() {
        super("NAND.png");
    }
    @Override
    void updateOutput () {
        //update inputs and output colors based on their state
        output = !(input1 && input2);
        super.updateOutput();
    }
}
