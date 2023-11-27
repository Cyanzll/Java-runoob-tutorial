package package01;

public class NotHumanNameException extends Exception{
    public String toString() {
        return "Not an expected name of a human.";
    }
}
