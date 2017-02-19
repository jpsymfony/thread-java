package question1;

public interface Command<T>
{
    public void make(T f);
}