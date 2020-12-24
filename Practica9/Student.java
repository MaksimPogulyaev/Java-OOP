final class Student implements Comparable<Student>
{
    private final String name;
    private final Integer IDNumber;

    Student(final String name, final int IDNumber)
    {
        this.name = name;
        this.IDNumber = IDNumber;
    }

    @Override
    public final int compareTo(final Student s)
    {
        return IDNumber.compareTo(s.getIDNumber());
    }

    final String getName()
    {
        return name;
    }

    final Integer getIDNumber()
    {
        return IDNumber;
    }
} 