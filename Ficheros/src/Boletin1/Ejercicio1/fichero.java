package Boletin1.Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class fichero {
    public static void main(String[] args) {
        File fPers = new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/personajes.txt");
        File fAnime = new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/animes.txt");

        try {
            // 1. Leer los animes en un TreeMap (Se ordenan solos por ID de menor a mayor)
            TreeMap<Integer, String> animes = new TreeMap<>();
            Scanner scAnime = new Scanner(fAnime);
            while (scAnime.hasNextLine()) {
                String linea = scAnime.nextLine().trim();
                if (linea.isEmpty()) continue;
                int esp = linea.indexOf(" ");
                if (esp == -1) continue;

                int id = Integer.parseInt(linea.substring(0, esp));
                String nombre = linea.substring(esp + 1);
                animes.put(id, nombre);
            }
            scAnime.close();

            // 2. Leer los personajes y agruparlos
            Map<Integer, ArrayList<String>> personajesPorAnime = new HashMap<>();
            ArrayList<String> personajesSinAnime = new ArrayList<>();

            Scanner scPers = new Scanner(fPers);
            while (scPers.hasNextLine()) {
                String linea = scPers.nextLine().trim();
                if (linea.isEmpty()) continue;
                int esp = linea.indexOf(" ");
                if (esp == -1) continue;

                int id = Integer.parseInt(linea.substring(0, esp));
                String nombre = linea.substring(esp + 1);

                // Si el anime existe, lo guardamos. Si no, va a personajes sin anime.
                if (animes.containsKey(id)) {
                    personajesPorAnime.putIfAbsent(id, new ArrayList<>());
                    personajesPorAnime.get(id).add(nombre);
                } else {
                    personajesSinAnime.add(nombre);
                }
            }
            scPers.close();

            // 3. Imprimir los animes ordenados y sus personajes
            for (Map.Entry<Integer, String> entry : animes.entrySet()) {
                int id = entry.getKey();
                String nombreAnime = entry.getValue();

                System.out.println(nombreAnime);

                ArrayList<String> personajes = personajesPorAnime.get(id);
                if (personajes == null || personajes.isEmpty()) {
                    System.out.println("- No hay personajes");
                } else {
                    Collections.sort(personajes); // Orden alfabético (A-Z)
                    for (String p : personajes) {
                        System.out.println("- " + p);
                    }
                }
            }

            // 4. Imprimir personajes sin anime si los hay
            if (!personajesSinAnime.isEmpty()) {
                Collections.sort(personajesSinAnime);
                System.out.println("Personajes sin anime");
                for (String p : personajesSinAnime) {
                    System.out.println("- " + p);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró algún fichero.");
        }
    }
}
