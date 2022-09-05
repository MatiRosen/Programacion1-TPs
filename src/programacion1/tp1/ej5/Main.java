package programacion1.tp1.ej5;

public class Main {

    public static void main(String[] args) {
        Escuela escuela = new Escuela("Ort", new Domicilio("Yatay 240", "1717", "CABA"));
        Padron padron = new Padron();
        padron.agregarEscuela(escuela);

        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        padron.agregarMesa(mesa1, escuela);
        padron.agregarMesa(mesa2, escuela);
        padron.agregarMesa(mesa3, escuela);

        Persona persona1 = new Persona("Juan", "Perez", "12345678", "01/01", Genero.MASCULINO, new Domicilio("Ejemplo", "1b", "CABA"));
        Persona persona2 = new Persona("Ana", "Torres", "87654321", "01/01", Genero.MASCULINO, new Domicilio("Ejemplo", "1b", "CABA"));
        Persona persona3 = new Persona("Ricardo", "Gomez", "12341234", "01/01", Genero.MASCULINO, new Domicilio("Ejemplo", "1b", "CABA"));
        Persona persona4 = new Persona("Andrea", "Bergara", "11122233", "01/01", Genero.MASCULINO, new Domicilio("Ejemplo", "1b", "CABA"));
        Persona persona5 = new Persona("Roberto", "Bolaños", "3322211", "01/01", Genero.MASCULINO, new Domicilio("Ejemplo", "1b", "CABA"));
        Persona persona6 = new Persona("Carlos", "Tripero", "65498712", "01/01", Genero.MASCULINO, new Domicilio("Ejemplo", "1b", "CABA"));

        padron.agregarVotante(persona1, mesa1);
        padron.agregarVotante(persona2, mesa1);
        padron.agregarVotante(persona3, mesa2);
        padron.agregarVotante(persona4, mesa2);
        padron.agregarVotante(persona5, mesa2);
        padron.agregarVotante(persona6, mesa3);

        Informe informe = escuela.obtenerInforme();

        System.out.print("   ");
        for (int nroMesa : informe.getNroMesa()){
            System.out.print(nroMesa + "           ");
        }

        System.out.println("");
        System.out.print("   ");
        for (int nroOrden : informe.getNroOrden()){
            System.out.print(nroOrden + "           ");
        }

        System.out.println("");
        for (String dni : informe.getDniPersona()){
            System.out.print(dni + "    ");
        }

        System.out.println("");
        for (String nombre : informe.getNombrePersona()){
            System.out.print(nombre + "       ");
        }

        System.out.println("");
        for (String apellido : informe.getApellidoPersona()){
            System.out.print(apellido + "      ");
        }

    }
}
