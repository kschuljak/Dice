
public class Spinner {

    public static String[] product = new String[]{
            "  %%%%%                 ",
            "   %%%%%                ",
            "    %%%%%               ",
            "     %%%%%              ",
            "      %%%%%             ",
            "       %%%%%            ",
            "        %%%%%           ",
            "         %%%%%          ",
            "          %%%%%         ",
            "           %%%%%        ",
            "            %%%%%       ",
            "             %%%%%      ",
            "              %%%%%     ",
            "               %%%%%    ",
            "                %%%%%   ",
            "                 %%%%%  ",
            "                  %%%%% ",
            "                   %%%%%"
    };

    public static String[] product2 = new String[]{
            "\n  %%%%%                 ",
            "\n   %%%%%                ",
            "\n    %%%%%               ",
            "\n     %%%%%              ",
            "\n      %%%%%             ",
            "\n       %%%%%            ",
            "\n        %%%%%           ",
            "\n         %%%%%          ",
            "\n          %%%%%         ",
            "\n           %%%%%        ",
            "\n            %%%%%       ",
            "\n             %%%%%      ",
            "\n              %%%%%     ",
            "\n               %%%%%    ",
            "\n                %%%%%   ",
            "\n                 %%%%%  ",
            "\n                  %%%%% ",
            "\n                   %%%%%"
    };

    public static String[] spinnerLine1 = new String[]{
            "\n  .-.-.   .-.-.   .",
            "\n   .-.-.   .-.-.   ",
            "\n.   .-.-.   .-.-.  ",
            "\n-.   .-.-.   .-.-. ",
            "\n.-.   .-.-.   .-.-.",
            "\n-.-.   .-.-.   .-.-",
            "\n.-.-.   .-.-.   .-.",
            "\n .-.-.   .-.-.   .-",
            "\n  .-.-.   .-.-.   .",
            "\n  .-.-.   .-.-.   .",
            "\n   .-.-.   .-.-.   ",
            "\n.   .-.-.   .-.-.  ",
            "\n-.   .-.-.   .-.-. ",
            "\n.-.   .-.-.   .-.-.",
            "\n-.-.   .-.-.   .-.-",
            "\n.-.-.   .-.-.   .-.",
            "\n .-.-.   .-.-.   .-",
            "\n  .-.-.   .-.-.   ."
    };

    public static String[] spinnerLine2 = new String[]{
            "\n / / \\ \\ / / \\ \\ / ",
            "\n\\ / / \\ \\ / / \\ \\ /",
            "\n \\ / / \\ \\ / / \\ \\ ",
            "\n\\ \\ / / \\ \\ / / \\ \\",
            "\n \\ \\ / / \\ \\ / / \\ ",
            "\n/ \\ \\ / / \\ \\ / / \\",
            "\n / \\ \\ / / \\ \\ / / ",
            "\n/ / \\ \\ / / \\ \\ / /",
            "\n / / \\ \\ / / \\ \\ / ",
            "\n / / \\ \\ / / \\ \\ / ",
            "\n\\ / / \\ \\ / / \\ \\ /",
            "\n \\ / / \\ \\ / / \\ \\ ",
            "\n\\ \\ / / \\ \\ / / \\ \\",
            "\n \\ \\ / / \\ \\ / / \\ ",
            "\n/ \\ \\ / / \\ \\ / / \\",
            "\n / \\ \\ / / \\ \\ / / ",
            "\n/ / \\ \\ / / \\ \\ / /",
            "\n / / \\ \\ / / \\ \\ / "
    };

    public static String[] spinnerLine3 = new String[]{
            "\n`-'   `-`-'   `-`-'",
            "\n-`-'   `-`-'   `-`-",
            "\n`-`-'   `-`-'   `-`",
            "\n `-`-'   `-`-'   `-",
            "\n  `-`-'   `-`-'   `",
            "\n   `-`-'   `-`-'   ",
            "\n'   `-`-'   `-`-'  ",
            "\n-'   `-`-'   `-`-' ",
            "\n`-'   `-`-'   `-`-'",
            "\n`-'   `-`-'   `-`-'",
            "\n-`-'   `-`-'   `-`-",
            "\n`-`-'   `-`-'   `-`",
            "\n `-`-'   `-`-'   `-",
            "\n  `-`-'   `-`-'   `",
            "\n   `-`-'   `-`-'   ",
            "\n'   `-`-'   `-`-'  ",
            "\n-'   `-`-'   `-`-' ",
            "\n`-'   `-`-'   `-`-'"
    };

    public static void displaySpinner(){

        StringBuilder string = new StringBuilder();
        String remove = "\b\b" + " ";

        for (int i = 0; i < product.length; i++) {

            string = string.append(product[i] + spinnerLine1[i] + spinnerLine2[i] + spinnerLine3[i] + product2[i]);
            int length = string.length();
            System.out.print(string);
            StringBuilder removeString = new StringBuilder();
            for (int j = 0; j < length; j++) {
                removeString.append(remove);
            }
            string.replace(0, length - 1, String.valueOf(removeString));
            System.out.print(string);
//            try
//            {
//                Thread.sleep(100);
//            }
//            catch (Exception ignored) {}


        }
    }

}

