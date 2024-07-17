import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("      Menu");
        System.out.println("1- ");
    }
    /*
       1 funcion que sume los elementos de un arreglo Explicacion:
       verifica el largo del arreglo, en el caso de ser iguaL a 1,
       en el caso que sea asi, no habria elementos que sumanr por lque regresesa ese valor.
       si el arreglo tiene mas de 1 elemento, regresa la suma del primer elemento del arreglo
       con el resultado de la funcion del mismo arreglo, exculyendo el primer elemento,
       repitiendo la funcion hasta que el largo del arreglo sea igual a 1.
     */
    static int sumararreglo(int[] x){
        if (x.length == 1){
            return x[0];
        }
        else{
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
    static int factorial(int factor){
        if (factor == 1){
            return factor;
        }
        else{
            return factor * factorial(factor-1);
        }
    }

    /*
    Funcion potencia explicacion:
    Calcula la potencia de un numero, con dos datos, el numero y la potencia a la que lo deseas elevar
    primero verifica si la potencia es igual a 1, en caso de sera asi, regresa el mismo numero
    sino, llama a la funcion con los mismo datos, pero restandole 1 a la potencia 1, y repite
    hasta que sea igual a 1.
     */
    static int potencia(int num, int elevado ){
        if (elevado == 1){
            return num;
        }
        else{
            return num * potencia(num,elevado-1);
        }
    }
    /*
    4 funcion que multiplica un factrorial y una potencia, explicacion:
    llama a las funciones potencia y factorial y devuelve el resultado de su multiplicacion
     */
    static int multiplicar(int facto,int pot, int exp){
        return factorial(facto) * potencia(pot, exp);
    }




}