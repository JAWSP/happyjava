package com.example.rest.controller;

import com.example.rest.domain.ExUser;
import com.example.rest.service.ExUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ExampleController {
    private final ExUserService exUserService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody ExUser user) {
         Long id = exUserService.createUserService(user);
        return ResponseEntity.status(201).body(id);
    }
    @GetMapping
    public ResponseEntity<List<ExUser>> getExample() {
        List<ExUser> target =  exUserService.getUsersService();
        //return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "asd").body("ㅎㅇㅎㅇ");
        //return ResponseEntity.ok().body(target);
        return ResponseEntity.ok(target);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExUser> getUserById(@PathVariable("id")Long id) {
       ExUser user = exUserService.getUSerByIdService(id);
//        if (user == null)
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        else
//            return ResponseEntity.ok(user);
        //return null;
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExUser> updateUser(@PathVariable("id")Long id, @RequestBody ExUser user) {
        ExUser target = exUserService.updateUserService(id, user);
        return ResponseEntity.ok().body(target);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        //서비스가 리스폰스 엔티티가 아니라면 이렇게 가능하다
        exUserService.deleteUserService(id);
        return ResponseEntity.noContent().build();
    }
}
