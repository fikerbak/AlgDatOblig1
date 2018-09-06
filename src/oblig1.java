public class oblig1 {

    // Oppgave 5
    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J'};
        char[] b = oblig1.rotasjon(a);
        int[] d={12,3,11,10,22,5,7,6}; // tabellen til oppgave1

        maksverdi(d); // kaller methoden maksverdi slik det skal gjøre sin oppgave

        System.out.println(b);
    }

    public static char[] rotasjon(char[] a){

        for ( int i = 0; i < a.length; i++){
            char temp = a[i];
            a[i]= a[a.length-1];
            a[a.length-1] = temp;
        }
        return a ;
    }

   // dette er oppgave1
    public static  void maksverdi(int[] d){
        int[] f= new int[d.length];
        int count=0;
        int m=0;
        int mv=d[0];

        for(int i=1;i< d.length;i++){

            if(mv>d[i]){
                ombyttinger(d,m,i) ;
                count++;
            }
            else{
                m=i;
                mv=d[i];

            }
     for(int j=0;j<d.length;j++){
         f[j]=d[m];
     }
        }
        System.out.println("den maksverden er:"+mv);
        System.out.println("tabellen verdier byttet "+ count + " " +"gange/r");
        System.out.println(m);

    }
    public static  void ombyttinger(int[] d,int m,int i){


        int temp=d[m];
        d[m]=d[i];
        d[i]=temp;
    }




}



