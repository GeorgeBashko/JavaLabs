public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2)
                throw new IllegalArgumentException();
            try {
                double x = Double.parseDouble(args[0]);
                double toch = Double.parseDouble(args[1]);
                double cur = -1 * (4.0 / 3 * 4.0 / 3) * x * x,sum = 0;
                int k = 0;
                while (Math.abs(cur) > toch) {
                    sum += cur *= (-1) * Math.pow(4.0 / 3, 4) / (2 * k + 2) / (2 * k + 3);
                    k++;
                }
                System.out.println(sum);
            } catch (NumberFormatException e){System.out.println("You entered not a number!");}
        }
        catch(IllegalArgumentException e){System.out.println("Input must contain only two numbers!");}
    }
}