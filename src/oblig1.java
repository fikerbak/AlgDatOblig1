public class oblig1 {


    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J'};
        char[] b = oblig1.rotasjon(a);
        int [] c={31,30,11,10,20,5,8};// tabellen til oppgave1


        System.out.println(" Tabellen verdier byttet"+" "+ombyttinger(c)+" "+"gang/er");
        System.out.println(" Den maks verdien er:"+maks(c));

        System.out.println(b);
    }

/* dette er oppgave1 av andre versjon*/

   // dette methoden retunerer maksverdien

    public static int maks(int[] c) {

        int mv=c[0];
        for (int i = 0; i < c.length-1; i++) {

            if (c[i] > c[i+1]) {

                int temp = c[i];
                c[i] = c[i+1];
                c[i+1] = temp;
             mv=c[c.length-1];
            }

        }
        return mv;
    }


//dette telles hvor mange ganger verdiene i tabellen byttet
    public static int ombyttinger(int[] c) {

        int count=0;
        for (int i = 0; i < c.length-1; i++) {

            if (c[i] > c[i+1]) {

                int temp = c[i];
                c[i] = c[i+1];
                c[i+1] = temp;
                count++;
            }

        }
        return count;
    }




    public static char[] rotasjon(char[] a){

        for ( int i = 0; i < a.length; i++){
            char temp = a[i];
            a[i]= a[a.length-1];
            a[a.length-1] = temp;
        }
        return a ;
    }


}



// oppgave 5


    public static void rotasjon(char[] a) {

        for (int i = 0; i < a.length; i++) {
            char temp = a[i];
            a[i] = a[a.length - 1];
            a[a.length - 1] = temp;


        }


    }



// oppgave 6 


public static void rotasjon(char[] a, int k) {

        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(i + k) % a.length] = a[i];
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
}


