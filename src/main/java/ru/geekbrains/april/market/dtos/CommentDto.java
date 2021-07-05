package ru.geekbrains.april.market.dtos;

import lombok.Data;
import ru.geekbrains.april.market.models.Comment;

@Data
public class CommentDto {
    private Long id;

    private String username;

    private String comment;

    public CommentDto(Comment comment) {
        this.id =  comment.getId();
        this.username = comment.getUser().getUsername();
        this.comment = comment.getComment();
    }
}
