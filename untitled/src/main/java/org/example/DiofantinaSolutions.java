package org.example;

public class DiofantinaSolutions {
    public long x;
    public long y;
    public  DiofantinaSolutions(long x,long y) {
        this.x=x;
        this.y=y;
    }

    //CODICE 1


    // Metodo per risolvere l'equazione diofantea lineare ax + by = c

    public static DiofantinaSolutions solveDiofantina(long a, long b, long c) {
        // Algoritmo di Euclide esteso per trovare il GCD e i coefficienti x, y
        long[] extendedEuclideanAlgorithm = new long[]{a, 1, 0};
        while (b != 0) {

            long temp = b;

            b = a % b;

            a = temp;



            long tempX = extendedEuclideanAlgorithm[2];

            extendedEuclideanAlgorithm[2] = extendedEuclideanAlgorithm[1] - (a / temp) * extendedEuclideanAlgorithm[2];

            extendedEuclideanAlgorithm[1] = tempX;

        }



        long gcd = extendedEuclideanAlgorithm[0];

        long xCoeff = extendedEuclideanAlgorithm[1];

        long yCoeff = extendedEuclideanAlgorithm[2];



        // Controlla se c è multiplo del GCD

        if (c % gcd != 0) {

            // L'equazione non ha soluzioni intere

            return null;

        }



        // Trova una soluzione particolare

        long x0 = xCoeff * (c / gcd);

        long y0 = yCoeff * (c / gcd);



        return new DiofantinaSolutions(x0, y0);

    }





    //CODICE 2



    // Metodo per risolvere un sistema di equazioni parametriche

    public static int[] solveParametricEquation(int[] coefficients, int[] constants) {

        int numVariables = coefficients.length;



        // Verifica che le dimensioni dei vettori siano coerenti

        if (numVariables == constants.length) {

            // Trova il massimo comune divisore dei coefficienti

            int gcdCoefficients = coefficients[0];

            for (int i = 1; i < numVariables; i++) {

                gcdCoefficients = gcd(gcdCoefficients, coefficients[i]);
            }



            // Verifica se il sistema è compatibile

            for (int constant : constants) {

                if (constant % gcdCoefficients != 0) {

                    return null; // Il sistema non ha soluzioni intere

                }

            }



            // Calcola le soluzioni parametriche

            int[] parameters = new int[numVariables];

            for (int i = 0; i < numVariables; i++) {

                parameters[i] = constants[i] / gcdCoefficients;

            }



            return parameters;

        } else {

            return null; // Dimensioni non valide dei vettori di input

        }

    }



    // Metodo per calcolare il massimo comune divisore (GCD) di due numeri
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


}

