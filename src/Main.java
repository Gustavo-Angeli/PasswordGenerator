public class Main {

        private static final String[] chars = {
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
                "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "!", "@",
                "#", "$", "%", "&", "*", "(", ")", "-", "=", "_", "+", "{", "[", "]", "}", ".",
                ",", ":", "/", "?", " ", "'", "\"", "<", ">", "|", "\\"
        };

        private static StringBuilder password;
        private static int size = 100;

        private static String passwordGenerator() {
            password = new StringBuilder();
            for (int i = 0; i < size; i++) {
                int position = (int) (Math.random() * chars.length);
                password.append(chars[position]);
            }
            return password.toString();
        }


        public static void main(String[] args) {
            for (int i = 0; i < 10; i++){
                System.out.println(passwordGenerator());
            }
        }

}
