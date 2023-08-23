import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardTest {
    @Test
    public void positiveTest() {
        Calendar calendar = new Calendar();
        open("http://localhost:9999/");
        SelenideElement form = $("form");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").setValue(calendar.calc());


    }

}
