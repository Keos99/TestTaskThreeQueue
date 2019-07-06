package mvc.controler.impl;

import mvc.controler.Calculation;

import java.util.List;

public class CalculationImpl implements Calculation {

    @Override
    public String biggestQueue(List<List<Integer>> queues, List<String> timeList) {
        int temp = 0;
        int max = 0;
        int timenumber = 0;

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < queues.size(); j++) {
                temp += queues.get(j).get(i);
            }

            if (max < temp){
                max = temp;
                timenumber = i;
            }
        }
        return timeList.get(timenumber);
    }
}
