import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Libro {

    public String titulo;
    public String autor;
    public int numPagina;
    public Prestado estadoPrestado;
    public String fechaPrestamo;

    public Libro(String titulo, String autor, int numPagina, Prestado estadoPrestado) {
        this.titulo = titulo;
        this.autor = autor;
        this.numPagina = numPagina;
        this.estadoPrestado = estadoPrestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public Prestado getEstadoPrestado() {
        return estadoPrestado;
    }

    public void prestar() {
        if (estadoPrestado.equals(Prestado.SIPRESTADO)) {
            System.out.println("Error, el libro ya se encuentra prestado");
        } else {
            this.estadoPrestado = Prestado.SIPRESTADO;
            this.fechaPrestamo = obtenerFechaPrestamo();
        }
    }

    public void devolver() {
        if (estadoPrestado.equals(Prestado.NOPRESTADO)) {
            System.out.println("Error, el libro no esta prestado");
        } else {
            this.estadoPrestado = Prestado.NOPRESTADO;
        }
    }

    public boolean estaPrestado() {
        return estadoPrestado == Prestado.SIPRESTADO;
    }

    private String obtenerFechaPrestamo() {
        GregorianCalendar today = new GregorianCalendar();
        Date fecha = today.getTime();
        return new SimpleDateFormat("dd/MM/yy").format(fecha);
    }

    public String toString() {
        if (estaPrestado()) {
            return "Usted selecciono el siguiente libro: " + this.titulo + ", el autor es: " + this.autor + ", el libro cuenta con " + this.numPagina +
                    " paginas, el estado es " + this.estadoPrestado + " y la fecha es " + this.fechaPrestamo + ".";
        } else {
            return "Usted selecciono el siguiente libro: " + this.titulo + ", el autor es: " + this.autor + ", el libro cuenta con " + this.numPagina +
                    " paginas, el estado es " + this.estadoPrestado + ".";
        }
    }


}
