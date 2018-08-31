package rc;


import org.springframework.web.bind.annotation.*;
import rc.model.JwtUser;
import rc.security.JwtGenerator;

import java.util.stream.DoubleStream;

@RestController
@RequestMapping("/token")
public class TokenController {
   private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public  String generate(@RequestBody final JwtUser jwtUser){

//        JwtGenerator jwtGenerator = new JwtGenerator();

        return jwtGenerator.generate(jwtUser);
    }
}
