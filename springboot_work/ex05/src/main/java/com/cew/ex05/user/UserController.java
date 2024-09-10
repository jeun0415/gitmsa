package com.cew.ex05.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("select")
    public List<User> select(){
        return userRepository.findAll();
    }

    @PostMapping("insert")
    public String insert(@Valid @RequestBody UserReqDto userReqDto){
//    public String insert(@Valid @RequestBody UserReqDto userReqDto, @RequestParam(name = "aa") String aa){
        System.out.println("실행"+userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+user);
        userRepository.save(user);
        return "ok";
    }

    @PutMapping("update")
    public String update(@Valid @RequestBody UserReqDto userReqDto){
        System.out.println("실행"+userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+user);
        userRepository.save(user);
        return "ok";
    }

    @DeleteMapping("delete/{idx}")
    public String delete(@PathVariable("idx") long idx){
        userRepository.deleteById(idx);
        return "deleted";
    }
}
