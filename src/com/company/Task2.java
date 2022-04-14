package com.company;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

public class Task2 {

    public static class myTask2{
        private String paymentNumber;
        private String date;
        private String amount;
        private String rewardAmount;
        private String totalAmountToDate;
        private String yearlyStakingReward;

        public myTask2(String paymentNumber, String date, String amount, String rewardAmount, String totalAmountToDate, String yearlyStakingReward) {
            this.paymentNumber = paymentNumber;
            this.date = date;
            this.amount = amount;
            this.rewardAmount = rewardAmount;
            this.totalAmountToDate = totalAmountToDate;
            this.yearlyStakingReward = yearlyStakingReward;
        }
        @Override
        public String toString(){
            return paymentNumber + "; " + date+ " ; " + amount + " ; " + rewardAmount + " ; " + totalAmountToDate + " ; " + yearlyStakingReward;
        }
    }
    public static Date addMonth(Date date, int i){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
    }
    public static String intToString (int ns){ // for get the output of our desired values
        String newString = ns + " ";
        return newString;
    }
    public static String doubleToString (double ss){
        String secondString = ss + " " ;
        return secondString;
    }
    public static String dateToString (Date date){
        String newDate;
        SimpleDateFormat rewardDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        newDate = rewardDateFormat.format(date);
        return newDate;
    }
    public static Double round (double a){
        a = (double) Math.round(a * 100) / 100;
        return a;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter START DATE by = Years - Month - Day  : yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNew = null;
        try {
            dateNew = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Investment Amount"); //double Amount = 25ETH ;
        double amount = scanner.nextDouble();
        System.out.println("Enter Yearly Staking Reward:"); //double yearlyRewardRate = 10 ;
        double yearlyRewardRate = scanner.nextDouble();
        double stakingRewardRate = yearlyRewardRate / 10/ 100;
        System.out.println("Enter the Line #");
        double fullRewardDate = scanner.nextDouble();
        double rewardAmount = (stakingRewardRate * amount * 30/365)/100;
        double totalInvestmentAmount = round(rewardAmount * amount);

        int paymentNumber = 0;
        double Payment = 0;
        double rewards;
        Date rewardDate;

        List<myTask2> arrayList = new ArrayList<>();
        for (int i = -1; i < fullRewardDate; i++){ //Count Numbers from Start to End, with including first investment  month
            paymentNumber++;
            rewardDate = addMonth(dateNew, i + 1);
            amount = round(amount + Payment);
            rewards = round(amount * stakingRewardRate);
            if (paymentNumber < fullRewardDate) {
                Payment = round(totalInvestmentAmount + rewards);

            }
            arrayList.add(new myTask2(intToString(paymentNumber),dateToString(rewardDate),doubleToString(amount),
                    doubleToString(Payment),doubleToString(totalInvestmentAmount),doubleToString(yearlyRewardRate)));
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Task2.csv"));
        String[] header = new String[]
                {
                "Line#", " Reward Date", " Investment Amount", " Reward Amount.", " Total Reward Amount To Date.", " Staking Reward Rate."
        };
        String head = String.join(";", header);// if I will write comma-separated inside CSV file it will be yellow text which is harder to understand :)
        bw.write(head);
        bw.newLine();
        for (Task2.myTask2 diagramTask2 : arrayList){
            bw.write(diagramTask2.toString());
            bw.newLine();
        }
        bw.close();
    }
}

