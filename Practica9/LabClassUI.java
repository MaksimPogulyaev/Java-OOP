import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

final class LabClassUI
{
    final LabClass lc = new LabClass();

    final String titleOfFrame = "JAVATEST"; // for my window manager; ignore it, please
    final JFrame frameForMainMenu = new JFrame(titleOfFrame);
    final JFrame frameForCheck = new JFrame(titleOfFrame);
    final JFrame frameForSearch = new JFrame(titleOfFrame);

    final JPanel panelForCredentialsButtons = new JPanel(new FlowLayout());
    final JPanel panelForSortButton = new JPanel(new FlowLayout());
    final JPanel panelForNameCheckInput = new JPanel(new FlowLayout());
    final JPanel panelForNameSearchInput = new JPanel(new FlowLayout());
    final JPanel panelForIDNumberInput = new JPanel(new FlowLayout());

    final String textOfLabelForName = "name: ";
    final JLabel labelForNameCheck = new JLabel(textOfLabelForName);
    final JLabel labelForNameSearch = new JLabel(textOfLabelForName);
    final JLabel labelForIDNumber = new JLabel("id number:");

    final int columnsOfFieldForName = 16;
    final JTextField textFieldForNameCheck = new JTextField(columnsOfFieldForName);
    final JTextField textFieldForNameSearch = new JTextField(columnsOfFieldForName);
    final JTextField textFieldForIDNumber = new JTextField(8);

    final String textOfButtonForProceed = "proceed";
    final JButton buttonForOpenCheck = new JButton("check credentials");
    final JButton buttonForOpenSearch = new JButton("get student's id number");
    final JButton buttonForDoSort = new JButton("sort students by id numbers");
    final JButton buttonForDoCheck = new JButton(textOfButtonForProceed);
    final JButton buttonForDoSearch = new JButton(textOfButtonForProceed);

    Container pane = frameForMainMenu.getContentPane();

    boolean areStudentsSorted = false;

    LabClassUI()
    {
        frameForMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonForOpenCheck.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonForOpenCheck.addActionListener(actionOpenCheck);

        buttonForOpenSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonForOpenSearch.addActionListener(actionOpenSearch);

        buttonForDoCheck.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonForDoCheck.addActionListener(actionCheck);

        buttonForDoSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonForDoSearch.addActionListener(actionSearch);

        buttonForDoSort.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonForDoSort.addActionListener(actionSort);

        panelForCredentialsButtons.add(buttonForOpenCheck);
        panelForCredentialsButtons.add(buttonForOpenSearch);

        panelForSortButton.add(buttonForDoSort);

        panelForNameCheckInput.add(labelForNameCheck);
        panelForNameCheckInput.add(textFieldForNameCheck);

        panelForNameSearchInput.add(labelForNameSearch);
        panelForNameSearchInput.add(textFieldForNameSearch);

        panelForIDNumberInput.add(labelForIDNumber);
        panelForIDNumberInput.add(textFieldForIDNumber);

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(panelForCredentialsButtons);
        pane.add(panelForSortButton);

        frameForMainMenu.pack();

        pane = frameForCheck.getContentPane();

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(panelForNameCheckInput);
        pane.add(panelForIDNumberInput);
        pane.add(buttonForDoCheck);

        frameForCheck.pack();

        pane = frameForSearch.getContentPane();

        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        pane.add(panelForNameSearchInput);
        pane.add(buttonForDoSearch);

        frameForSearch.pack();

        frameForMainMenu.setVisible(true);
    }

    ActionListener actionOpenCheck = actionEvent -> frameForCheck.setVisible(true);

    ActionListener actionOpenSearch = actionEvent -> frameForSearch.setVisible(true);

    ActionListener actionCheck = actionEvent ->
    {
        try
        {
            lc.ProcessName(textFieldForNameCheck);
        }
        catch (BadStringException exception)
        {
            exception.printStackTrace();

            JOptionPane.showMessageDialog(frameForMainMenu, exception.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        try
        {
            lc.ProcessIDNumber(textFieldForIDNumber);
        }
        catch (BadStringException exception)
        {
            exception.printStackTrace();

            JOptionPane.showMessageDialog(frameForMainMenu, exception.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        int IDNumber;

        try
        {
            IDNumber = lc.GetIDNumberByName();
        }
        catch (StudentNotFoundException exception)
        {
            exception.printStackTrace();

            JOptionPane.showMessageDialog(frameForMainMenu, exception.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        String messagePrefix = "provided credentials are ";

        if (IDNumber != lc.GetCurrentIDNumber())
        {
            JOptionPane.showMessageDialog(frameForMainMenu, messagePrefix + "incorrect", "warning", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(frameForMainMenu, messagePrefix + "correct");
        }
    };

    ActionListener actionSearch = actionEvent ->
    {
        try
        {
            lc.ProcessName(textFieldForNameSearch);
        }
        catch (BadStringException exception)
        {
            exception.printStackTrace();

            JOptionPane.showMessageDialog(frameForMainMenu, exception.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        int IDNumber;

        try
        {
            IDNumber = lc.GetIDNumberByName();
        }
        catch (StudentNotFoundException exception)
        {
            exception.printStackTrace();

            JOptionPane.showMessageDialog(frameForMainMenu, exception.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

            return;
        }

        JOptionPane.showMessageDialog(frameForMainMenu, lc.GetCurrentName() + "'s id number: " + IDNumber);
    };

    ActionListener actionSort = actionEvent ->
    {
        if (areStudentsSorted)
        {
            JOptionPane.showMessageDialog(frameForMainMenu, "students are already sorted", "warning", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            lc.SortStudents();

            areStudentsSorted = true;

            JOptionPane.showMessageDialog(frameForMainMenu, "students have been sorted\n" +
                    "(check terminal for unsorted and sorted arrays)");
        }
    };
} 