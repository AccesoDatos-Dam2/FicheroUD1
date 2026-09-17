package Boletin1.Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class fichero {
    public static void main(String[] args){
        File f1=new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/personajes.txt");
        File f2=new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/animes.txt");
        try{
            String ids="";

            Scanner scPersonajes=new Scanner(f1);

            while(scPersonajes.hasNextLine()) {
                String lineaP = scPersonajes.nextLine().trim();
                if (lineaP.isEmpty()) {
                    continue;
                }
                int espacioP = lineaP.indexOf(" ");
                String idP = lineaP.substring(0, espacioP);

                if (ids.contains("[" + idP + "]")) {
                    continue;
                }
                ids += "[" + idP + "]";
                Scanner scAnimes = new Scanner(f2);
                String nombreAnime = "";

                while (scAnimes.hasNextLine()) {
                    String lineaA = scAnimes.nextLine().trim();
                    if (lineaA.isEmpty()) {
                        continue;
                    }
                    int espacioA = lineaA.indexOf(" ");
                    String idA = lineaA.substring(0, espacioA);

                    if (idP.equals(idA)) {
                        nombreAnime = lineaA.substring(espacioA + 1);
                        break;
                    }
                }
                scAnimes.close();
                if (!nombreAnime.isEmpty()) {
                    System.out.println(nombreAnime);

                    Scanner scTodosPers = new Scanner(f1);
                    while (scTodosPers.hasNextLine()) {
                        String lineaSubP = scTodosPers.nextLine().trim();
                        if (lineaSubP.isEmpty()) continue;
                        int esp = lineaSubP.indexOf(" ");
                        String idSubP = lineaSubP.substring(0, esp);
                        String nomSubP = lineaSubP.substring(esp + 1);
                        if (idP.equals(idSubP)) {
                            System.out.println("- " + nomSubP);
                        }
                    }
                    scTodosPers.close();
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Error: No se encontro alguno de los ficheros"+e.getMessage());
        }
    }
}
