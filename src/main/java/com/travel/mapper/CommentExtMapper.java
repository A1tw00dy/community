package com.travel.mapper;

import com.travel.model.Comment;
import com.travel.model.CommentExample;
import com.travel.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommentExtMapper {

    int incCommentCount(Comment comment);
}