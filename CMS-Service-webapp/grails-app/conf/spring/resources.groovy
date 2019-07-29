// Place your Spring DSL code here
import org.springframework.security.authentication.encoding.Md5PasswordEncoder

beans = {
     passwordEncoder(Md5PasswordEncoder)
}
