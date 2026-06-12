class Solution {
    public int trap(int[] height) {
        int [] lm=new int[height.length];
        int max=height[0];
        for(int i=0;i<height.length-1;i++){
            if(height[i]>max){
                lm[i]=height[i];
                max=height[i];
            }
            else{
                lm[i]=max;
            }
        }
        int []rm=new int[height.length];
        int maxr=height[height.length-1];
        for(int i=height.length-1;i>=0;i--){
            if(height[i]>maxr){
                rm[i]=height[i];
                maxr=height[i];
            }
            else{
                rm[i]=maxr;
            }
        }
        int total=0;
        for(int i=0;i<height.length-1;i++){
            int min=Math.min(rm[i],lm[i]);
            int temp=min-height[i];
            total+=temp;
        }
        return total;
    }
}
