package log.generator;

/**
 * Définit un générateur de valeurs de types primitifs, produisant
 * des résultats de manière aléatoire.
 */
public class RandomGenerator {
    // COMMANDES
    /**
     * Construit un nouvel entier, dont la valeur est comprise
     * dans l'intervalle [a, b].
     *
     * @param a Le minimum de l'intervalle
     * @param b Le maximum de l'intervalle
     *
     * @return Un nombre entier compris entre a et b, au sens large.
     */
    public int createInt(int a, int b) {
        assert a < b;

        return a + (int) (Math.random() * (b - a + 1));
    }

    /**
     * Construit un nouveau réel (à précision double), dont la valeur est comprise
     * dans l'intervalle ]a, b[.
     *
     * @param a Le minimum de l'intervalle
     * @param b Le maximum de l'intervalle
     *
     * @return Un nombre réel compris entre a et b, au sens large.
     */
    public double createDouble(double a, double b) {
        assert a < b;

        return a + (Math.random() * (b - a));
    }

    /**
     * Construit une nouvelle chaîne de taille donnée, composé de lettres comprises
     * dans l'intervalle de caractères donné.
     *
     * @param length La taille de la chaîne souhaitée
     *
     * @return Une chaîne de caractères compris entre min et max,
     * (au sens de la valeur ASCII) de taille length;
     */
    public String createString(int length, char min, char max) {
        assert length > 0;
        assert min < max;

        StringBuilder build = new StringBuilder(); {
            for (int k = 0; k < length; ++k) {
                build.append(min + createInt(0, max - min));
            }
        }

        return build.toString();
    }
}
