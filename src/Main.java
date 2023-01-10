import java.util.*;

public class Main {

        private static String[] caracteres = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z", "!", "@", "#", "$", "%", "&", "*",
                "(", ")", "-", "=", "_", "+", "{", "[", "]", "}", ".", ",",
                ":", "/", "?"
        };

        private static ArrayList<String> senhas = new ArrayList();
        private static StringBuilder senha;
        private static int tamanho = 50;

        private static String gerarSenha() {
            senha = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                int posicao = (int) (Math.random() * caracteres.length);
                senha.append(caracteres[posicao]);
            }
            return senha.toString();
        }


        public static void main(String[] args) {
            for (int i = 0; i < 10; i++){
                senhas.add(gerarSenha());
                System.out.println(senhas.get(i));
            }
        }

}
