package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {
    @Test
    void conversionService() {
        //등록 (다른 Spring Bean 에 빼놓고 사용)
        DefaultConversionService defaultConversionService = new DefaultConversionService();
        defaultConversionService.addConverter(new StringToIntegerConverter());
        defaultConversionService.addConverter(new IntegerToStringConverter());
        defaultConversionService.addConverter(new StringToIpPortConverter());
        defaultConversionService.addConverter(new IpPortToStringConverter());

        //사용
        assertThat(defaultConversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(defaultConversionService.convert(10, String.class)).isEqualTo("10");

        IpPort ipPort1 = new IpPort("127.0.0.1", 8080);
        String source1 = "127.0.0.1:8080";

        IpPort result1 = defaultConversionService.convert(source1, IpPort.class);
        assertThat(result1).isEqualTo(ipPort1);

        String result2 = defaultConversionService.convert(ipPort1, String.class);
        assertThat(result2).isEqualTo(source1);

    }
}
