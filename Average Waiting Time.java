class Solution {
    public double averageWaitingTime(int[][] customers) {
        int curTime = 0;
        double sum = 0;
        int n = customers.length;
        for(int i=0;i<n;i++){
            curTime = (customers[i][0]<curTime)?curTime:customers[i][0];
            curTime += customers[i][1];
            sum += curTime - customers[i][0];
        }
        return sum/n;
    }
}
