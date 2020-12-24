import java.util.Comparator;

final class QuickSortByIDNumber implements Comparator<Student>
{
    final void doSort(final Student[] array)
    {
        doSort(array, 0, array.length - 1);
    }

    final void doSort(final Student[] array, final int indexOfFirstElement, final int indexOfLastElement)
    {
        if (indexOfFirstElement < indexOfLastElement)
        {
            int indexOfSplit = split(array, indexOfFirstElement, indexOfLastElement);

            doSort(array, indexOfFirstElement, indexOfSplit - 1);
            doSort(array, indexOfSplit + 1, indexOfLastElement);
        }
    }

    @Override
    public final int compare(final Student s0, final Student s1)
    {
        return s0.getIDNumber().compareTo(s1.getIDNumber());
    }

    private void swap(final Student[] array, final int indexOfElement0, final int indexOfElement1)
    {
        Student temp = array[indexOfElement0];
        array[indexOfElement0] = array[indexOfElement1];
        array[indexOfElement1] = temp;
    }

    private int split(final Student[] array, final int indexOfFirstElement, final int indexOfLastElement)
    {
        final Student keyElement = array[indexOfLastElement];

        int indexOfTempElement0 = indexOfFirstElement - 1;

        for (int indexOfTempElement1 = indexOfFirstElement; indexOfTempElement1 < indexOfLastElement; ++indexOfTempElement1)
        {
            if (compare(array[indexOfTempElement1], keyElement) < 0)
            {
                indexOfTempElement0++;

                swap(array, indexOfTempElement0, indexOfTempElement1);
            }
        }

        swap(array, indexOfTempElement0 + 1, indexOfLastElement);

        return indexOfTempElement0 + 1;
    }
}