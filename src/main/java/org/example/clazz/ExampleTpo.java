package org.example.clazz;

import org.example.tdas.*;
import org.example.tdas.Stack;

import java.util.*;


public class ExampleTpo {

    public static int calcularTraza (IQueueOfStacks queue) { // Ejercicio matrices. 2.1.1 Hecho por Giuliano Politi
        IQueueOfStacks copy = ExampleTpo.copyQueueOfStack(queue);
        int traza = 0; // O(c)
        int index = copy.getNumElementsOfStack(); // O(N)
        while (!copy.isEmpty()) { // O(n)
            index--;
            for (int i = 0; i < copy.getNumElementsOfStack(); i++) { //O(n)
                if (i == index) {
                    traza += copy.getFirst();
                }
                copy.remove();
            }
        }
        return traza;
    } // complejidad computacional: O(N**2) + O(N).
    public static IQueueOfStacks traspuestaOfQueueOfStacks(IQueueOfStacks queue) { // Ejercicio matrices. 2.1.2 Hecho por Giuliano Politi
        IQueueOfStacks copy = ExampleTpo.copyQueueOfStack(queue); //O(n)
        IQueueOfStacks traspuesta = new DynamicQueueOfStacks(queue.getNumElementsOfStack()); //O(c)
        int numElements = queue.getNumElementsOfStack();//O(c)
        IQueue[] tempsQueue = new StaticQueueOfNElements[numElements];//O(c)

        // Inicializa cada pila en el array de pilas temporales
        for (int i = 0; i < numElements; i++) { // //O(n)
            tempsQueue[i] = new StaticQueueOfNElements(numElements);
        }

        // Llena las pilas temporales con los elementos de la copia de la cola
        for (int i = 0; i < numElements; i++) { //O(n)
            for (int j = 0; j < numElements; j++) {
                if (!copy.isEmpty()) {
                    tempsQueue[j].add(copy.getFirst());
                    copy.remove();
                }
            }
        }

        // Transfiere los elementos de las pilas temporales a la cola de traspuesta
        for (int j = numElements -1; j >= 0; j--) { //O(n)
            while (!tempsQueue[j].isEmpty()) {
                traspuesta.add(tempsQueue[j].getFirst());
                tempsQueue[j].remove();
            }
        }

        return traspuesta;
    } // Complejidad computacional: //O(n) + O(n) + O(n) + O(n) = O(4n) lineal
    public static IQueueOfStacks sumaOfQueueOfStacks (IQueueOfStacks q1, IQueueOfStacks q2) { // Ejercicio matrices. 2.1.3 Hecho por Giuliano Politi
        if (q1.getNumElementsOfStack() != q2.getNumElementsOfStack()) {
            throw new RuntimeException("Las matrices tienen que ser del mismo tamaño.");
        }
        IQueueOfStacks copyQ1 = ExampleTpo.copyQueueOfStack(q1); //O(n)
        IQueueOfStacks copyQ2 = ExampleTpo.copyQueueOfStack(q2); //O(n)
        IQueueOfStacks sumaAlReves = new DynamicQueueOfStacks(q1.getNumElementsOfStack()); //O(C)
        IQueueOfStacks suma = new DynamicQueueOfStacks(q1.getNumElementsOfStack()); //O(C)
        while (!copyQ1.isEmpty()) { //O(n)
            sumaAlReves.add(copyQ1.getFirst() + copyQ2.getFirst());
            copyQ1.remove();
            copyQ2.remove();
        }
        while (!sumaAlReves.isEmpty()) { //O(n)
            suma.add(sumaAlReves.getFirst());
            sumaAlReves.remove();
        }
        return suma;
    } //complejidda computacional: //O(n) + O(n) +O(n) +O(n) = O(4n) lineal
    private static IQueueOfStacks copyQueueOfStack (IQueueOfStacks iQueueOfStacks){ // O(N) + O(N) = O(N) lineal
        int numElements = iQueueOfStacks.getNumElementsOfStack();
        IQueueOfStacks copy = new DynamicQueueOfStacks(numElements);
        IQueueOfStacks copy2 = new DynamicQueueOfStacks(numElements);
        while (!iQueueOfStacks.isEmpty()){
            copy.add(iQueueOfStacks.getFirst());
            iQueueOfStacks.remove();
        }
        while (!copy.isEmpty()){
            copy2.add(copy.getFirst());
            iQueueOfStacks.add(copy.getFirst());
            copy.remove();
        }
        return copy2;
    }

    public static int calcularDesplazamiento (String string) { // ejercicio 5.2 hecho por Giuliano Politi
        HashMap<Character, Integer> alphabeticMap = ExampleTpo.generateDictionaryOfAlphabet(); // O(C) porque el numero de letras es constante
        // utilizamos el mapa que generamos con todos las letras
        for (char c: string.toCharArray()) { //O (N)
            c = Character.toLowerCase(c);
            if (!alphabeticMap.containsKey(c)) { // corregimos los tildes aca
                switch (c) {
                    case 'á': c = 'a'; break;
                    case 'é': c = 'e'; break;
                    case 'í': c = 'i'; break;
                    case 'ó': c = 'o'; break;
                    case 'ú':
                    case 'ü': c = 'u'; break;
                    case 'ñ': c = 'n'; break;
                }
            }
            if (Character.isLetter(c) || c == 'ñ') {
                alphabeticMap.put(c, alphabeticMap.get(c) +1);
            }
        }

        char letraConMasFrecuencia = ' ';
        int valueMax = 0;
        for (Map.Entry<Character, Integer> entry : alphabeticMap.entrySet()) { // O(n)
            if (entry.getValue() > valueMax) {
                letraConMasFrecuencia = entry.getKey();
                valueMax = entry.getValue();
            }
        }
        System.out.println(letraConMasFrecuencia);
        int desplazamiento = letraConMasFrecuencia - 'a';
        return desplazamiento;
    } // complejidad computacional: O(2N)

    public static String descifrarMensaje(String string) { // ejercicio 5.2 hecho por Giuliano Politi
        String mensaje = "";
        int desplazamiento = ExampleTpo.calcularDesplazamiento(string); // O(2N)
        final int LONGITUD_ALFABETO = 26, INICIO_MINUSCULAS = 97, INICIO_MAYUSCULAS = 65;
        for (char c : string.toCharArray()) {
            char charDescifrado = c;

            if (Character.isLowerCase(c)) {
                charDescifrado = (char) ((c - INICIO_MINUSCULAS - desplazamiento + LONGITUD_ALFABETO) % LONGITUD_ALFABETO + INICIO_MINUSCULAS);
                if (charDescifrado > 76 && charDescifrado < 79) {
                    charDescifrado = (char)(charDescifrado +1);
                }
            } else if (Character.isUpperCase(c)) {
                charDescifrado = (char) ((c - INICIO_MAYUSCULAS - desplazamiento + LONGITUD_ALFABETO) % LONGITUD_ALFABETO + INICIO_MAYUSCULAS);
                if (charDescifrado > 108 && charDescifrado < 111) {
                    charDescifrado = (char)(charDescifrado +1);
                }
            }
            mensaje += charDescifrado;
        }

        return mensaje;
    } // complejidad computacional: O(2N) suprimimos las constantes
    // funciona para todo, pero toma la m como l, la n como m, y no esta incluida la ñ, fue la unica forma que pude

    public static HashMap<Character, Integer> generateDictionaryOfAlphabet (){ // O(C)= lineal
        // ejercicio 5.2 hecho por Giuliano Politi
        HashMap<Character, Integer> hashMap = new HashMap<>(); // O(C)
        for (char c = 'a'; c <= 'n'; c++) { // Lleno el diccionario con las letras del alfabeto y valores asociados por ASCII
            hashMap.put(c, 0);  // Ejemplo: Valor a, Valor b, ... // O(C)
        }
        hashMap.put('ñ', 0); // metemos la ñ despues de la n
        for (char c = 'o'; c <= 'z'; c++) { // O(C)
            hashMap.put(c, 0);  // de la o hasta la z // O(C)
        }
        return hashMap; // O(C)
    }




    public static ISet copy(ISet set) {
        ISet aux = new DynamicSet();
        ISet aux2 = new DynamicSet();

        while(!set.isEmpty()) {
            int value = set.choose();
            aux.add(value);
            aux2.add(value);
            set.remove(value);
        }

        while(!aux.isEmpty()) {
            int value = aux.choose();
            set.add(value);
            aux.remove(value);
        }

        return aux2;
    }
    public static IStack copy(IStack stack) {
        IStack copy = new Stack();
        IStack copy2 = new Stack();
        while(!stack.isEmpty()) {
            int aux = stack.getTop();
            copy.add(aux);
            copy2.add(aux);
            stack.remove();
        }

        while(!copy.isEmpty()) {
            stack.add(copy.getTop());
            copy.remove();
        }

        while(!copy2.isEmpty()) {
            copy.add(copy2.getTop());
            copy2.remove();
        }
        return copy;
    }

    public static <T> GenericStack<T> copysStackGenrico(GenericStack<T> stack) { // Hecho por Simon Ottati
        GenericStack<T> copy = new GenericStack();
        GenericStack<T> copy2 = new GenericStack();

        while(!stack.isEmpty()) {
            T aux = stack.getTop();
            copy.add(aux);
            copy2.add(aux);
            stack.remove();
        }

        while(!copy.isEmpty()) {
            stack.add(copy.getTop());
            copy.remove();
        }

        while(!copy2.isEmpty()) {
            copy.add(copy2.getTop());
            copy2.remove();
        }

        return copy;
    }

    public static ISet stackToSet(IStack stack) {
        IStack copy = copy(stack);
        ISet set = new DynamicSet();

        while(!copy.isEmpty()) {
            set.add(copy.getTop());
            copy.remove();
        }

        return set;
    }

    public static <T> GenericStack<T> invertirStackGenerico(GenericStack<T> stack) { // Hecho por Simon Ottati
        GenericStack<T> aux = copysStackGenrico(stack);
        GenericStack<T> invertido = new GenericStack();

        while(!aux.isEmpty()) {
            invertido.add(aux.getTop());
            aux.remove();
        }

        return invertido;
    }

    public static <T> GenericSet<T> copiarSetGenerico(GenericSet<T> set) { // Hecho por Simon Ottati
        GenericSet<T> copy = new GenericSet();
        GenericSet<T> copy2 = new GenericSet();

        Object aux;
        while(!set.isEmpty()) {
            aux = set.choose();
            copy.add((T) aux);
            copy2.add((T) aux);
            set.remove((T) aux);
        }

        while(!copy.isEmpty()) {
            aux = copy.choose();
            set.add((T) aux);
            copy.remove((T) aux);
        }

        while(!copy2.isEmpty()) {
            aux = copy2.choose();
            copy.add((T) aux);
            copy2.remove((T) aux);
        }

        return copy;
    }

    public static List<Coordenada> generarCoordenadas(double maxX, double maxY) { // Hecho por Simon Ottati
        List<Coordenada> coordenadas = new ArrayList();
        Random rand = new Random();

        for(int i = 0; i < 1000; ++i) {
            double x = maxX * rand.nextDouble();
            double y = maxY * rand.nextDouble();
            coordenadas.add(new Coordenada(x, y));
        }

        return coordenadas;
    }

    public static double aproximarPi(Montecarlo montecarlo) { // Hecho por Simon Ottati
        int numPuntos = montecarlo.getCantidadDePuntos();
        Random rand = new Random();
        int puntosDentroCirculo = 0;

        for(int i = 0; i < numPuntos; ++i) {
            double x = rand.nextDouble();
            double y = rand.nextDouble();
            if (x * x + y * y <= 1.0) {
                ++puntosDentroCirculo;
            }
        }

        return 4.0 * (double)puntosDentroCirculo / (double)numPuntos;
    }
}
