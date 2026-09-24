package Boletin1.Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class fichero {
	//Metodo que cargue los animes
	public static Map<Integer,String> cargarAnimes(String rutaFichero){
		Map<Integer,String> animes=new LinkedHashMap<>();
		try(BufferedReader br= new BufferedReader(new FileReader(rutaFichero))){
			String linea;
			while((linea=br.readLine())!=null) {
				linea=linea.trim();
				if(linea.isEmpty()) continue;
				
				String[] partes=linea.split(" ", 2);
				int codigo=Integer.parseInt(partes[0]);
				String titulo=partes[1];
			}
		}catch(IOException e) {
			System.out.println("Error al leer fichero de animes: "+e.getMessage());
		}
		return animes;
	}
	
	public static Map<Integer,List<String>> cargarPersonajes(String rutaFichero){
		Map<Integer,List<String>> personajesPorCodigo=new HashMap<>();
		return personajesPorCodigo;
	}
	
	
	
	public static void main(String[] args) {
		File fPers = new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/personajes.txt");
        File fAnime = new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/animes.txt");

		
	}
    /*public static ArrayList<String> obtenerPersonajesPorCodigo(int codigoBuscado, File ficheroPersonajes) {
        ArrayList<String> personajes = new ArrayList<>();
        try (Scanner sc = new Scanner(ficheroPersonajes)) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (linea.isEmpty()) continue;

                int esp = linea.indexOf(" ");
                if (esp == -1) continue;

                int codigo = Integer.parseInt(linea.substring(0, esp));
                String nombre = linea.substring(esp + 1);

                if (codigo == codigoBuscado) {
                    personajes.add(nombre);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el fichero de personajes: " + e.getMessage());
        }

        // Ordenar los personajes alfabéticamente (A-Z)
        Collections.sort(personajes);
        return personajes;
    }

    public static void main(String[] args) {
        File fPers = new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/personajes.txt");
        File fAnime = new File("/home/alumno/IdeaProjects/githubAccesoDatos/Ficheros/src/Boletin1/Ejercicio1/animes.txt");

        try {
            // 1. Leer el fichero de animes y crear un diccionario (TreeMap ordena automáticamente por la clave numérica)
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

            // 2. Por cada entrada del diccionario, buscar los personajes usando la función modular
            for (Map.Entry<Integer, String> entry : animes.entrySet()) {
                int idAnime = entry.getKey();
                String nombreAnime = entry.getValue();

                System.out.println(nombreAnime);
                ArrayList<String> personajes = obtenerPersonajesPorCodigo(idAnime, fPers);

                if (personajes.isEmpty()) {
                    System.out.println("- No hay personajes");
                } else {
                    for (String p : personajes) {
                        System.out.println("- " + p);
                    }
                }
            }

            // 3. Recorrer por última vez el fichero para encontrar personajes cuyo código no esté en el diccionario
            ArrayList<String> personajesSinAnime = new ArrayList<>();
            Scanner scPers = new Scanner(fPers);
            while (scPers.hasNextLine()) {
                String linea = scPers.nextLine().trim();
                if (linea.isEmpty()) continue;

                int esp = linea.indexOf(" ");
                if (esp == -1) continue;

                int idPers = Integer.parseInt(linea.substring(0, esp));
                String nombrePers = linea.substring(esp + 1);

                if (!animes.containsKey(idPers)) {
                    personajesSinAnime.add(nombrePers);
                }
            }
            scPers.close();

            // Si hay personajes sin anime, se muestran ordenados alfabéticamente
            if (!personajesSinAnime.isEmpty()) {
                Collections.sort(personajesSinAnime);
                System.out.println("Personajes sin anime");
                for (String p : personajesSinAnime) {
                    System.out.println("- " + p);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró alguno de los ficheros. " + e.getMessage());
        }
    }*/
}
