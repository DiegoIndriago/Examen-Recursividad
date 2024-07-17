import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=====================================");
            System.out.println("               Menu");
            System.out.println("=====================================");
            System.out.println("Sumar elementos de un arreglo (1)");
            System.out.println("Añadir espacios (2)");
            System.out.println("Mostar datos de una pila (3)");
            System.out.println("Multiplicar factorial y potencia (4)");
            System.out.println("Salir (0)");
            System.out.print("Seleccion: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case (1): {
                    System.out.print("Ingrese el largo del arreglo: ");
                    int largo = sc.nextInt();
                    int[] arreglo = new int[largo];
                    for (int i = 0; i < largo; i++) {
                        System.out.print("Ingrese el numero " + i + " del arreglo:");
                        arreglo[i] = sc.nextInt();
                    }
                    System.out.println("La suma de los numeros del arreglo es: " + sumararreglo(arreglo));
                }
                case (4): {
                    System.out.print("Ingrese el numero factorial: ");
                    int facto = sc.nextInt();
                    System.out.print("\n Ingrese la base de la potencia: ");
                    int potencia = sc.nextInt();
                    System.out.print("\n Ingrese la potencia: ");
                    int expo = sc.nextInt();
                    System.out.println("la multiplicacion es igual a : " + multiplicar(facto, potencia, expo));
                }
                case(2):{
                    ListaCircular lista = new ListaCircular();
                    System.out.print("Ingrese el numero de palabras: ");
                    int num = sc.nextInt();
                    for (int i = 0; i < num; i++){
                        System.out.println("Ingrese la palabra numero " + i+1);
                        String palabra = sc.next();
                        lista.agregar(palabra);
                    }
                    System.out.println("las palabras son: " + lista.Juntar());
                }
                case(3):{
                    Pila p = new Pila();
                    System.out.print("Ingrese la cantidad de datos de la pila: ");
                    int num = sc.nextInt();
                    for (int i = 0; i < num; i++){
                        System.out.print("Ingrese el dato " + i + ": ");
                        int x = sc.nextInt();
                        p.push(x);
                    }
                    System.out.print("datos de la pila: ");
                    p.escribir();
                }
                default:{
                    System.out.println("Opcion Invalida!");
                }
            }
        } while (opcion != 0);
    }

    /*
       1 funcion que sume los elementos de un arreglo Explicacion:
       verifica el largo del arreglo, en el caso de ser iguaL a 1,
       en el caso que sea asi, no habria elementos que sumanr por lque regresesa ese valor.
       si el arreglo tiene mas de 1 elemento, regresa la suma del primer elemento del arreglo
       con el resultado de la funcion del mismo arreglo, exculyendo el primer elemento,
       repitiendo la funcion hasta que el largo del arreglo sea igual a 1.
     */
    static int sumararreglo(int[] x) {
        if (x.length == 1) {
            return x[0];
        } else {
            return x[0] + sumararreglo(Arrays.copyOfRange(x, 1, x.length));
        }
    }

    /*
    funcion factorial explicacion:
    calcula el factorial de un numero, osea la multiplicaion de un numero con todos los que lo suceden
    para hacer esto, confirma si el numero es igual a 1 y regresa el mismo numero,
    sino llama a la misma funcion del numero - 1, y se multiplica por el mismo numero, usa la recursividad para hacer esto hasta que
    el numero sea igual a 1.
     */
    static int factorial(int factor) {
        if (factor == 1) {
            return factor;
        } else {
            return factor * factorial(factor - 1);
        }
    }

    /*
    Funcion potencia explicacion:
    Calcula la potencia de un numero, con dos datos, el numero y la potencia a la que lo deseas elevar
    primero verifica si la potencia es igual a 1, en caso de sera asi, regresa el mismo numero
    sino, llama a la funcion con los mismo datos, pero restandole 1 a la potencia 1, y repite
    hasta que sea igual a 1.
     */
    static int potencia(int num, int elevado) {
        if (elevado == 1) {
            return num;
        } else {
            return num * potencia(num, elevado - 1);
        }
    }

    /*
    4 funcion que multiplica un factrorial y una potencia, explicacion:
    llama a las funciones potencia y factorial y devuelve el resultado de su multiplicacion
     */
    static int multiplicar(int facto, int pot, int exp) {
        return factorial(facto) * potencia(pot, exp);
    }
}

class Nodo {
    String palabra;
    Nodo siguiente;

    public Nodo(String palabra) {
        this.palabra = palabra;
        this.siguiente = null;
    }
}

class ListaCircular {
    Nodo inicio;

    public void agregar(String palabra) {
        Nodo  dato = new Nodo(palabra);
        if (inicio == null) {
            inicio = dato;
            inicio.siguiente = inicio;
        } else {
            dato.siguiente = inicio;
            Nodo ultimo = tempo();
            ultimo.siguiente = dato;
        }
    }
    private Nodo tempo() {
        Nodo temp = inicio;
        while (temp.siguiente != inicio) {
            temp = temp.siguiente;
        }
        return temp;
    }

    public String Juntar() {
        if (inicio == null) {
            return "";
        }
        StringBuilder resultado = new StringBuilder();
        Nodo actual = inicio;

        do {
            resultado.append(actual.palabra).append(" ");
            actual = actual.siguiente;
        } while (actual != inicio);
        return resultado.toString();
    }
}
class Pila {
    private Nodo tope;
    private static class Nodo {
        int valor;
        Nodo sig;

        Nodo(int valor) {
            this.valor = valor;
            this.sig = null;
        }
    }
    public void push(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.sig = tope;
        tope = nuevoNodo;
    }
    public void escribir() {
        imprimir(tope);
    }
    void imprimir(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println(nodo.valor);
        imprimir(nodo.sig);
    }
}
