package ru.geekbrains.april.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.april.market.dtos.CommentDto;
import ru.geekbrains.april.market.dtos.ProductDto;
import ru.geekbrains.april.market.error_handling.ResourceNotFoundException;
import ru.geekbrains.april.market.models.*;
import ru.geekbrains.april.market.repositories.CommentRepository;
import ru.geekbrains.april.market.repositories.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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