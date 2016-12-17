package com.modrons;

import javax.swing.WindowConstants;

public class AppMainTest {

    public static void main(String[] args) {
        AppMain app = new AppMain();

        app.init();

        app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        app.setVisible(true);
    }

}