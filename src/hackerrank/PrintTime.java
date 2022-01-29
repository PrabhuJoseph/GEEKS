package hackerrank;

public class PrintTime {

 private void printTime(int h, int m) {
   if (h<=0 && h>12) {
     throw new IllegalArgumentException("Given hour is wrong");
   }
   if (m <0 && m>=60) {
     throw new IllegalArgumentException("Given minute is wrong");
   }

   String nums[] = { "zero", "one", "two", "three", "four",
             "five", "six", "seven", "eight", "nine",
             "ten", "eleven", "twelve", "thirteen",
             "fourteen", "fifteen", "sixteen", "seventeen",
             "eighteen", "nineteen", "twenty", "twenty one",
             "twenty two", "twenty three", "twenty four",
             "twenty five", "twenty six", "twenty seven",
             "twenty eight", "twenty nine",
     };

   if (m == 0) {
     System.out.println(nums[h] + " o' clock");
   } else if (m < 10) {
     System.out.println(nums[m] + " minute past " + nums[h]);
   } else if (m == 15) {
     System.out.println(nums[m] + " minutes past " + nums[h]);
   } else if (m < 30) {
     System.out.println(nums[m] + " minutes past " + nums[h]);
   } else if (m == 30) {
     System.out.println("half past " + nums[h]);
   } else if (m == 45) {
     System.out.println("quarter to " + nums[h+1]);
   } else if (m < 60) {
     int rem = 60 - m;
     if (rem < 10) {
       System.out.println(nums[rem] + " minute to " + nums[h+1]);
     } else {
       System.out.println(nums[rem] + " minutes to " + nums[h+1]);
     }
   }
 }
}
