package service;
import java.io.IOException;
import java.util.logging.*;
import java.util.logging.FileHandler;

public class LoggerConfig {
    private static final Logger logger = Logger.getLogger(LoggerConfig.class.getName());

    static {
        try {
            // Налаштування файлу для зберігання логів з режимом дозапису
            Handler fileHandler = new FileHandler("app_logs.log", 1024 * 1024, 1, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Налаштування рівня логування
            fileHandler.setLevel(Level.INFO);
            logger.setLevel(Level.ALL);

            // Додатковий обробник для надсилання email при критичних помилках
            Handler emailHandler = new EmailHandler();
            emailHandler.setLevel(Level.SEVERE);
            logger.addHandler(emailHandler);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to initialize logger handler", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
