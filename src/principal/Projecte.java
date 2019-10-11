/*
 * Classe que defineix un projecte. Un projecte es defineix per un codi, NIF del
 * del client que ha encarregat el projecte, si està finalitzat o no, el pressupost 
 * i el dissenyador encarregat en desenvolupar-lo. A més, contindrà un vector de 
 * jardiners encarregats d'implementar el projecte.
 */
package principal;

import components.Dissenyador;
import components.Jardiner;

import javax.print.attribute.standard.DialogTypeSelection;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Projecte {
    
    private static Scanner s = new Scanner(System.in);

    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nifClient;
    private boolean finalitzat;
    private double pressupost;
    private Dissenyador dissenyador;
    private Jardiner[] jardiners = new Jardiner[40];
    private int posicioJardiners = 0; //Priemra posició buida del vector jardiners
    
     /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys el vector, el
     codi i finalitzat.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - Quan es crea un projecte aquest mai està finalitzat, per tant, assignarem
     fals a l'atribut finalitzat.
     - Quan es crea un projecte no té cap dissenyador assignat.
     */

     public Projecte(String nifClient, Double pressupost, Dissenyador dissenyador){

         this.nifClient = nifClient;
         this.pressupost = pressupost;
         this.dissenyador = null;
         this.codi = properCodi;
         finalitzat = false;

         properCodi++;

     }

    /*
     TODO Mètodes accessors    
     */

    public int getCodi(){
        return this.codi;
    }

    public void setCodi(int codi){
        this.codi = codi;
    }

    public String getNifClient(){
        return this.nifClient;
    }

    public void setNifClient(String nifClient){
        this.nifClient = nifClient;
    }

    public boolean getFinalitzat(){
        return this.finalitzat;
    }

    public void setFinalitzat(){
        this.finalitzat = finalitzat;
    }

    public double getPressupost(){
        return this.pressupost;
    }

    public void setPressupost(){
        this.pressupost = pressupost;
    }

    public Dissenyador getDissenyador(){
        return this.dissenyador;
    }

    public void setDissenyador(Dissenyador dissenyador){
        this.dissenyador = dissenyador;
    }

    public Jardiner[] getJardiners(){
        return this.jardiners;
    }

    public void setJardiners(Jardiner[] jardiners){
        this.jardiners = jardiners;
    }

     /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou projecte. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     Retorn: El nou projecte creat.
     */
    public static Projecte addProjecte() {
        System.out.println("Introdueix les dades per crear un nou projecte");
        System.out.println("NIF del client:");
        String nifClient = s.next();
        System.out.println("Pressupost del projecte:");
        double pressupost = s.nextDouble();
        System.out.println("Introdueix les següents dades del dissenyador encarregat del projecte:");
        System.out.println("Nif del dissenyador:");
        String nifDissenyador = s.next();
        System.out.println("Nom del dissenyador:");
        String nomDissenyador = s.next();
        Dissenyador dissenyador = new Dissenyador(nifDissenyador, nomDissenyador);

        Projecte projecte = new Projecte(nifClient, pressupost, dissenyador);

        return projecte;
    }
    
    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     només es pot modificar el NIF del client, si està finalitzat o no i el pressupost.
     - En el cas de finalitzat o no, li heu de demanar a l'usuari que si el projecte està  
     finalitzat, introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte actual, 
     abans de modificar-los. En el cas de l'atribut finalitzat, li heu de mostrar
     el missatge: "\nEl projecte està finalitzat", si el projecte s'ha finalitzat,
     i en cas contrari, el missatge "\nEl projecte no està finalitzat".
     Retorn: cap
     */
    public void updateProjecte() {
        System.out.println("Introdueix les noves del projecte");
        System.out.println("Nou NIF del client:");
        String nifClient = s.nextLine();
        this.nifClient = nifClient;
        System.out.println("Nou pressupost del projecte:");
        double pressupost = s.nextDouble();
        this.pressupost = pressupost;
        System.out.println("Introdueix 1 si el projecte ha finalitzat i 0 en cas contrari");
        int finalitzat = s.nextInt();
        if (finalitzat == 1){
            this.finalitzat = true;
            System.out.println("El projecte està finalitzat");
        }else{
            this.finalitzat = false;
            System.out.println("El projecte no esta finalitzat");
        }
    }

    /*
     TODO
     Paràmetres: jardiner o jardinera a afegir
     Accions:
     - afegeix al vector jardiners del projecte actual el jardiner o jardinera
     passat/ada per paràmetre.
     - actualitza la posició del vector jardiners.
     Retorn: cap
     */
    public void addJardiner(Jardiner jardiner) {

        jardiners[posicioJardiners] = jardiner;

        posicioJardiners++;

    }

    public void showProjecte() {
        System.out.println("\nLes dades del projecte amb codi " + codi + " són:");
        System.out.println("\nNIF client: " + nifClient);
        System.out.println("\nPressupost: " + pressupost);
        dissenyador.showDissenyador();
        
        if(finalitzat){
            System.out.println("\nEl projecte està finalitzat");
        }else{
            System.out.println("\nEl projecte no està finalitzat");
        }

        for (int i = 0; i < posicioJardiners; i++) {
            jardiners[i].showJardiner();
        }
    }
    
}
