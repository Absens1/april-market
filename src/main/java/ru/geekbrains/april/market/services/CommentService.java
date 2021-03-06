package ru.geekbrains.april.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.dtos.CommentDto;
import ru.geekbrains.april.market.models.Comment;
import ru.geekbrains.april.market.models.User;
import ru.geekbrains.april.market.repositories.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductService productService;

    public List<CommentDto> findAllByProductId(Long productId) {
        return commentRepository.findAllByProductId(productId).stream().map(CommentDto::new).collect(Collectors.toList());
    }

    public CommentDto createNewComment(User user, Long productId, String comment) {
        Comment c = new Comment();
        c.setUser(user);
        c.setComment(comment);
        c.setProduct(productService.findById(productId).get());
        commentRepository.save(c);
        return new CommentDto(c);
    }
}