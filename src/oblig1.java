public class oblig1 {


    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J'};
        char[] b = oblig1.rotasjon(a);
        int [] c={31,30,11,10,20,5,8};// tabellen til oppgave1
        String n="ckib";//det første ord for oppgave10
        String m="smbckkb";// det andre ord for oppgave10;

        System.out.println(" Tabellen verdier byttet"+" "+ombyttinger(c)+" "+"gang/er");
        System.out.println(" Den maks verdien er:"+maks(c));
        System.out.println(innhold(n,m));// det skriver ut true eller false
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

    // dette er oppgave10
    public  static boolean innhold(String n,String m) {
        boolean x = false;

        int k = 0;
        char[] ord1 = n.toCharArray();
        char[] ord2 = m.toCharArray();

        for( int i=0;i< ord1.length;i++) {

            for(int j=0;j<ord2.length;j++){
                if(ord1[i]==ord2[j]) {
                    k++;
                    break;
                }
            }

        }
        if (k == ord1.length)
            x=true;

        return x;
    }





}



