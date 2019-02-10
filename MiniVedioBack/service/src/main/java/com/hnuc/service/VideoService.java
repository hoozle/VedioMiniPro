package com.hnuc.service;

import com.hnuc.pojo.Comment;
import com.hnuc.pojo.SearchRecord;
import com.hnuc.pojo.VO.CommentVO;
import com.hnuc.pojo.VO.VideoVO;
import com.hnuc.pojo.Video;

import java.util.List;

public interface VideoService {

    public String addVideo(Video video);

    public List<VideoVO> queryAllVideo(String searchWord,String userID);

    public List<VideoVO> queryLikeVideo(String userID);

    public List<VideoVO> queryFollowerVideo(String userID);

    public void saveSearchRecord(String searchWord);

    public List<String> queryHotWord(int count);

    public List<String> queryTipWord(String content, int count);

    public boolean queryIsLikeVideo(String userID, String videoID);

    public boolean updateLikeStatus(String userID, String videoID, boolean isLike);

    public Comment addComment(Comment comment);

    public List<CommentVO> queryAllComment(String videoID) ;

}
