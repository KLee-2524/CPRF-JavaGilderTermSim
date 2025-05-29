/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javagildertermsim;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author kaleblee
 */
public class JavaGilderTermSim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Define general variables
        Scanner scnr = new Scanner(System.in);
        ArrayList<Axis> axisList = new ArrayList<>();
        String option = "start";
        
        //Initialize axis details and add to axisList ArrayList. CHANGE LATER: do it with a loop.
        Axis axis0 = new Axis(7, 0);
        Axis axis1 = new Axis(8, 1);
        Axis axis2 = new Axis(9, 2);
        Axis axis3 = new Axis(10, 3);
        axisList.add(axis0);
        axisList.add(axis1);
        axisList.add(axis2);
        axisList.add(axis3);
        int workingAxis = 0; // Initialize workingAxis as axis 0 by default.
        
        //Start of AXIS TABLE page.
        //Output axis table. 
        printAxisTable(axis0, axis1, axis2, axis3);
        
        //Output Main Menu options
        printMainMenu(workingAxis, axisList);
        
        // Ask for first user input
        option = scnr.next();
        
        // Keep prompting for user inputs until user selects x for exit
        while (!option.equals("x")) {
            if (option.equals("s")) {
                System.out.print("Select axis to modify (0-3): ");
                int selectedAxis = scnr.nextInt();
                if ((selectedAxis >= 0) && (selectedAxis <= 3)) {
                    printAxisTable(axis0, axis1, axis2, axis3);
                    printMainMenu(selectedAxis, axisList);
                    workingAxis = selectedAxis;// Reassign the working axis to the selected axis
                }
                else { 
                    System.out.println("Invalid axis");
                    printAxisTable(axis0, axis1, axis2, axis3);
                    printMainMenu(workingAxis, axisList);
                }
                option = scnr.next();
            }
            else if (option.equals("1")) {// Toggle axis enabled
                for (Axis axis : axisList) {// Iterate through every axis in the axisList ArrayList to find the axis with a matching axis number
                    if (axis.getAxis() == workingAxis) {// When match is found, switch the enabled setting for that axis
                        if (axis.getEnabled()) {
                            axis.setEnabled(false);
                        }
                        else if (!axis.getEnabled()) {
                            axis.setEnabled(true);
                        }
                    }
                }
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("2")) {// Set prop gain
                System.out.print("Enter new prop gain value (0.500 - 10.000): ");// Prompt user to input a new proportional gain value
                try {
                    double inPropGain = scnr.nextDouble();
                    if ((inPropGain > 0.499) && (inPropGain < 10.0001)) {
                        for (Axis axis : axisList) {// Iterate through every axis in the axisList ArrayList to find the axis with a matching axis number
                            if (axis.getAxis() == workingAxis) {// When match is found, update the prop gain with user input
                                axis.setPropGain(inPropGain);
                            }
                        }
                        printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                    }
                    else {
                        System.out.println("Prop gain must be a value between 0.5 and 10.");
                        printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                    }
                }
                catch (InputMismatchException ime) {
                    System.out.println("Prop gain must be a value between 0.5 and 10.");
                    printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                    printMainMenu(workingAxis, axisList);
                    scnr.next();// previous print statement creates an extra instance that triggers this scnr object
                    option = scnr.next();
                }
            }
            else if (option.equals("3")) {// set int gain
                System.out.print("Enter new int gain value (0.500 - 1.500): ");// Prompt user to input a new proportional gain value
                try {
                    double inIntGain = scnr.nextDouble();
                    if ((inIntGain > 0.499) && (inIntGain < 1.5001)) {
                        for (Axis axis : axisList) {// Iterate through every axis in the axisList ArrayList to find the axis with a matching axis number
                            if (axis.getAxis() == workingAxis) {// When match is found, update the prop gain with user input
                                axis.setIntGain(inIntGain);
                            }
                        }
                        printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                    }
                    else {
                        System.out.println("Int gain must be a value between 0.5 and 1.5.");
                        printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                    }
                }
                catch (InputMismatchException ime) {
                    System.out.println("Int gain must be a value between 0.5 and 1.5.");
                    printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                    printMainMenu(workingAxis, axisList);
                    scnr.next();// previous print statement creates an extra instance that triggers this scnr object
                    option = scnr.next();
                }
            }
            else if (option.equals("4")) {// set der gain
                System.out.print("Enter new der gain value (0.500 - 1.500): ");// Prompt user to input a new proportional gain value
                try {
                    double inDerGain = scnr.nextDouble();
                    if ((inDerGain > 0.499) && (inDerGain < 1.5001)) {
                        for (Axis axis : axisList) {// Iterate through every axis in the axisList ArrayList to find the axis with a matching axis number
                            if (axis.getAxis() == workingAxis) {// When match is found, update the prop gain with user input
                                axis.setDerGain(inDerGain);
                            }
                        }
                        printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                    }
                    else {
                        System.out.println("Der gain must be a value between 0.5 and 1.5.");
                        printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                    }
                }
                catch (InputMismatchException ime) {// Catch invalid (non-numerical) input mismatch exceptions 
                    System.out.println("Der gain must be a value between 0.5 and 1.5.");
                    printAxisTable(axis0, axis1, axis2, axis3);// Refresh main menu and prompt user for input
                    printMainMenu(workingAxis, axisList);
                    scnr.next();// previous print statement creates an extra instance that triggers this scnr object
                    option = scnr.next();
                }
            }
            else if (option.equals("5")) {// rev out
                for (Axis axis : axisList) {// Iterate through every axis in the axisList ArrayList to find the axis with a matching axis number
                    if (axis.getAxis() == workingAxis) {// When match is found, switch the boolean revOut variable
                        if (axis.getRevOut()) {
                            axis.setRevOut(false);
                        }
                        else if (!axis.getRevOut()) {
                            axis.setRevOut(true);
                        }
                    }
                }
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("6")) {
                // compliance settings
                System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("7")) {
                // more PID options
                System.out.println("Need to verify functionality of this feature with Ryan or Enzo");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("k")) {
                // main conf.
                printMainConfTable(axis0, axis1, axis2, axis3);
                printMainConfMenu(workingAxis, axisList);
                String mainConfOption = scnr.next();
                while (!mainConfOption.equals("x")) {
                    if (mainConfOption.equals("s")) {
                        System.out.print("Select axis to modify (0-3): ");
                        try {
                            int selectedAxis = scnr.nextInt();
                            if ((selectedAxis >= 0) && (selectedAxis <= 3)) {
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(selectedAxis, axisList);
                                workingAxis = selectedAxis;
                            }
                            else { 
                                System.out.println("Invalid axis");
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(workingAxis, axisList);
                            }
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("Invalid axis");
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                        }
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("1")) {// Set minimum range //TODO ensure min cannot be greater than max scale
                        System.out.print("Enter new minimum scale value (0 - 255): ");
                        try {
                            int inMinScale = scnr.nextInt();
                            if ((inMinScale > 0) && (inMinScale < 255)) {
                                for (Axis axis : axisList) {
                                    if (axis.getAxis() == workingAxis) {
                                        axis.setMinScale(inMinScale);
                                    }
                                }
                            }
                            else {
                                System.out.println("MinScale must be a number from 0 - 255.");
                                delay(2000);
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(workingAxis, axisList);
                                mainConfOption = scnr.next();
                            }
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("MinScale must be a number from 0 - 255.");
                            delay(2000);
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                    }
                    else if (mainConfOption.equals("2")) {// Set maximum range //TODO ensure max cannot be less than min scale
                        System.out.print("Enter new maximum scale value (0 - 255): ");
                        try {
                            int inMaxScale = scnr.nextInt();
                            if ((inMaxScale > 0) && (inMaxScale < 255)) {
                                for (Axis axis : axisList) {
                                    if (axis.getAxis() == workingAxis) {
                                        axis.setMaxScale(inMaxScale);
                                    }
                                }
                            }
                            else {
                                System.out.println("MaxScale must be a number from 0 - 255.");
                                delay(2000);
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(workingAxis, axisList);
                                mainConfOption = scnr.next();
                            }
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("MaxScale must be a number from 0 - 255.");
                            delay(2000);
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                    }
                    else if (mainConfOption.equals("3")) {// Force output to value
                        System.out.print("Enter value to force actuator position (0 - 255): ");
                        try {
                            int inForcePos = scnr.nextInt();
                            if ((inForcePos > 0) && (inForcePos < 255)) {
                                for (Axis axis : axisList) {
                                    if (axis.getAxis() == workingAxis) {
                                        axis.setForcePos(inForcePos);
                                    }
                                }
                            }
                            else {
                                System.out.println("Position must be a number from 0 - 255.");
                                delay(2000);
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(workingAxis, axisList);
                                mainConfOption = scnr.next();
                            }
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("Position must be a number from 0 - 255.");
                            delay(2000);
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                    }
                    else if (mainConfOption.equals("4")) {// Set PowerOn Default
                        System.out.print("Enter PowerOn Default value (0 - 255): ");
                        try {
                            int inPowerDef = scnr.nextInt();
                            if ((inPowerDef > 0) && (inPowerDef < 255)) {
                                for (Axis axis : axisList) {
                                    if (axis.getAxis() == workingAxis) {
                                        axis.setPowerDef(inPowerDef);
                                    }
                                }
                            }
                            else {
                                System.out.println("Position must be a number from 0 - 255.");
                                delay(2000);
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(workingAxis, axisList);
                                mainConfOption = scnr.next();
                            }
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("Position must be a number from 0 - 255.");
                            delay(2000);
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                    }
                    else if (mainConfOption.equals("5")) {// Set Velocity Limit
                        System.out.print("Enter new velocity limit value (0.00 - 10.00): ");
                        try {
                            double inVelLimit = scnr.nextDouble();
                            if ((inVelLimit > -0.01) && (inVelLimit < 10.01)) {
                                for (Axis axis : axisList) {
                                    if (axis.getAxis() == workingAxis) {
                                        axis.setVelLimit(inVelLimit);
                                    }
                                }
                            }
                            else {
                                System.out.println("VelLimit must be between 0.00 - 10.00.");
                                delay(2000);
                                printMainConfTable(axis0, axis1, axis2, axis3);
                                printMainConfMenu(workingAxis, axisList);
                                mainConfOption = scnr.next();
                            }
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                        catch (InputMismatchException ime) {
                            System.out.println("VelLimit must be between 0.00 - 10.00.");
                            delay(2000);
                            printMainConfTable(axis0, axis1, axis2, axis3);
                            printMainConfMenu(workingAxis, axisList);
                            mainConfOption = scnr.next();
                        }
                    }
                    else if (mainConfOption.equals("6")) {// Network Settings
                        System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                        delay(2000);
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("k")) {// Feedback conf
                        printAxisTable(axis0, axis1, axis2, axis3);
                        printMainMenu(workingAxis, axisList);
                        option = scnr.next();
                        break;// End the mainConf while loop
                    }
                    else if (mainConfOption.equals("n")) {// Next
                        if (workingAxis == 3) {
                            workingAxis = 0;
                        }
                        else {
                            workingAxis = workingAxis + 1;
                        }
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("l")) {// Last
                        if (workingAxis == 0) {
                            workingAxis = 3;
                        }
                        else {
                            workingAxis = workingAxis - 1;
                        }
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("i")) {// Info
                        System.out.println("In GilderTerm, this is would open a table representing the current state of each mechanism actuator.");
                        System.out.println("This gives the operator a conceptual understanding of mechanism positions.");
                        System.out.println();
                        System.out.println("By: Kaleb Lee");
                        System.out.println("Inspired By: Shawn Keelin");
                        delay(2000);
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("o")) {// def.
                        System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                        delay(2000);
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("g")) {// Loop
                        System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                        delay(2000);
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else if (mainConfOption.equals("h")) {// Halt
                        System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                        delay(2000);
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                    else {// Notify user if the user enters an invalid input, then refresh the page
                        System.out.println("Invalid option.");
                        delay(2000);
                        printMainConfTable(axis0, axis1, axis2, axis3);
                        printMainConfMenu(workingAxis, axisList);
                        mainConfOption = scnr.next();
                    }
                }
                if (mainConfOption.equals("x")) {// Setting mainConfOption to "x" will exit the above while loop, this detects that mainConfOption is x and also sets option to "x" to completely exit the program
                    option = "x";
                }
            }
            else if (option.equals("n")) {// next
                if (workingAxis == 3) {
                    workingAxis = 0;
                }
                else {
                    workingAxis = workingAxis + 1;
                }
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("l")) {// last
                if (workingAxis == 0) {
                    workingAxis = 3;
                }
                else {
                    workingAxis = workingAxis - 1;
                }
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("i")) {
                // info
                System.out.println("In GilderTerm, this is would open a table representing the current state of each mechanism actuator.");
                System.out.println("This gives the operator a conceptual understanding of mechanism positions.");
                System.out.println();
                System.out.println("By: Kaleb Lee");
                System.out.println("Inspired By: Shawn Keelin");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("o")) {
                // def
                System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("g")) {
                // loop
                System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else if (option.equals("h")) {
                // halt
                System.out.println("This feature is out of scope for this simulator. Returning to main menu.");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
            else {// Notify user if the user enters an invalid input, then refresh the page
                System.out.println("Invalid option.");
                delay(2000);
                printAxisTable(axis0, axis1, axis2, axis3);
                printMainMenu(workingAxis, axisList);
                option = scnr.next();
            }
        }
        
    }
    
    public static void printMainMenu(int workingAxis, ArrayList<Axis> axisList) {
        String axisEnabled = null;
        for (Axis axis : axisList) {// Iterate through every axis in axisList to find which axis is active
            if (axis.getAxis() == workingAxis) {
                if (axis.getEnabled()) {// Find if working axis is enable and display accordingly
                    axisEnabled = "Enabled";
                }
                else if (!axis.getEnabled()) {
                    axisEnabled = "Disabled";
                }
            }
        }
        
        System.out.println();
        System.out.println("a) Card Address: 1"); //change later to accept and display a variable.
        System.out.println("c) First Channel: 6"); //change later.
        System.out.println("d) Resolution: 8-bit");
        System.out.println("e) DMX: Rx w/CS");
        System.out.println("f) 1-based");
        System.out.println();
        
        System.out.println("s) axis to modify: " + workingAxis); 
        System.out.println("1) Axis " + workingAxis + ": " + axisEnabled); //change to accept variable for enable.
        System.out.println("2) Set proportional gain");
        System.out.println("3) Set integral gain");
        System.out.println("4) Set derivative gain");
        System.out.println("5) Reverse Axis Output");
        System.out.println("6) Compliance Settings");
        System.out.println("7) More PID Options");
        System.out.println();
        
        System.out.println("k) main conf, n) Next, l) Last, i) Info, o) def., g) Loop, h) Halt, x) eXit");
        System.out.print("Please make your selection: ");
        //End of AXIS TABLE page.
    }
    
    public static void printMainConfMenu(int workingAxis, ArrayList<Axis> axisList) {
        System.out.println();
        System.out.println("a) Card Address: 1"); //change later to accept and display a variable.
        System.out.println("c) First Channel: 6"); //change later.
        System.out.println("d) Resolution: 8-bit");
        System.out.println("e) DMX: Rx w/CS");
        System.out.println("f) 1-based");
        System.out.println();
        
        System.out.println("s) axis to modify: " + workingAxis);
        System.out.println("1) Set minimum range");
        System.out.println("2) Set maximum range");
        System.out.println("3) Force output to value");
        System.out.println("4) Set PowerOn Default");
        System.out.println("5) Set Velocity Limit");
        System.out.println("6) Network Settings");
        System.out.println();
        
        System.out.println("k) Feedback conf, n) Next, l) Last, i) Info, o) def., g) Loop, h) Halt, x) eXit");
        System.out.print("Please make your selection: ");
        //End of AXIS TABLE page.
    }
    
    public static void printAxisTable(Axis axis0, Axis axis1, Axis axis2, Axis axis3) {
        System.out.println();
        System.out.println("********************************************************");
        System.out.println();
        System.out.println("| DMX Addr | Prop Gain | Int Gain | Der Gain | Rev Out |");
        axis0.print();
        axis1.print();
        axis2.print();
        axis3.print();
    }
    
    public static void printMainConfTable(Axis axis0, Axis axis1, Axis axis2, Axis axis3) {
        System.out.println();
        System.out.println("************************************************************************");
        System.out.println();
        System.out.println("| DMX Addr | Min Scale | Max Scale | Force Pos | Power Def | Vel Limit |");
        axis0.printMainConf();
        axis1.printMainConf();
        axis2.printMainConf();
        axis3.printMainConf();
    }
    
    public static void delay(int milliseconds) {// Create delay method
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}