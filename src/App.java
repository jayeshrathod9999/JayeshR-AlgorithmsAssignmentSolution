import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner userInput = new Scanner(System.in);

        int j = 0;
        double key = 0;
        boolean flag = false;
        boolean temp = true;
        int noOfCompanies = 0;
        System.out.println("Enter No Of Companies : ");
        noOfCompanies = userInput.nextInt();

        double[] stockPricesOfCompany = new double[noOfCompanies];
        boolean[] stockPricesRose = new boolean[noOfCompanies];

        System.out.println("Enter current stock price of company : ");
        for (int i = 0; i < noOfCompanies; i++) {
            stockPricesOfCompany[i] = userInput.nextDouble();
        }

        System.out.println("Whether companies stock price rose today ?(if Yes Enter True else False)");
        for (int i = 0; i < noOfCompanies; i++) {
            stockPricesRose[i] = userInput.nextBoolean();
        }

        MergeSortArray(stockPricesOfCompany, 0, noOfCompanies - 1);

        while (temp) {
            System.out.println(
                    "Enter the operation that you want to perform \n 1. Display the companies stock prices in ascending order \n 2. Display the companies stock prices in descending order \n 3. Display the total no of companies for which stock prices rose today \n 4. Display the total no of companies for which stock prices declined today \n 5. Search a specific stock price \n 6. press 0 to exit \n ");
            int choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Stock prices in ascending order are :");
                    for (int i = noOfCompanies - 1; i > -1; i--) {
                        System.out.print(stockPricesOfCompany[i] + " ");
                    }
                    break;

                case 2:
                    System.out.println("Stock prices in descending order are :");
                    for (int i = 0; i < noOfCompanies; i++) {
                        System.out.print(stockPricesOfCompany[i] + " ");
                    }
                    break;

                case 3:
                    System.out.println("No of companies which stock price rose today : ");
                    for (j = 1; j < noOfCompanies && stockPricesRose[j] == true; j++)
                        ;
                    System.out.print(j);
                    break;

                case 4:
                    System.out.println("No of companies which stock price declined today : ");
                    System.out.println(noOfCompanies - j);
                    break;

                case 5:
                    System.out.println("Enter stock price to search : ");
                    key = userInput.nextDouble();
                    for (int i = 0; (i < noOfCompanies) && (stockPricesOfCompany[i] == key); i++)
                        flag = true;
                    if (flag)
                        System.out.println("Stock price found !");
                    else
                        System.out.println("Stock price not found !");
                    break;

                default:
                    System.out.println("To Exit Enter : false /n To Continue Enter : true");
                    temp = userInput.nextBoolean();
                    if (!temp)
                        System.out.println("Exited Successfully.");
                    break;

            }
        }

        userInput.close();

    }

    public static void MergeSortArray(double[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            MergeSortArray(arr, first, mid);
            MergeSortArray(arr, mid + 1, last);
            Merge(arr, first, mid, last);
        }
    }

    private static void Merge(double[] arr, int first, int mid, int last) {

        int len1 = mid - first + 1;
        int len2 = last - mid;

        double[] leftArray = new double[len1];
        double[] rightArray = new double[len2];

        for (int i = 0; i < len1; i++) {
            leftArray[i] = arr[first + i];
        }
        for (int j = 0; j < len2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = first;
        while ((i < len1) && (j < len2)) {
            if (leftArray[i] >= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while (j < len2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        while (i < len1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

    }
}
