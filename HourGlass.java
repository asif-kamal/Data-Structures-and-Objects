public class HourGlass {

    public static void buildHourGlass() {
        /*
         * \::::::::/
         *  \::::::/
         *   \::::/
         *    \::/
         *    ||
         */

        System.out.println("|\"\"\"\"\"\"\"\"\"\"|");
        for(int line = 0; line <4 ; line++) {
            for (int i = 0; i < line +1; i++) {
                
              System.out.print(" ");
            }
            System.out.print("\\");
            for (int i = 0; i < 8 - (2*line); i++) {
                
                System.out.print(":");
              }

            System.out.print("/");
            System.out.println();
        }
        System.out.println("     ||");

        for(int line = 0; line < 4 ; line++) {
            for (int i = 0; i < 8 - (line +1); i++) {
                
              System.out.print(" ");
            }
            System.out.print("/");
            for (int i = 0; i < 8 - (2*line); i++) {
                
                System.out.print(":");
              }

            System.out.print("\\");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        buildHourGlass();
    }
}
