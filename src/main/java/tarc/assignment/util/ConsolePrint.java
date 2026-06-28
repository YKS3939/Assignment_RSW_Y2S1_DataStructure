package tarc.assignment.util;

public class ConsolePrint {

    private static final String FONT_BLACK = "\u001B[0m";
    private static final String FONT_RED= "\u001B[31m";
    private static final String FONT_GREEN  = "\u001B[32m";
    private static final String FONT_YELLOW = "\u001B[33m";
    private static final String FONT_BLUE   = "\u001B[94m";
    private static final String FONT_LINE = "\u001B[96m";
    public static  final String LINE=FONT_LINE+"==========================================="+ FONT_BLACK;


    /**
     * @param {string...}
     */
    public static void menu(String title,String... messages){
        System.out.println(LINE);
        System.out.println(FONT_BLUE +title+ FONT_BLACK);
        System.out.println(LINE);
        for (String message : messages) {
            System.out.println(FONT_BLUE +"\t" + message+ FONT_BLACK);
        }
        System.out.println(LINE);
//        System.out.print("Option :");
    }
    /**
     * @param {string...}
     */
    public static void print(String... messages){
        for (String message : messages) {
            System.out.print(message+ FONT_BLACK);
        }
    }
    public static void println(String... messages){
        for (String message : messages) {
            System.out.println(FONT_BLUE +"  " + message+ FONT_BLACK);
        }
    }

    /**
     * @param {string}
     */
    public static void error(String message){
        System.out.println(FONT_RED + "[ERROR] " + message + FONT_BLACK);
    }

    /**
     * @param {string}
     */
    public static void success(String message){
        System.out.println(FONT_GREEN + message + FONT_BLACK);
    }

    /**
     * @param {string}
     */
    public static void warning(String message){
        System.out.println(FONT_YELLOW + "[WARNING] " + message + FONT_BLACK);
    }

    /**
     * @param {string}
     */
    public static void clear() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void drawLine(){
        System.out.println(LINE);
    }
}
