package page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    public static final String BASE_URL = "https://hermes-dev.devteam.win/american-burger-pizza-house-augsburg/159";
    public static Logger logger;

    public BasePage() {
        logger = LoggerFactory.getLogger(BasePage.class);
    }
}