package com.pmh.org.login;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto){
        loginService.join(joinDto);
        return ResponseEntity.ok("success");
    }

    // swagger 문서에서 사용가능하게..
//    @GetMapping("/login")
//    public void redirectWithPost(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            HttpServletResponse response) throws IOException {
//        // login으로 진행해라...
//        response.sendRedirect("/login");
//    }
}
