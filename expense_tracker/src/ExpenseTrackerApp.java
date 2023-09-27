import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {

    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");

    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      double amount = 0.0;
      String category = null;
      boolean exceptionCaught = false;

      // Get transaction data from view
      try {
        amount = view.getAmountField();
        category = view.getCategoryField();

      } catch (NumberFormatException i) {
        exceptionCaught = true;
        InputValidation test = new InputValidation(0, null);
        test.viewMsg("Invalid Type For Amount");

      }

      if (!exceptionCaught) {
        InputValidation validation = new InputValidation(amount, category);

        if (validation.verifyAmount() && validation.verifyCategory()) {
          // Create transaction object
          Transaction t = new Transaction(amount, category);

          // Call controller to add transaction
          view.addTransaction(t);

        }

      }

    });

  }

}