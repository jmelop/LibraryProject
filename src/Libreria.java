import java.util.ArrayList;
import java.util.Iterator;

public class Libreria {

    ArrayList<Libro> libreria = new ArrayList<Libro>();
    String nombre;

    public Libreria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int cantidadLibros() {
        return libreria.size();
    }

    public void añadirLibro(Libro libro) {
        libreria.add(libro);
    }

    public Libro localizarLibro(String titulo) {
        Iterator<Libro> libro = libreria.iterator();

        while (libro.hasNext()) {
            Libro libList = libro.next();

            if (libList.getTitulo().equals(titulo)) {
                return libList;
            }
        }
        return null;
    }

    public boolean checkLibroAutor(String autor) {
        int i = 0;
        while (i < libreria.size()) {
            if (libreria.get(i).getAutor().equals(autor)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void borrarLibroAutor(String autor) {
        int i = 0;

        while (i < libreria.size()) {
            if (libreria.get(i).getAutor().equals(autor)) {
                libreria.remove(i);
                break;
            } else if (i >= libreria.size()) {
                System.out.println("Error, no existe ningún libro a borrar con el autor especificado");
            }
            i++;
        }
    }

    public Libro obtenerLibrosPrestados() {
        for (Libro libro : libreria) {
            if (libro.estaPrestado()) {
                return libro;
            }
        }
        return null;
    }

    public void prestarLibroTitulo(String titulo) {
        Iterator<Libro> iter = libreria.iterator();

        while (iter.hasNext()) {
            Libro libro = iter.next();

            if (libro.getTitulo().equals(titulo) && !libro.estaPrestado()) {
                libro.prestar();
                break;
            } else if (!iter.hasNext()) {
                System.out.println("Error, el libro no existe o ya se ecuentra prestado");
            }
        }
    }
}
