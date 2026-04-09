public class CircularTour {
    static class Pump{
        int petrol, dist;
        Pump(int p,int d){petrol=p;dist=d;}
    }

    public static void main(String[] args){
        Pump[] arr={new Pump(6,4),new Pump(3,6),new Pump(7,3)};
        int start=0,balance=0,deficit=0;

        for(int i=0;i<arr.length;i++){
            balance+=arr[i].petrol-arr[i].dist;
            if(balance<0){
                start=i+1;
                deficit+=balance;
                balance=0;
            }
        }
        System.out.println((balance+deficit>=0)?start:-1);
    }
}
