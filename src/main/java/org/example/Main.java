package org.example;

import org.example.uc1.Feet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(2.0);
        System.out.println(f1.equals(f2));
    }
}
