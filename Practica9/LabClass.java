import javax.swing.*;
import java.util.Scanner;

final class LabClass
{
    private final int amountOfEntries = 5;
    private final Student[] students;

    private String currentName;
    private int currentIDNumber;

    LabClass()
    {
        students = new Student[amountOfEntries];

        final int[] arrayOfIDNumbers = arrayOfRandomIDNumbers(11111, 99999);

        for (int i = 0; i < amountOfEntries; ++i)
        {
            students[i] = new Student("student" + i, arrayOfIDNumbers[i]);
        }

        PrintStudents("");
    }

    final int GetCurrentIDNumber()
    {
        return currentIDNumber;
    }

    final String GetCurrentName()
    {
        return currentName;
    }

    final void SortStudents()
    {
        PrintStudents("unsorted");

        new QuickSortByIDNumber().doSort(students);

        PrintStudents("sorted");
    }

    final int GetIDNumberByName()
    {
        int IDNumber = -1;

        for (Student s : students)
        {
            if (s.getName().equals(currentName))
            {
                IDNumber = s.getIDNumber();
                break;
            }
        }

        if (IDNumber == -1)
        {
            throw new StudentNotFoundException("student \"" + currentName + "\" does not exist");
        }

        return IDNumber;
    }

    final void ProcessName(final JTextField textField)
    {
        Scanner scannerOfField = new Scanner(textField.getText());

        if (!scannerOfField.hasNextLine())
        {
            throw new BadStringException("name is empty");
        }

        currentName = scannerOfField.nextLine();

        scannerOfField.close();
    }

    void ProcessIDNumber(final JTextField textField)
    {
        try (Scanner scannerOfField = new Scanner(textField.getText()))
        {
            if (!scannerOfField.hasNextLine())
            {
                throw new BadStringException("id number is empty");
            }

            try
            {
                currentIDNumber = Integer.parseInt(scannerOfField.nextLine());
            }
            catch (NumberFormatException exception)
            {
                throw new BadStringException("id number format is incorrect");
            }
        }
    }

    private void PrintStudents(final String prefix)
    {
        System.out.println();

        if (!prefix.equals(""))
        {
            System.out.print(prefix + " ");
        }

        System.out.print("students:");

        for (int i = 0; i < 2; ++i)
        {
            System.out.println();
        }

        for (Student s : students)
        {
            System.out.println("\tname: " + s.getName());
            System.out.println("\tID number: " + s.getIDNumber());
            System.out.println();
        }

        System.out.println();
    }

    private int[] arrayOfRandomIDNumbers(final int minIDNumber, final int maxIDNumber)
    {
        int[] array = new int[amountOfEntries];

        for (int i0 = 0; i0 < amountOfEntries; ++i0)
        {
            int IDNumber = 0;
            boolean isIDNumberOriginal = false;

            while (!isIDNumberOriginal)
            {
                IDNumber = (int)(Math.random() * ((maxIDNumber - minIDNumber) + 1) + minIDNumber);

                isIDNumberOriginal = true;

                for (int i1 : array)
                {
                    if (IDNumber == i1)
                    {
                        isIDNumberOriginal = false;
                        break;
                    }
                }
            }

            array[i0] = IDNumber;
        }

        return array;
    }
}