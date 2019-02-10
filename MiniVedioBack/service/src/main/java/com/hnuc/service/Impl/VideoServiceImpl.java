package com.hnuc.service.Impl;

import com.hnuc.common.util.IdGenerator;
import com.hnuc.dao.*;

import com.hnuc.pojo.*;
import com.hnuc.pojo.VO.CommentVO;
import com.hnuc.pojo.VO.VideoVO;
import com.hnuc.service.VideoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    SearchRecordMapper searchRecordMapper;

    @Autowired
    UserLikeVideoMapper userLikeVideoMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommentMapper commentMapper;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String addVideo(Video video) {
        if(null != video){
            String videoID = IdGenerator.get();
            video.setId(videoID);
            videoMapper.insert(video);
            return videoID;
        }else{
            return null;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<VideoVO> queryAllVideo(String searchWord,String userID) {
        return videoMapper.selectAllVideo(searchWord,userID);
    }

    @Override
    public List<VideoVO> queryLikeVideo(String userID) {
        return videoMapper.selectLikeVideo(userID);
    }

    @Override
    public List<VideoVO> queryFollowerVideo(String userID) {
        return videoMapper.selectFollowerVideo(userID);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveSearchRecord(String searchWord) {
        if(null == searchWord || StringUtils.isBlank(searchWord)){
            return;
        }
        SearchRecord searchRecord  = searchRecordMapper.selectByContent(searchWord);

        if(null == searchRecord){
            searchRecord = new SearchRecord();
            searchRecord.setId(IdGenerator.get());
            searchRecord.setContent(searchWord);
            searchRecord.setSearchTime((long)1);
            searchRecordMapper.insert(searchRecord);
        }else{
            searchRecord.setSearchTime(searchRecord.getSearchTime() + 1);
            searchRecordMapper.updateByPrimaryKeySelective(searchRecord);
        }
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<String> queryHotWord(int count) {
        if(count <= 0){
            return null;
        }

        if(count > 10){
            count = 10;
        }

        return searchRecordMapper.selectContents(count);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<String> queryTipWord(String content, int count) {
        if(count < 0 || null == content || StringUtils.isBlank(content)){
            return  null;
        }

        if(count>10){
            count = 10;
        }

        return videoMapper.selectVideoDesc(content,count);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryIsLikeVideo(String userID, String videoID) {
        if(null == userID || null== videoID || StringUtils.isBlank(userID) || StringUtils.isBlank(videoID)){
            return false;
        }

        if(null == userLikeVideoMapper.selectByUserIDAndVideoID(userID, videoID)){
            return false;
        }else{
            return true;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateLikeStatus(String userID, String videoID, boolean isLike) {
        if(null == userID || null== videoID || StringUtils.isBlank(userID) || StringUtils.isBlank(videoID)){
            return false;
        }

        boolean ret = false;
        UserLikeVideo userLikeVideo = userLikeVideoMapper.selectByUserIDAndVideoID(userID, videoID);
        Video video = videoMapper.selectByPrimaryKey(videoID);
        if(null == video){
            return false;
        }

        User user = userMapper.selectByPrimaryKey(video.getUserId());
        if(null == user){
            return false;
        }
        if((!isLike) && (null != userLikeVideo)) {
            userLikeVideoMapper.deleteByPrimaryKey(userLikeVideo.getId());
            user.setReceiveLikeCounts(user.getReceiveLikeCounts() - 1);
            userMapper.updateByPrimaryKeySelective(user);
            ret =  true;
        }else if(isLike && (null == userLikeVideo)){
            userLikeVideo = new UserLikeVideo();
            userLikeVideo.setId(IdGenerator.get());
            userLikeVideo.setUserId(userID);
            userLikeVideo.setVideoId(videoID);
            userLikeVideoMapper.insert(userLikeVideo);
            user.setReceiveLikeCounts(user.getReceiveLikeCounts() + 1);
            userMapper.updateByPrimaryKeySelective(user);
            ret = true;
        }
        return ret;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Comment addComment(Comment comment) {
        if(null == comment || null == comment.getFromUserId()
                || null == comment.getVideoId() || null == comment.getComment()){
            return null;
        }
        comment.setId(IdGenerator.get());
        comment.setCreateTime(new Date());

        if(1 == commentMapper.insert(comment)){
            return comment;
        }

        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CommentVO> queryAllComment(String videoID) {
        if(null == videoID || StringUtils.isBlank(videoID)){
            return null;
        }

        List<CommentVO> comments =  commentMapper.selectAllComment(videoID);
        if(null!=comments) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (CommentVO comment : comments) {
                comment.setFormatTime(formatter.format(comment.getCreateTime()));
            }
        }
        return comments;
    }
}
