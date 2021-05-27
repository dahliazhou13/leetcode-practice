class peakIndexInMountainArray {
//     Let's call an array arr a mountain if the following properties hold:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
// Given an integer array arr that is guaranteed to be a mountain, 
// return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > 
// arr[arr.length - 1].
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (right - left)/2 + left;
            if(mid-1 >= 0 && arr[mid-1] > arr[mid]){
                right = mid - 1;
            }
            else if((mid + 1) <= arr.length - 1 && arr[mid + 1] > arr[mid]){
                left = mid + 1;
            } 
            else{
                return mid;
            }
        }
        return left;
    }
}
