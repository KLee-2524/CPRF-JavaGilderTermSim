/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javagildertermsim;

/**
 *
 * @author kaleblee
 */
public class Axis {
    // Define fields.
    private int addr;
    private int axis;
    private double propGain; // Proptional Gain (PID Control)
    private double intGain; // Integral Gain (PID Control)
    private double derGain; // Derivative Gain (PID Control)
    private boolean revOut; // Switch the output direction of an axis
    private boolean enabled; // Enable or disable an axis
    private int minScale; // Set the max RETRACTION
    private int maxScale; // Set the max EXTENSION
    private int forcePos; // Override directional control and force axis to a specified extension
    private int powerDef; // Power On Default, when controller is turned on, immediately move actuators to specified extension
    private double velLimit; // Limit how fast a actuator can go
    
    // Constructor to set ALL DEFAULT values. 
    public Axis() {
        this.addr = -1;          // Indicates not set.
        this.axis = -1;          // Indicates not set.
        this.propGain = 0.0;     // Default value.
        this.intGain = 0.0;      // Default value.
        this.derGain = 0.0;      // Default value.
        this.revOut = false;     // Default value.
        this.enabled = true;     // Default value.
        this.minScale = 0;       // Default value.
        this.maxScale = 255;     // Default value.
        this.forcePos = 0;       // Default value.
        this.powerDef = 0;       // Default value.
        this.velLimit = 0;       // Default value.
    }
    // Constructor that takes addr and axis arguments.
    public Axis(int addr, int axis) {
        this.addr = addr;        // Sets based on input.
        this.axis = axis;        // Sets based on input.
        this.propGain = 0.0;     // Default value.
        this.intGain = 0.0;      // Default value.
        this.derGain = 0.0;      // Default value.
        this.revOut = false;     // Default value.
        this.enabled = true;     // Default value.
        this.minScale = 0;       // Default value.
        this.maxScale = 255;     // Default value.
        this.forcePos = 0;       // Default value.
        this.powerDef = 0;       // Default value.
        this.velLimit = 0;       // Default value.
    }
    
    // Define methods.
    public void setAddrAndAxis(int inputAddr, int inputAxis) {
        addr = inputAddr;
        axis = inputAxis;
    } // Mutator (Setter) changes value of a field.
    public int getAddr() {
        return addr;
    } // Accessor (Getter) only returns the value of a field.
    public int getAxis() {
        return axis;
    }
    
    public void setPropGain(double inputPropGain) {
        propGain = inputPropGain;
    }
    public double getPropGain() {
        return propGain;
    }
    
    public void setIntGain(double inputIntGain) {
        intGain = inputIntGain;
    }
    public double getIntGain() {
        return intGain;
    }
    
    public void setDerGain(double inputDerGain) {
        derGain = inputDerGain;
    }
    public double getDerGain() {
        return derGain;
    }
    
    public void setRevOut(boolean choice) {
        revOut = choice;
    }
    public boolean getRevOut() {
        return revOut;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public boolean getEnabled() {
        return enabled;
    }
    
    public void setMinScale(int minScale) {
        this.minScale = minScale;
    }
    public int getMinScale() {
        return minScale;
    }
    
    public void setMaxScale(int maxScale) {
        this.maxScale = maxScale;
    }
    public int getMaxScale() {
        return maxScale;
    }
    
    public void setForcePos(int forcePos) {
        this.forcePos = forcePos;
    }
    public int getForcePos() {
        return forcePos;
    }
    
    public void setPowerDef(int powerDef) {
        this.powerDef = powerDef;
    }
    public int getPowerDef() {
        return powerDef;
    }
    
    public void setVelLimit(double velLimit) {
        this.velLimit = velLimit;
    }
    public double getVelLimit() {
        return velLimit;
    }
    
    public void print() {
        System.out.printf("| %5d(%d) | ", getAddr(), getAxis());
        System.out.printf("%9.3f | ", getPropGain());
        System.out.printf("%8.3f | ", getIntGain());
        System.out.printf("%8.3f | ", getDerGain());
        System.out.printf("%7d | \n", getRevOut() ? 1 : 0);// TO DO CHANGE THIS TO SAY "YES" AND "NO"
    }
    
    public void printMainConf() {
        System.out.printf("| %5d(%d) | ", getAddr(), getAxis());
        System.out.printf("%9d | ", getMinScale());
        System.out.printf("%9d | ", getMaxScale());
        System.out.printf("%9d | ", getForcePos());
        System.out.printf("%9d | ", getPowerDef());
        System.out.printf("%9.2f |\n", getVelLimit());
    }
}
