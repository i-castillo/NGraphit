/* Runs the program through Java Swing. */

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class NGraphit{
	public static void main(String[] args){

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				NGraphitDisplay.createAndShowGUI();

			}
		});

	}

}
