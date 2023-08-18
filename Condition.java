import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class Condition
{

    public static void main(String[] args)
    {
         Scanner scan = new Scanner(System.in);



        String[] Months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"};
        double[] Dealer1 = {22000.00,330000.00,44000.00,89000.00,150000.00,250000.00,31000.00,84000.00 };
        double[] Dealer2 = {65000.00,95000.00,88000.99,53000.55,31000.00,65500.00,98000.00,74000.00};
        double[] Dealer3 = {55000.00,15000.00,96000.00,98000.00,88000.00,85000.00,65000.00,44000.00};
        int[] Customers = {0,0,0,0,0,0,0,0};
        double[] TotalSales = {0,0,0,0,0,0,0,0};

        populateCustomers(Customers);
        int option;

        do{
            option = getUserOption();
            switch(option){
                case 1:
                    double Dealer1Total = determineDealerTotals(Dealer1);
                    double Dealer2Total = determineDealerTotals(Dealer2);
                    double Dealer3Total = determineDealerTotals(Dealer3);
                    int CustomerTotal =  determineTotalCust(Customers);//check this pat
                    double salesTotal = determineDealerTotals(TotalSales);

                    displayDealerDetails(Dealer1, Dealer2, Dealer3, Customers, Months, TotalSales, Dealer1Total, Dealer2Total, Dealer3Total, CustomerTotal, salesTotal);
                    break;
                case 2:
                    System.out.println("Enter a month you want to check highest sales 1 - 6");
                    int iMonth = scan.nextInt();
                    String results = determineHighestDealerSales(Dealer1, Dealer2,Dealer3, iMonth);
                    System.out.println(results);
                    break;
                case 3:
                    System.out.println("Good bye!!");
                    break;
                default:
                    System.out.println("Invalid option!!!");
            }
        }while(option < 1 || option > 3);
    }

    public static void populateCustomers(int[] p_Customers)
    {
        Random randy = new Random();
        for(int x=0; x<p_Customers.length; x++)
        {
            p_Customers[x] = randy.nextInt(3000)+20;
        }
    }
    public static int getUserOption()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select any option to start:");
        System.out.println("\t1 Display all dealerships");
        System.out.println("\t2 Display dealership with sales");
        System.out.println("\t3 Exit");
        int answer = scan.nextInt();
        return answer;
    }
    public static double determineDealerTotals(double[] p_dealerArray)
    {
        double answer=0.0;
        for(int x=0; x<p_dealerArray.length; x++)
        {
            answer += p_dealerArray[x];
        }
        return answer;
    }
    public static int determineTotalCust (int[] p_Customers)
    {
        int TotalCust =0;
        for(int x =0; x<p_Customers.length; x++)

        {
            TotalCust += p_Customers[x];
        }
        return TotalCust;
    }
    public static void calcTotalSales(double [] p_Dealer1, double[] p_Dealer2,double[] p_Dealer3, double[] p_TotalSales)
    {
        for(int x=0; x<p_Dealer1.length; x++)
        {
            p_TotalSales[x] = (p_Dealer1[x] + p_Dealer1[x] + p_Dealer1[x]);
        }
    }
    public static String determineHighestDealerSales(double[] p_Dealer1, double[] p_Dealer2,double[] p_Dealer3, int month)
    {
        DecimalFormat deci = new DecimalFormat("####.00");

        String results = null;
        if(p_Dealer1[month] > p_Dealer2[month] && p_Dealer1[month] > p_Dealer3[month])
        {
            results = "Highest selling dealer for Month"+month+": Dealer 1(R"+deci.format(p_Dealer1[month])+")";
        }
        else if(p_Dealer2[month] > p_Dealer1[month] && p_Dealer2[month] > p_Dealer3[month])
        {
            results = "Highest selling dealer for Month"+month+": Dealer 2(R"+deci.format(p_Dealer2[month])+")";
        }
        else if(p_Dealer3[month] > p_Dealer1[month] && p_Dealer3[month] > p_Dealer2[month])
        {
            results = "Highest selling dealer for Month"+month+": Dealer 3(R"+deci.format(p_Dealer3[month])+")";
        }
        return results;
    }
    public static void displayDealerDetails(double[] p_Dealer1,double[] p_Dealer2,double[] p_Dealer3,int[] p_Customers,String[] p_Months,double[] p_TotalSales,double dealer1Total,double dealer2Total,double dealer3Total, int TotalCust, double salesTotal)
    {
        DecimalFormat deci = new DecimalFormat("####.00");

        System.out.println("Month\tDealer 1t\tDealer 2t\tDealer 3\tCustomers\tTotal Sales");
        for(int x=0; x<p_Dealer1.length; x++)
        {
            System.out.println(p_Months[x]+"\t"+deci.format(p_Dealer1[x])+"\t"+deci.format(p_Dealer2[x])+"\t"+deci.format(p_Dealer3[x])+"\t"+p_Customers[x]+"\t"+deci.format(p_TotalSales[x]));
        }
        System.out.println("==============================================================");
        System.out.println("\t\t"+deci.format(dealer1Total)+"\t"+deci.format(dealer2Total)+"\t"+deci.format(dealer3Total)+"\t"+TotalCust+"\t"+deci.format(salesTotal));
    }
}
