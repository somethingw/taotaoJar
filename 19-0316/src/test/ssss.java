package test;

/**
 * @author week
 * @Title: ssss
 * @ProjectName 19-0316
 * @Description: TODO
 * @date 2019/5/2017:50
 */
public class ssss {
    public static void main(String[] args) {
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};

        canCompleteCircuit(gas,cost);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if(total < 0) {
            return -1;
        }

        int tank = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if(tank < 0) {
                index = i + 1;
                tank = 0;
                System.out.println(index);
            }
        }
        return index;
    }
}
