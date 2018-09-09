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

//oppgave 2
    public static int antallUlikeSortert(int[]a){

        if(a.length<2){
            return a.length;
        }
        int antallUlike=1;
        for(int i=1; i<a.length; i++){
            if (a[i-1]>a[i]){
                throw new IllegalStateException("Tabellen er usorter");
            }else{
                if(a[i-1]<a[i]){
                    antallUlike++;
                }
            }

        }
        System.out.println(" Antall ulike sortert tall : "+antallUlike);
        return  antallUlike;
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



//Oppgave 8
    public static int[] indekssortering(int[]a){
        int[] indeks = new int[a.length];
        for(int i=0; i<a.length; i++){
            indeks[i]=i;
        }
          int temp;
           int  j;
        for(int i=1; i<a.length; i++){
            for (temp=indeks[i], j=i-1; j>=0 && a[temp]<a[indeks[j]]; j--){
                indeks[j+1]=indeks[j];
            }
            indeks[j+1]=temp;
        }
        return indeks;
    }



    // Oppgave 9
    public static int[] tredjeMin(int[]a){
        int n=a.length; // lengde av tabbelen
        if(n<3){ // Tabellen må ha minste 3 verdier
            throw new NoSuchElementException("a.length("  +n+ ")<3!");
        }

       int[] indeks= indekssortering(Arrays.copyOf(a,3));
        int m= indeks[0]; // m er indeksen til minste verdi
        int nm= indeks[1]; // nm  er indeksen til  neste minste verdi
        int tm= indeks[2]; // tm  er indeksen til tredje minste verdi

        int minVerdi=a[m];    // minst verdi
        int nesteMinVerdi=a[nm];
        int tredjeMinVerdi=a[tm];
        for(int i=3; i<n; i++){
            int verdi=a[i];
            if(verdi<tredjeMinVerdi){
                if(verdi<nesteMinVerdi){
                    if(verdi<minVerdi){
                        tm=nm;
                        tredjeMinVerdi=nesteMinVerdi;
                        nm=m;
                        nesteMinVerdi=minVerdi;
                        m=i;
                        minVerdi=verdi;
                    }else {
                        tm=nm;
                        tredjeMinVerdi=nesteMinVerdi;
                        nm=i;
                        nesteMinVerdi=verdi;
                    }
                }else {
                    tm=i;
                    tredjeMinVerdi=verdi;
                }
            }
        }

      return new int[]{m, nm, tm} ;

    }


