package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

public class Task1 {

    public static class myTask1 {
        private String paymentNumber;
        private String date;
        private String amount;
        private String rewardAmount;
        private String totalAmountToDate;
        private String yearlyStakingReward;

        public myTask1(String paymentNumber, String date, String amount, String rewardAmount, String totalAmountToDate, String yearlyStakingReward) {
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
        String datedate = "2019-04-15 ";
        String newDate = "2020-04-15 ";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNew = null;
        try {
            dateNew = dateFormat.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        double amount = 25;
        double amountThisDate = 28.3;
        double yearlyRewardRate = 10;
        double yearlyRewardRateNew = 8;

        double stakingRewardRate = yearlyRewardRate / 10 / 100;
        double stakingRewardRateNew = yearlyRewardRateNew / 8/ 100;

        double fullRewardDate = 24-12;

        double rewardAmount = (stakingRewardRateNew * amountThisDate * 30/365)/100;
        double totalInvestmentAmount = round(rewardAmount * amountThisDate);
        int paymentNumber = 0;
        double Payment = 0;
        double rewards;
        Date rewardDate;
        List<myTask1> arrayList = new ArrayList<>();

        for (int i =-1 ; i < fullRewardDate; i++){ //Count Numbers from Start to End, with including first month : 2020-04-15

            paymentNumber++;
            rewardDate = addMonth(dateNew, i + 1);
            amountThisDate = round(amountThisDate + Payment);
            rewards = round(amountThisDate * stakingRewardRateNew);
            if (paymentNumber < fullRewardDate) {
                Payment = round(totalInvestmentAmount + rewards);
            }
            arrayList.add(new myTask1(intToString(paymentNumber),dateToString(rewardDate),doubleToString(amountThisDate),
                    doubleToString(Payment), doubleToString(totalInvestmentAmount),doubleToString(yearlyRewardRateNew)));
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Task1.csv"));
        String[] header = new String[]{"Line#", " Reward Date", " Investment Amount", " Reward Amount.", " Total Reward Amount To Date.", " Staking Reward Rate."
        };
        String head = String.join(";", header);// if i write comma-separated inside CSV file it will be yellow text which is harder to understand :)
        bw.write(head);
        bw.newLine();
        for (Task1.myTask1 diagram : arrayList){
            bw.write(diagram.toString());
            bw.newLine();
        }
        bw.close();
    }
}

