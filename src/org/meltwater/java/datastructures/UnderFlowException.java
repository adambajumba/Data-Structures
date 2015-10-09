package org.meltwater.java.datastructures;

import javax.swing.JOptionPane;

/**
 *
 */
@SuppressWarnings("serial")
class UnderFlowException extends Exception {

    public UnderFlowException() {
        JOptionPane.showMessageDialog(null, "No elements in the array");
    }

}