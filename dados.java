package Principal;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class MainApp{
    //Cantidad de dinero del que dispone cada entidad
    private static int boteMaquina = 100;
    private static int botePlayer = 100;
    private static int boteBanca = 0;
    //Contador de victorias de cada entidad
    private static int contadorMaquina = 0;
    private static int contadorBanca = 0;
    private static int contadorPlayer = 0;
    //Contador de partidas
    private static int contadorPartidas =0;
    //Scanner empleado en la introduccion de datos por Consola
    private static Scanner tc = new Scanner(System.in);
    //Variable que controla la finalización del juego
    private static boolean end = false;
    //Variable que almacena que jugador va primero
    private static String jugadorInicial = "";

    private static float inicio = 0;


    public static void main(String[] args) {
        inicio = System.currentTimeMillis();
    //Imprime el mensaje inicial y pregunta si desea jugar
        System.out.println("*****************************************");
        System.out.println("           Juego de los dados            ");
        System.out.println("*****************************************");
        preguntar();
        while (!end){
            preguntar();
        }
        endGame();
    }

    public static void preguntar(){
        System.out.println(contadorPartidas==0?"¿Te atreves a jugar contra mi ?(S/N)":"¿Quieres seguir jugando? (S/N)");
        String option = tc.nextLine().toUpperCase();
        switch (option){
            case "S":
                //Si acepta comienza
                if (contadorPartidas==0) {decidirInicio();}
                juego();
                contadorPartidas++;
                break;
            case"N":
                //Si no quiere se controla la finalización del juego
                end = true;
                break;
            default:
                //En caso de introducir un caracter no valido vuelve a preguntar
                System.out.println("Caracter no valido");
                preguntar();
                break;
        }
    }



    public static void mostrarDinero(){
        System.out.println("Banca: "+boteBanca+"€");
        System.out.println("Bote Maquina: "+boteMaquina+"€");
        System.out.println("Bote Player: "+botePlayer+"€");
    }

    public static void endGame(){
        float acabo = System.currentTimeMillis();
        float tiempo = acabo - inicio;
        float minutos = ((tiempo/1000)/60);
       // DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Espero que te hayas entretenido");
        mostrarDinero();
        System.out.println("En "+contadorPartidas+" partidas estos han sido los resultados");
        System.out.println("La banca ha ganado "+contadorBanca+" veces");
        System.out.println("Tu has ganado "+contadorPlayer+" veces");
        System.out.println("La maquina ha ganado "+contadorMaquina+" veces");
        System.out.println("Has jugado "+minutos+" minutos");
    }

    public static void decidirInicio(){
        System.out.println("Empieza el que más saque");
        int tiradaP = new Random().nextInt(12)+1;
        int tiradaM = new Random().nextInt(12)+1;
        System.out.println("Has sacado "+tiradaP);
        System.out.println("La maquina ha sacado "+tiradaM);
        jugadorInicial = tiradaP>tiradaM?"Player":"Maquina";
        System.out.println("Juega primero "+jugadorInicial);
    }
    public static void juego(){
        int puntoVictoria;
        mostrarDinero();
        if (botePlayer<15){
            jugadorInicial="null";
        }
        switch (jugadorInicial){
            case "Player":
                System.out.println("Juegas");
                puntoVictoria = new Random().nextInt(12)+1;
                if (puntoVictoria==7||puntoVictoria==11){
                    System.out.println("Tirada: "+puntoVictoria+"Punto Victoria: "+puntoVictoria);
                    System.out.println("Has ganado");
                    contadorPlayer++;
                    botePlayer+=15;
                    boteMaquina-=15;
                }else if (puntoVictoria == 2||puntoVictoria == 3||puntoVictoria == 12){
                    System.out.println("Tirada: "+puntoVictoria+"Punto Victoria: "+puntoVictoria);
                    System.out.println("Has perdido");
                    contadorBanca++;
                    botePlayer-=15;
                    boteBanca+=15;
                }else{
                    boolean acabar=false;
                    System.out.println("Tirada: "+puntoVictoria+"Punto Victoria: "+puntoVictoria);
                    while (!acabar){
                        int temp = new Random().nextInt(12)+1;
                        System.out.println("Tirada para punto: "+temp);
                        if(temp==7){
                            System.out.println("He ganado");
                            contadorMaquina++;
                            botePlayer-=15;
                            boteMaquina+=15;
                            acabar=true;
                        }if (temp==puntoVictoria){
                            System.out.println("Has ganado");
                            contadorPlayer++;
                            botePlayer+=15;
                            boteMaquina-=15;
                            acabar=true;
                        }
                    }
                }
                break;
            case "Maquina":
                System.out.println("Juego");
                puntoVictoria = new Random().nextInt(12)+1;
                if (puntoVictoria==7||puntoVictoria==11){
                    System.out.println("Tirada: "+puntoVictoria+"Punto Victoria: "+puntoVictoria);
                    System.out.println("He ganado");
                    contadorMaquina++;
                    botePlayer-=15;
                    boteMaquina+=15;
                }else if (puntoVictoria == 2||puntoVictoria == 3||puntoVictoria == 12){
                    System.out.println("Tirada: "+puntoVictoria+"Punto Victoria: "+puntoVictoria);
                    System.out.println("He perdido");
                    contadorBanca++;
                    boteMaquina-=15;
                    boteBanca+=15;
                }else{
                    boolean acabar=false;
                    System.out.println("Tirada: "+puntoVictoria+"Punto Victoria: "+puntoVictoria);
                    while (!acabar){
                        int temp = new Random().nextInt(12)+1;
                        System.out.println("Tirada para punto: "+temp);
                        if(temp==7){
                            System.out.println("Has ganado");
                            contadorPlayer++;
                            botePlayer+=15;
                            boteMaquina-=15;
                            acabar=true;
                        }if (temp==puntoVictoria){
                            System.out.println("He ganado");
                            contadorMaquina++;
                            botePlayer-=15;
                            boteMaquina+=15;
                            acabar=true;
                        }
                    }
                }
                break;
            default:
                System.out.println("No dispones de dinero para seguir jugando");
                end=true;
                break;
        }
    }
}
