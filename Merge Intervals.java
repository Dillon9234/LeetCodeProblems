class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int ptr = 0;
        element[] helper = new element[n*2];
        for(int i = 0, k = 0;i<2*n;i++,k++){
            helper[i++] = new element(intervals[k][0],true);
            helper[i] =  new element(intervals[k][1],false);
        }
        Arrays.sort(helper, (o1, o2) -> {int compareValue = Integer.compare(o1.num, o2.num);
            if (compareValue == 0) {
                return Boolean.compare(o2.isStart, o1.isStart); 
            }
            return compareValue;
        });

        int[] cur = new int[2];
        cur[0] = helper[0].num;
        int overlap = 1;
        for(int i = 1;i<2*n;i++){
            if(helper[i].isStart){
                overlap++;
            }else{
                overlap--;
                if(overlap == 0){
                    cur[1] = helper[i].num;
                    ans.add(cur);
                    cur = new int[2];
                    if(i+1<2*n)
                        cur[0] = helper[++i].num;
                    else break;
                    overlap = 1;
                }
            }
        }
        return ans.toArray(new int[ans.size()][2]);  
    }
}

class element{
    int num;
    boolean isStart;
    public element(int num,boolean isStart){
        this.num = num;
        this.isStart = isStart;
    }
}
