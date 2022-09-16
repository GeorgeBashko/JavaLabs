import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task13ForListArray();
        //task13ForUsualArray();
        //task14ForUsualArray();
        //task14ForListArray();
        //task15ForUsualArray();
        //task15ForListArray();
    }

    /*
    public static void task1()
    {
        String[] array = new String[]{"a"};
        array[0] = "Monday";
        array[1] = "Tuesday";
        array[2] = "Wednesday";
        array[3] = "Thursday";
        array[4] = "Friday";
        array[5] = "Saturday";
        array[6] = "Sunday";
        System.out.println(array[6]);
    }public static void task2()
    {
        long x = 42L;
        float f = 42.0f;
        String[][]array = {{"a1","a2","a3","a4"},{"b1","b2","b3","b4"},{"c1","c2","c3","c4"}};
        for(String[] arr:array)
        {
            for(String s:arr)
            {
                System.out.println(s);
            }
        }
        float[] f1,f2;
        f1 = new float[3];
        f2 = f1;
        System.out.println();
    }     */
    public static void task13ForListArray() {
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 49; i++)
            values.add(i + 1);
        for (int i = 0; i < 6; i++) {
            int number = (int) (Math.random() * (48 - i)) + 1;
            answer.add(values.get(number));
            values.remove(number);
        }
        Collections.sort(answer);
        System.out.println("List array: " + answer);
        //System.out.println(values);
    }

    public static void task13ForUsualArray() {
        int[] answer = new int[6];
        int[] values = new int[49];
        for (int i = 0; i < 49; i++)
            values[i] = i + 1;
        for (int i = 0; i < 6; i++) {
            int number = (int) (Math.random() * (48 - i)) + 1;
            answer[i] = values[number];
            values = removeElement(number, values);
        }
        Arrays.sort(answer);
        System.out.println("Usual array: " + Arrays.toString(answer));
        //System.out.println(Arrays.toString(values));
    }

    public static int[] removeElement(int index, int[] array) {
        int[] answer1 = new int[array.length - 1];
        System.arraycopy(array, 0, answer1, 0, index);
        System.arraycopy(array, index + 1, answer1, index, array.length - index - 1);
        return answer1;
    }

    public static int task14ForUsualArray() {
        Scanner s = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        while (s.hasNextLine()) {
            String s1 = s.nextLine();
            if (s1.equals(""))
                break;
            arr.add(s1);
        }
        int k = 0;
        int[][] square = new int[arr.size()][];
        for (int i = 0; i < arr.size(); i++) {
            int[] arr1 = new int[arr.size()];
            String[] s2 = arr.get(i).split(" ");
            for (int j = 0; j < arr.size(); j++) {
                arr1[j] = (Integer.parseInt(s2[j]));
            }
            square[k++] = arr1;
        }
        int sum = 0;
        for (int i : square[0])
            sum += i;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                sum1 += square[i][j];
                sum2 += square[j][i];
            }
            for (int a = 0; a < square.length; a++) {
                sum3 += square[a][a];
                sum4 += square[a][square.length - a - 1];
            }
            if (sum1 != sum || sum2 != sum || sum3 != sum || sum4 != sum) {
                System.out.println("NO");
                return 0;
            }
            sum1 = 0;
            sum2 = 0;
            sum3 = 0;
            sum4 = 0;
        }
        System.out.println("YES");
        return 0;
    }

    public static int task14ForListArray() {
        Scanner s = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        while (s.hasNextLine()) {
            String s1 = s.nextLine();
            if (s1.equals(""))
                break;
            arr.add(s1);
        }
        ArrayList<ArrayList<Integer>> square = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            ArrayList<Integer> arr1 = new ArrayList<>();
            String[] s2 = arr.get(i).split(" ");
            for (int j = 0; j < arr.size(); j++) {
                arr1.add(Integer.parseInt(s2[j]));
            }
            square.add(arr1);
        }
        int sum = 0;
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int sum4 = 0;
        for (int i : square.get(0))
            sum += i;
        for (int i = 0; i < square.size(); i++) {
            for (int j = 0; j < square.size(); j++) {
                sum1 += square.get(i).get(j);
                sum2 += square.get(j).get(i);
            }
            for (int a = 0; a < square.size(); a++) {
                sum3 += square.get(a).get(a);
                sum4 += square.get(a).get(square.size() - a - 1);
            }
            if (sum1 != sum || sum2 != sum || sum3 != sum || sum4 != sum) {
                System.out.println("NO");
                return 0;
            }
            sum1 = 0;
            sum2 = 0;
            sum3 = 0;
            sum4 = 0;
        }
        System.out.println("YES");
        return 0;
    }

    public static int task15ForUsualArray() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        for (int[] row : triangle) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
        return 0;
    }

    public static int task15ForListArray() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<ArrayList<Integer>> treangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            for (int j = 1; j < i; j++) {
                arr.add(treangle.get(i - 1).get(j - 1) + treangle.get(i - 1).get(j));
            }
            if (i != 0) arr.add(1);
            treangle.add(arr);
        }
        for (ArrayList<Integer> arr1 : treangle) {
            for (int element : arr1) {
                System.out.printf("%4d", element);
            }
            System.out.println();
        }
        return 0;
    }

    public static int bigSum(int[][] theArray) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < theArray[0].length; i++) {
            sum1 += theArray[0][i];
        }
        for (int i = 0; i < theArray[1].length; i++) {
            sum2 += theArray[1][i];
        }
        return Math.max(sum1, sum2);
    }

    public static double averagePrice(double[] priceData) {

        double sum = 0.0;
        for (double i : priceData)
            sum += i;
        return sum / priceData.length;
    }

    public static int middleArray(int values[]) {

        return values[values.length % 2 == 1 ? values.length / 2 : values.length / 2 - 1];

    }

    public static int findValue(int values[], int valueToFind) {

        for (int i = 0; i < values.length; i++)
            if (values[i] == valueToFind)
                return i;
        return values.length;
    }

    public static int countOccurs(int[] theArray, int theInt) {
        int count = 0;
        for (int i : theArray)
            if (i == theInt) count++;
        return count;
    }

    public static int sumArray(int values[]) {
        int sum = 0;
        for (int i : values)
            sum += i;
        return sum;
    }

    public static double[] makeAverage(double[] test1, double[] test2) {
        double[] a = new double[test1.length];
        for (int i = 0; i < test1.length; i++)
            a[i] = (test1[i] + test2[i]) / 2;
        return a;
    }

    public static int testAverage(double[][] theArray, int numStudents) {
        int NUM_TESTS = 3;
        int count = 0;
        double sum = 0.0;
        for (double[] a : theArray) {
            for (double b : a)
                sum += b;
            if (sum / 3.0 < 70)
                count++;
            sum = 0;
        }
        return count;
    }

    public static ArrayList copyReverse(int[] anArray) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = anArray.length - 1; i >= 0; i--) {
            a.add(anArray[i]);
        }
        return a;
    }

    public static ArrayList copyArray(int[] anArray) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(anArray[0]);
        for (int i = 1; i < anArray.length; i++)
            if (!a.contains(anArray[i]))
                a.add(anArray[i]);
        return a;
    }

    public String separateWithCommas(int[] values) {
        String s1 = "";
        for (int i = 0; i < values.length - 1; i++)
            s1 += values[i] + ",";
        if (values.length > 0)
            s1 += values[values.length - 1];
        return s1;
    }

    public ArrayList<String> shortWords(String[] words) {
        ArrayList<String> a = new ArrayList<>();
        for (String i : words)
            if (i.length() <= 3)
                a.add(i);
        return a;
    }

    public String nthShortWord(String[] words, int n)
    {
        int count = 0;
        for (String i : words) {
            if (i.length() <= 3)
                count++;
            if(count == n)
                return i;
        }
        return "";
    }
    public void fillDiagonals()
    {




    }

}