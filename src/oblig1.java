package Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

/** 1. Hassan Abdi Samatar  s300322
 * 2. Beakal Zewdu   s326201
 * 3. Esmaeel Uzbek  ss306327
 * 4. Namtulla Najmidin  s320253
 * 5. orge Arturo Barrios Bustinza  s309693
 * */


public class Oblig1 {

        private Oblig1(){
        }
        // Help tabeller
        private static void bytt(int[]a, int i, int j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
        private static void bytt(char[]a, int i, int j){
            char temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }

        private static void snu(char[] c, int v, int h){
            while(v<h)bytt(c, v++, h--);
        }
        // Hjelpe metode for å rotere Arrayet til bestent rettning (+, -)
        public static int rotatasjonsRettning(int a, int b) {
            return b == 0 ? a : rotatasjonsRettning(b, a % b);
        }

        //Oppgave 1 Del.1
        public static int maks(int[] a) {
        int n = a.length - 1;
        if(n < 0)
            throw new NoSuchElementException("Tabellen er tom!");

        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) bytt(a,i-1,i);
        }

        return a[n];
    }
        // Oppgave1 Del.2
        //Denne metoden teller hvor mange ganger verdiene i tabellen byttet
        public static int ombyttinger(int[] a) {
            int count=0;
            for (int i = 0; i < a.length-1; i++) {
                if (a[i] > a[i+1]) {
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    count++;

                }
            }
            return count;
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
            return  antallUlike;
        }

        // OPPGAVE 3
        public static int antallUlikeUsortert(int[] a) {
            int antall = a.length;
            for(int i = 0; i < a.length - 1; i++) {
                int j = i + 1;
                int like = 0;
                while(j < a.length && like == 0)
                    if(a[i] == a[j++]) like = 1;
                antall -= like;
            }
            return antall;
        }

        // OPPGAVE 4
        public static void delsortering(int[] a) {
            int v = 0;
            int h = a.length - 1;
            while(v <= h) {
                /*
                 * Hvis første bit-posisjon er 1, vil verdien bli et oddetall.
                 * For bit-posisjon n, vil hver bit som er aktiv ha verdien 2^n.
                 * Eneste måten verdien blir et oddetall da, er når 2^0 = 1.
                 */

                if((a[v] & 1) == 1) v++;
                else {
                    if((a[h] & 1) == 0) h--;
                    else bytt(a, v++, h--);
                }
            }
            Arrays.sort(a, 0, v);
            Arrays.sort(a, v, a.length);
        }

        //Oppgave 5
        public static void rotasjon(char[] a){
            for ( int i = 0; i < a.length; i++){
                char temp = a[i];
                a[i]= a[a.length-1];
                a[a.length-1] = temp;
            }
        }

        // OPPGAVE 6
        public static void rotasjon(char[] a, int k) {
            int n = a.length;
            if(n < 2)
                return;
            if((k %= n) < 0) k += n;
            int s = rotatasjonsRettning(n, k);
            for(int i = 0; i < s; i++) {
                char verd = a[i];
                for(int j = i - k, m = i; j != i; j -= k) {
                    if (j < 0) j += n;
                    a[m] = a[j];
                    m = j;
                }
                a[i + k] = verd;
            }
        }

        //Oppgave7-(a):
        public static String flett(String s, String t) {
            String u = new String();
            int i = 0, j = 0;
            while(i < s.length() && j < t.length())
                u = u + s.charAt(i++) + t.charAt(j++);
            while(i < s.length())
                u = u + s.charAt(i++);
            while(j < t.length())
                u = u + t.charAt(j++);
            return u;
        }
        //Oppgave7-(b):
        public static String flett(String... s) {
            String u = new String();
            int n = 0;
            int j = 0;
            while(j < s.length) {
                j = 0;
                for(int i = 0; i < s.length; i++) {
                    if(n < s[i].length()) u = u + s[i].charAt(n);
                    else j++;
                }
                n++;
            }
            return u;
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

    // OPPGAVE 10
    public static boolean inneholdt(String n, String m) {
        if(n.length() > m.length())
            return false;

        char[] array1 = n.toCharArray();
        char[] array2 = m.toCharArray();
        int antall = 0;

        for(int i = 0; i < array1.length; i++) {
            char letter = array1[i];

            int j = i;
            while(j < array2.length && letter != array2[j]) j++;

            if(j < array2.length && array2[j] == letter) {
                char temp = array2[i];
                array2[i] = array2[j];
                array2[j] = temp;
                antall++;
            }
        }

        return antall == array1.length;
       }

    }










