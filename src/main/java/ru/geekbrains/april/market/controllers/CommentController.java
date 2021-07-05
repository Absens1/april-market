package ru.geekbrains.april.market.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.april.market.dtos.CommentDto;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.services.CommentService;
import ru.geekbrains.april.market.services.UserService;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping
    public List<CommentDto> getAllComments(@RequestParam Long productId) {
        return commentService.findAllByProductId(productId);
    }

    @PostMapping
    public CommentDto createNewComment(Principal principal, @RequestParam Long productId, @RequestParam String comment) throws Exception {
        User user = userService.findByUsername(principal.getName()).get();
        return commentService.createNewComment(user, productId, comment);
    }
}
