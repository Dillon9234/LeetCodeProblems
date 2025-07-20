class Entry {
    int value;
    int count;

    public Entry(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int map[] = new int[10001];
        int n = barcodes.length;
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            ++map[barcodes[i]];
        }
        
        PriorityQueue<Entry> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.count, a.count)
        );
        for(int i=0;i<10001;i++){
            if(map[i]!=0) pq.add(new Entry(i,map[i]));
        }
        for(int i=0;i<n-1;i+=2){
            Entry largest = pq.poll(); 
            Entry secondLargest = pq.poll(); 
            result[i] = largest.value;
            result[i+1] = secondLargest.value;
            largest.count--;
            secondLargest.count--;
            if(largest.count != 0){
                pq.add(largest);
            }
            if(secondLargest.count != 0){
                pq.add(secondLargest);
            }
        }
        if(!pq.isEmpty()){
            result[n-1] = pq.poll().value;
        }
        return result;
    }
}
