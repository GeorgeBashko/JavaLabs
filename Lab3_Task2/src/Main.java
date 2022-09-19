import java.io.StringBufferInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EmptyConsoleDataException{
        System.out.println(DeleteBrackets(args));

    }
    public static StringBuilder DeleteBrackets (String[] input) throws EmptyConsoleDataException
    {
        if(input.length != 1) {
            System.out.println(input.length);
            throw new EmptyConsoleDataException("Error!The input array must contain only 1 element!");
        }
        StringBuilder inputString = new StringBuilder(input[0]);

        int OpenBracketPosition = -1;
        boolean ContainOpenBracket = false;
        for (int i = 0;i < inputString.length();i++)
        {
            if(inputString.charAt(i) == '(')
            {
                OpenBracketPosition = i;
                ContainOpenBracket = true;
            }
            if(inputString.charAt(i) == ')' && ContainOpenBracket)
            {
                inputString.delete(OpenBracketPosition,i + 1);
                i = OpenBracketPosition - 1;
                OpenBracketPosition = -1;
                ContainOpenBracket = false;
            }
        }
        return inputString;
    }
}