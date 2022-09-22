package hello.typeconverter.formatter;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class MynumberFormatterTest {

    MynumberFormatter mynumberFormatter = new MynumberFormatter();
    @Test

    void parse() throws ParseException {
        Number result = mynumberFormatter.parse("1,000", Locale.KOREA);
        assertThat(result).isEqualTo(1000L); //Long타입 주의
    }

    @Test
    void print() {
        String result = mynumberFormatter.print(1000, Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }
}