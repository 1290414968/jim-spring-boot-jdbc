package webflux;

import domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import repository.UserRepository;

@Component
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        // 在 Spring Web MVC 中使用 @RequestBody
        // 在 Spring Web Flux 使用 ServerRequest
        // Mono<User> 类似于 Optional<User>
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        // map 相当于 转化工作
        Mono<Boolean> booleanMono = userMono.map(userRepository::save);
        return ServerResponse.ok().body(booleanMono,Boolean.class);
    }


}
