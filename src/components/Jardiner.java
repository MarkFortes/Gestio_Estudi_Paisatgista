/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Jardiner {
    
    private static Scanner s = new Scanner(System.in);
    
    private String nif;
    private String nom;
    private Torn torn;
    private boolean actiu;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou jardiner o jardinera, el seu estat sempre és
     actiu, per tant li assignem verdader. I torn, ja que quan es crea un nou
     jardiner o jardinera aquest encara no té assignat cap torn, per tant li assignarem
     null.
     */

    public Jardiner(String nif, String nom){
        this.nif = nif;
        this.nom = nom;
        this.actiu = true;
        this.torn = null;
    }

    /*
     TODO Mètodes accessors    
     */

    public String getNif(){
        return this.nif;
    }

    public void setNif(String nif){
        this.nif = nif;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public boolean getActiu(){
        return this.actiu;
    }

    public void setActiu(boolean actiu){
        this.actiu = actiu;
    }

    public Torn getTorn() { return this.torn; }

    public void setTorn(Torn torn) { this.torn = torn; }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou jardiner o nova
     jardinera. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou jardiner o nova jardinera creat/da.
     */

    public static Jardiner addJardiner() {

        System.out.println("Introdueix les dades del nou jardiner:");
        System.out.println("Nom:");
        String nom;
        nom = s.next();
        System.out.println("NIF:");
        String nif;
        nif = s.next();

        Jardiner jardiner = new Jardiner(nif, nom);

        System.out.println("Dissenyador creat amb éxit");

        return jardiner;

    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, menys de l'atribut torn.
     - En el cas de l'atribut actiu, li heu de demanar que si el jardiner o jardinera està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl jardiner o jardinera
     està en actiu", si el jardiner o jardinera està en actiu, i en cas contrari, el missatge 
     "\nEl jardiner o jardinera no està en actiu".
     Retorn: cap
     */

    public void updateJardiner() {

        System.out.println("Introdueix les noves dades del jardiner:");
        System.out.println("Nom:");
        String nom;
        nom = s.nextLine();
        System.out.println("NIF:");
        String nif;
        nif = s.nextLine();

        if (this.actiu == true){
            System.out.println("El/la jardiner està en actiu");
            System.out.println("Introdueix 1 si continua en actiu o introdueix 0 si ja no és actiu");
        }else{
            System.out.println("El/la jardiner no està en actiu");
            System.out.println("Introdueix 0 si segueix no actiu o introdueix 1 si ara es troba actiu");
        }

        int opcio_actiu;
        opcio_actiu = s.nextInt();
        boolean actiu;

        if (opcio_actiu == 1){
            actiu = true;
        }else{
            actiu = false;
        }

        this.setNif(nif);
        this.setNom(nom);
        this.setActiu(actiu);

        System.out.println("Jardiner actualitzat amb éxit");

    }

    public void showJardiner() {
        System.out.println("\nLes dades del jardiner o jardinera amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        torn.showTorn();
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
}
