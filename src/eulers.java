/**
 * Created by Tom on 11/03/14.
 */

import bsh.Interpreter;

import javax.swing.*;
import java.io.*;

public class eulers{
    static ByteArrayOutputStream os = new ByteArrayOutputStream();
    static PrintStream ps = new PrintStream(os);

    static Interpreter bsh = new Interpreter();

    static double x;
    static double y;
    static double h;
    static double finalX;
    static String function;

    static double slope = 0;
    static double answer = 0;

    static double i;

    static boolean noError;



    public static void setParameters(double a, double b, double c, double d, String e) {
        x = a;
        y = b;
        h = c;
        finalX = d;
        function = e;

    }

    public static void euler(){
        if((int)((finalX-x)%h) == 0){
                for(i = x; i < finalX; i += h){
                    try{
                        if(noError){
                            bsh.setOut(ps);  //Set output stream so data can be printed then read

                            bsh.set("x", i); //Set x and y values from textFields
                            bsh.set("y", y);
                            bsh.set("e", 2.718281828);
                            bsh.set("answer", bsh.eval(function)); //Find slope value

                            bsh.print(bsh.get("answer")); //print slope value to output stream to be retrieved later

                            slope = Double.parseDouble(os.toString()); //retrieve slope value from output stream

                            ps.flush(); //Reset output streams for next iteration
                            os.reset();
                        }

                    }catch(Exception e){
                        System.out.println("Error: " + e);
                        noError = false;
                        JOptionPane.showMessageDialog(null, "ERROR: " + e);
                        i = finalX;
                    }
                    answer = y + h*slope;
                    y = answer;
                }
        }
    }
}

