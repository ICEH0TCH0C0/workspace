package com.kh.jpa.service;

import com.kh.jpa.dto.BoardDto;
import com.kh.jpa.entity.Board;
import com.kh.jpa.entity.Member;
import com.kh.jpa.entity.Tag;
import com.kh.jpa.enums.Status;
import com.kh.jpa.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardServiceJpa implements BoardService{

    private final BoardJPARepository boardJPARepository;
    private final MemberJPARepository memberJPARepository;
    private final TagJPARepository tagJPARepository;
    private final String FILE_PATH = "C:\\devtool\\upload";

    @Override
    public Long createBoard(BoardDto.Create createDto) throws IOException {
        Member member = memberJPARepository.findById(createDto.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다"));

        String changeName = null;
        String originName = null;

        if(createDto.getFile() != null && !createDto.getFile().isEmpty()) {
            originName = createDto.getFile().getOriginalFilename();
            changeName = UUID.randomUUID().toString() + "_" + originName;

            File uploadDir = new File(FILE_PATH);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            createDto.getFile()
                    .transferTo(new File(FILE_PATH + changeName));
        }

        Board board = createDto.toEntity();
        board.changeMember(member);
        board.changeFile(originName, changeName);

        if(createDto.getFile() != null && !createDto.getFile().isEmpty()) {
            for(String tagName : createDto.getTags()) {
                Tag tag = tagJPARepository.findByTagName(tagName)
                        .orElseGet(() -> tagJPARepository.save(Tag.builder()
                                .tagName(tagName).build()));
                board.addTag(tag);
            }
        }

        boardJPARepository.save(board);
        return board.getBoardNo();
    }

    @Override
    public BoardDto.Response getBoardDetail(Long boardId) {
        return null;
    }

    @Override
    public Page<BoardDto.Response> getBoardList(Pageable pageable) {
        Page<Board> page = boardJPARepository.findByBoardStatus(Status.Y, pageable);
        return page.map(board -> BoardDto.Response.ofSimple(
                board.getBoardNo(),
                board.getBoardTitle(),
                board.getBoardOriginName(),
                board.getBoardCount(),
                board.getBoardWriter().getUserId(),
                board.getCreatedAt()
        ));
    }

    @Override
    public BoardDto.Response updateBoard(Long boardId, BoardDto.Update updateDto) throws IOException {
        Board board = boardJPARepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글입니다."));

        String originName = board.getBoardOriginName();
        String changeName = board.getBoardChangeName();

        if(updateDto.getFile() != null && !updateDto.getFile().isEmpty()) {
            originName = updateDto.getFile().getOriginalFilename();
            changeName = UUID.randomUUID().toString() + "_" + originName;

            File uploadDir = new File(FILE_PATH);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            updateDto.getFile()
                    .transferTo(new File(FILE_PATH + changeName));
        }

        board.putUpdate(
                updateDto.getBoard_title(),
                updateDto.getBoard_content(),
                originName,
                changeName
        );

        board.clearTag();
        if (updateDto.getTags() != null && !updateDto.getTags().isEmpty()) {
            for (String tagName : updateDto.getTags()) {
                Tag tag = tagJPARepository.findByTagName(tagName)
                        .orElseGet(() -> tagJPARepository.save(Tag.builder()
                                .tagName(tagName).build()));
                board.addTag(tag);
            }
        }

        List<String> tagNames = board.getBoardTags()
                .stream()
                .map(boardTag -> boardTag.getTagId().getTagName())
                .toList();

        return BoardDto.Response.of(
                board.getBoardNo(),
                board.getBoardTitle(),
                board.getBoardContent(),
                board.getBoardOriginName(),
                board.getBoardChangeName(),
                board.getBoardCount(),
                board.getBoardWriter().getUserId(),
                board.getBoardWriter().getUserName(),
                board.getCreatedAt(),
                tagNames

        );
    }

    @Override
    public void deleteBoard(Long boardId) {
        Board board = boardJPARepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글입니다"));

        if(board.getBoardChangeName() != null) {
            new File(FILE_PATH + board.getBoardChangeName());
        }

        boardJPARepository.delete(board);
    }
}
