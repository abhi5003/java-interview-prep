package abhi.java.code.java8.Questions;

import java.util.*;
import java.util.stream.*;

public class SummaryStatics {

    public static void main(String[] args) {

        List<Integer> list=Arrays.asList(34, 23, 67, 51, 28, 39);
//         IntSummaryStatistics intSummaryStatistics = list.stream().sorted().mapToInt(i -> i).summaryStatistics();
//
//         int min= intSummaryStatistics.getMin();
//         int max=intSummaryStatistics.getMax();
//         double average=intSummaryStatistics.getAverage();
//
//        System.out.println("Minimum " +min +" " + "Average " +average + " "+ "Maximum " +max);

        // 2nd and 3rd lowest integer
        List<Integer> sliceList=list.stream().sorted().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(sliceList);
    }
}
