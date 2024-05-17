package com.example.demo;

public class XNORGate extends Gate{

    public XNORGate() {
        super("XNOR1.png");
    }
    @Override
    void updateOutput () {
        //update inputs and output colors based on their state
        output = !(input1 ^ input2);

        super.updateOutput();
    }
}