package views.logger.services;

public class DebugLogger {

        static final String RESET_COLOR = "\u001B[0m";
    static final String ERROR_COLOR = "\u001B[31m";
    static final String SUCCESS_COLOR = "\u001B[32m";
    static final String DEBUG_YELLOW = "\u001B[33m";

    private static DebugLogger singleton = null;

    public static DebugLogger getLogger() {
        if (singleton == null) {
            return new DebugLogger();
        }
        else {
            return singleton;
        }
    }

    // log warning message
    public void printInfo(String message) {
        System.out.println(DEBUG_YELLOW + "INFO: " + message + RESET_COLOR + "\n\n");
    }

    // log success message
    public   void logSuccess(String message) {
        System.out.println(SUCCESS_COLOR + "✅ SUCCESS: " + message + RESET_COLOR + "\n\n");
    }

    // log error message
    public   void logError(String message) {
        System.out.println(ERROR_COLOR + "❌ ERROR: " + message + RESET_COLOR + "\n\n");
    }
    
}
