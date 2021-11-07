
import com.cofeeBin.Application;
import com.cofeeBin.service.JwtService;
import com.cofeeBin.service.JwtServiceImpl;
import com.cofeeBin.web.dto.KakaoLoginDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TokenTest {



    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private JwtServiceImpl jwtService;

    @Test
    public void TokenDecodetests() throws Exception {
        KakaoLoginDto kakaoLoginDto = new KakaoLoginDto("010-2235-1234","email@naver.com");
        String token = jwtService.makeJwt(kakaoLoginDto);
        logger.info("{} 토큰",token);
        logger.info("{} 토큰",jwtService.checkJwt(token));
        logger.info("{} : 이메일",  jwtService.getUserEmail(token));


    }

    @Test
    public void testset(){


    }

}
