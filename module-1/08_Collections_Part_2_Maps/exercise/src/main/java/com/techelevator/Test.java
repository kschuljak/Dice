package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Test {

//    	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
//       *
//       * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
//	     * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}

    public static void main(String[] args) {

        System.out.println(robPeterToPayPaul(2000, 99));

        System.out.println(robPeterToPayPaul(2000, 30000));



    }

    public static Map<String, Integer> robPeterToPayPaul(Integer peter, Integer paul){

        Integer petersMoney = peter;
        Integer paulsMoney = paul;

        Map<String, Integer> peterPaul = new HashMap<>();
        peterPaul.put("Peter", petersMoney);
        peterPaul.put("Paul", paulsMoney);
        if (petersMoney > 0 && paulsMoney < 1000) {
            Integer halfPetersMoney = (int) (petersMoney / 2.0);
            Integer paulsMoneyPlusHalfPeters = paulsMoney + halfPetersMoney;
            peterPaul.replace("Peter", halfPetersMoney);
            peterPaul.replace("Paul", paulsMoneyPlusHalfPeters);
        }
        return peterPaul;

    }
}
