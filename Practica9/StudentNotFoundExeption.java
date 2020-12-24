final class StudentNotFoundException extends RuntimeException
{
    StudentNotFoundException(final String errorMessage)
    {
        super(errorMessage);
    }
} 