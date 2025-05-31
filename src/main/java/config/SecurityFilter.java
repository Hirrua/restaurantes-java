package config;

import com.hirrua.api_restaurante.repositories.CustomerRepository;
import com.hirrua.api_restaurante.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final CustomerRepository customerRepository;

    public SecurityFilter(TokenService tokenService, CustomerRepository customerRepository) {
        this.tokenService = tokenService;
        this.customerRepository = customerRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token;
        var authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null) {
            token = authorizationHeader.replace("Bearer ", "");

            var login = tokenService.verifyToken(token);
            var user = customerRepository.findByEmail(login);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication); // Salvar autenticação nessa sessão
        }
        filterChain.doFilter(request, response);
    }
}
