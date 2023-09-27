import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class InputValidation extends JFrame {
    private JTable errorTable;
    private String errorMsg;

    private double amount;
    private String category;

    public InputValidation(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }
    public double getAmount(){
        return this.amount;
    }

    public boolean verifyAmount() {
        if (this.amount <= 0 || this.amount >= 1000) {
            this.errorMsg = "Invalid Amount Input";
            IllegalArgumentException msg = new IllegalArgumentException(this.errorMsg);
            viewMsg(this.errorMsg);
            throw msg;
        }
        return true;

    }

    public boolean verifyCategory() {
        if (!this.category.equals("food") && !this.category.equals("travel") && !this.category.equals("bills")
                && !this.category.equals("entertainment") && !this.category.equals("other")) {

            this.errorMsg = "Invalid Category Input";
            IllegalArgumentException msg = new IllegalArgumentException(this.errorMsg);
            viewMsg(this.errorMsg);
            throw msg;
        }
        return true;

    }

    public void viewMsg(String msg) {
        JFrame frame = new JFrame("Error Message!");
        JLabel label = new JLabel(msg);
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton closeErrorFrame = new JButton("Retry");
        closeErrorFrame.addActionListener(e -> {
            // Close the first frame
            frame.dispose();
        });
        
        panel.add(label);
        panel.add(closeErrorFrame);
        frame.add(panel);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.setVisible(true);

    }

}
