public class oblig1 {

    // Oppgave 5
    public static void main(String[] args) {
        char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','I', 'J'};

        char[] b = Main.rotasjon(a);
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
}


}
