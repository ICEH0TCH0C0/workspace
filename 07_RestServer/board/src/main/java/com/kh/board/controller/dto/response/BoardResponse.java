package com.kh.board.controller.dto.response;

import com.kh.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


public class BoardResponse {

    @Getter
    @Setter
    @Builder
    public static class SimpleDto {
        private String boardId;
        private String title;
        private String memberEmail;
        private LocalDateTime createdAt;

        public static SimpleDto of(Board board) {
            return  SimpleDto.builder()
                    .boardId(board.getBoardId())
                    .title(board.getTitle())
                    .memberEmail(board.getMemberEmail())
                    .createdAt(board.getCreatedAt())
                    .build();
        }
    }
}
