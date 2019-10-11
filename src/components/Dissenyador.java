/*
 * Classe que defineix un dissenyador o dissenyadora. Un dissenyador o dissenyadora
 * es defineix pel seu nif, nom i estat, és a dir, actiu si està treballant o no 
 * actiu si està de baixa o vacances.
 */
package components;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Dissenyador {

    private static Scanner s = new Scanner(System.in);
    
    private String nif;
    private String nom;
    private boolean actiu;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou dissenyador o dissenyadora, el seu estat sempre es
     actiu, per tant li assignem verdader.
     */

    public Dissenyador(String nif, String nom){
        this.nif = nif;
        this.nom = nom;
        this.actiu = true;
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

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou dissenyador o nova
     dissenyadora. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou dissenyador o nova dissenyadora creat/da.
     */
    public static Dissenyador addDissenyador() {

        System.out.println("Introdueix les dades del nou dissenyador:");
        System.out.println("Nom:");
        String nom;
        nom = s.next();
        System.out.println("NIF:");
        String nif;
        nif = s.next();

        Dissenyador dissenyador = new Dissenyador(nif, nom);

        System.out.println("Dissenyador creat amb éxit");

        return dissenyador;

    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - En el cas de l'atribut actiu, li heu de demanar que si el dissenyador o dissenyadora està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl dissenyador
     o dissenyadora està en actiu", si el dissenyador o dissenyadora està en actiu,
     i en cas contrari, el misaatge "\nEl dissenyador o dissenyadora no està en actiu".
     Retorn: cap
     */
    public void updateDissenyador() {

        System.out.println("Introdueix les noves dades del dissenyador:");
        System.out.println("Nom:");
        String nom;
        nom = s.nextLine();
        System.out.println("NIF:");
        String nif;
        nif = s.nextLine();

        if (this.actiu == true){
            System.out.println("El/la dissenyador/a està en actiu");
            System.out.println("Introdueix 1 si continua en actiu o introdueix 0 si ja no és actiu");
        }else{
            System.out.println("El/la dissenyador/a no està en actiu");
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

        System.out.println("Dissenyador actualitzat amb éxit");

    }

    public void showDissenyador() {
        System.out.println("\nLes dades del dissenyador o dissenyadora amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
}
