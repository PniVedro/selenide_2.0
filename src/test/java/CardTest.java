import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardTest {
    private String generateDate() {
        return LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    @org.junit.jupiter.api.Test
    void deliveryCardTest () {
        open("http://localhost:9999");

        $("[data-test-id=city] input").setValue("Москва");
        String currentDate = generateDate();
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").sendKeys(currentDate);

        $("[data-test-id=name] input").setValue("Иван Иванов");
        $("[data-test-id=phone] input").setValue("+79999999999");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + currentDate));
    }
}
