import java.util.ArrayList;
import java.util.Scanner;
//Danilo Quattrini 30/09/2021

public class PROG {
    //METODO DOVE A POSTO DI USARE   System.out.println(); PER LA STAMPA USO printf
    public static void printf(String string) {
        System.out.println(string);
    }
         public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        float rtot = 0;
        int n = 1;
        float ptot = 0;
        //INSERIMENTO DI UN ARRAY LIST
        ArrayList<RES> r = new ArrayList<>();
        //INSERIMENTO VALORE DEL GENERATORE
        printf("Inserisci il valore del generatore");
        float x = scanner.nextFloat();
        //RICHIAMO LA CLASSE GENERATORE
        GEN gen = new GEN(x);
        //MENU DOVE CI SONO DIVERSE SELEZIONI
        printf("1 --> Aggiungi resistore");
        printf("2 --> Calcola resistenza in serie");
        printf("3 --> Resistenza se in parallelo");
        printf("4 --> Corrente totale se in serie");
        printf("5 --> Potenza dissipata da ogni resistore se in parallelo");
        printf("6 --> Stampa i valori inseriti");
        printf("7 --> Esci\n");
        while (true) {
            printf("Inserisci la tua opzione");
            int X = scanner.nextInt();
            switch (X) {
                case 1:
                    //INSERIMENTO VALORE DELLA RESISTENZA
                    printf("Inserisci il valore della resistenza");
                    float VAL = scanner.nextFloat();
                    r.add(new RES(VAL));
                    break;
                case 2:
                    //CALCOLO DELLA SERIE DI UN RESISTORE 
                    for (RES resistore : r) {
                        rtot += resistore.getVal();
                    }
                    printf("La resistenza in serie equivale a " + rtot);
                    break;
                case 3:
                    for (RES resistore : r) {
                        ptot += 1 / resistore.getVal();
                    }
                    printf("La resistenza in parallelo è " + 1 / ptot);
                    break;
                case 4:
                    float I = gen.getVal() / rtot;
                    printf("La corrente è " + I);
                    break;
                case 5:
                    //CALCOLO DELLA POTENZA DISSIPATA DA UN RESISTORE AD UN ALTRO
                    for (int i = 0; i < r.size(); i++) {
                        float pd = r.get(i).getVal() * (gen.getVal() * gen.getVal());
                        printf("La potenza dissipata dal resistore R" + i + " è di " + pd + "W");
                    }
                    break;
                case 6:
                    int i = 1;
                    printf("Generatore --> " + gen.getVal());
                    for (RES var : r) {
                        printf("R" + i + "-->" + var.getVal());
                        i++;
                    }
                case 7:
                    return;
            }

        }
    }
}

