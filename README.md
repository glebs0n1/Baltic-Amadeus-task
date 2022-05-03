# Baltic-Amadeus-task
Baltic Amadeus entry Software Engineer task - Ethereum Staking profit schedule

Ethereum Staking is a process that will allow Ethereum (ETH) blockchain to validate transactions using a proof-of-stake consensus
mechanism. This will replace proof-of-work consensus which requires a lot of computing power and energy to work. Imagine you are a
developer who works at a cryptocurrency exchange and you received a task to write a simplified Ethereum Staking profit calculator
Input data you receive are:
Initial investment amount of ETH (e.g. 10 ETH);
Yearly staking reward rate in % (e.g. 7%);
Staking start date (e.g. 2020-11-10);
Staking duration (e.g. 24 months);
Reward payment day (e.g. every 15th day of the month)
Yes/No option if the customer decides to reinvest staking rewards once they receive them or not (e. g. yes)
After you receive input data, your program must generate an Ethereum Staking monthly profit schedule. A comma-separated (.
csv) file where each line shows monthly rewards starting from the staking start date. Each line must provide data below: 
Line (Reward) number for each time customer receives it;
Reward date when the customer received it;
Investment amount at that time;
Reward amount for a specific month;
Total reward amount received so far;
Yearly staking reward rate.
To calculate the reward amount for a specific month, use 'Actual/365' day count convention method that is popularly used in calculating
interest amounts for loans. More information can be found here. An example of described profit schedule is attached: example_schedule
.xlsx. Note: For your task, you don't have to display input data values in your output .csv file

Main Task

In 2019-04-15 customer started to stake 25 ETH and plans to do it for the next 2 years
Cryptocurrency exchange also offers a 10% yearly reward rate
Cryptocurrency exchange provides monthly staking rewards every 23rd day of the month
Customer decided to reinvest the staking rewards on the same day when they are provided.
Your task:
Figure out an algorithm to calculate staking rewards;
Calculate an Ethereum Staking profit schedule using provided input data;
Generate output .csv file to display profit schedule. All columns shown in the example must be present.

Bonus Task 1

The input data from Task 1 is the same, but starting from 2020-04-15 cryptocurrency exchange decided that yearly reward
rates will be lowered to 8% from initial 10%
Your task:
Calculate an additional Ethereum Staking profit schedule where described reward rate adjustment is included;
Generate output .csv file to display profit schedule. All columns shown in the example must be present.

Bonus Task 2

Write a program that allows entering input data described above;<br>
![WowGIF](https://user-images.githubusercontent.com/57506521/166418503-daba103a-e0cc-43ed-9aad-6ef3a097a990.gif)

