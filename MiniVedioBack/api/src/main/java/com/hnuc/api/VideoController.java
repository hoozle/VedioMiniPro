package com.hnuc.api;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hnuc.common.entity.MyPage;
import com.hnuc.common.enums.VideoStatusEnum;
import com.hnuc.common.util.Constant;
import com.hnuc.common.util.ConvertVedioUtil;
import com.hnuc.common.util.JSONResult;
import com.hnuc.common.util.UUIDUtil;
import com.hnuc.dao.CommentMapper;
import com.hnuc.pojo.BGM;
import com.hnuc.pojo.Comment;
import com.hnuc.pojo.VO.CommentVO;
import com.hnuc.pojo.VO.VideoVO;
import com.hnuc.pojo.Video;
import com.hnuc.service.BgmService;
import com.hnuc.service.VideoService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController extends BaseController{


    @Autowired
    BgmService bgmService;

    @Autowired
    VideoService videoService;

    @Autowired
    ConvertVedioUtil convertVedioUtil;

    @PostMapping("/upload")
    public JSONResult uploadVideo(String userID, String bgmID, String desc, double videoSeconds,
                                  int videoHeight, int videoWidth, @RequestParam("videoFile") MultipartFile[] files) throws IOException {

        String videoPath = "/" + userID + "/video";
        String coverPath = "/" + userID + "/videoCover";

        Video video = new Video();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File videoFile = null;
        BGM bgm = null;
        String bgmRealPath = "";
        String videoRealPath = "";
        String coverRealPath = "";
        String fileNamePrefix = "";

        try {
            if(null != files){
                String fileName = files[0].getOriginalFilename();
                String [] fileNameItem = fileName.split("\\.");
                for(int i = 0; i<fileNameItem.length; i++){
                    fileNamePrefix += fileNameItem[i];
                }
                coverPath += "/" + fileNamePrefix + ".jpg";
                videoPath +=  "/" + fileName;
                coverRealPath = Constant.USER_DATA_ROOT_PATH + coverPath;
                videoRealPath = Constant.USER_DATA_ROOT_PATH + videoPath;
                videoFile = new File(videoRealPath);
                if(null == videoFile.getParentFile() || (!videoFile.getParentFile().isDirectory())){
                    videoFile.getParentFile().mkdirs();
                }
                inputStream  = files[0].getInputStream();
                outputStream = new FileOutputStream(videoFile);

                byte []buffer = new byte[1024];
                int len = 0;

                while((len = inputStream.read(buffer)) > 0){
                    outputStream.write(buffer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != outputStream) {
                outputStream.flush();
                outputStream.close();
            }
        }

        if(!StringUtils.isBlank(bgmID)){
            bgm = bgmService.queryBGMbyID(bgmID);
            if(null != bgm) {
                String tempVideoPath = videoRealPath;
                videoPath = "/" + userID + "/video/" + UUIDUtil.getUUID() + ".mp4";
                videoRealPath = Constant.USER_DATA_ROOT_PATH  + videoPath;
                bgmRealPath = Constant.USER_DATA_ROOT_PATH + bgm.getPath();
                convertVedioUtil.mergeVedioBgm(tempVideoPath, bgmRealPath, videoRealPath,videoSeconds);
                videoFile.delete();
                video.setAudioId(bgmID);
            }
        }

        File coverFile = new File (coverRealPath);
        if(null == coverFile.getParentFile() || !(coverFile.getParentFile().isDirectory())){
            coverFile.getParentFile().mkdirs();
        }

        convertVedioUtil.fetchVideoCover(videoRealPath, coverRealPath);

        video.setUserId(userID);
        video.setVideoDesc(desc);
        video.setVideoHeight(videoHeight);
        video.setVideoWidth(videoWidth);
        video.setVideoPath(videoPath);
        video.setVideoSeconds((float) videoSeconds);
        video.setCreateTime(new Date(System.currentTimeMillis()));
        video.setCoverPath(coverPath);
        video.setStatus(VideoStatusEnum.SUCCESS.getValue());
        video.setLikeCounts((long)0);

        videoService.addVideo(video);

        return JSONResult.retOK(video);
    }

    @GetMapping("/queryAll")
    public JSONResult queryAllVideo(Integer page, String searchWord,String  userID){
        if(null == page){
            page = 1;
        }

        PageHelper.startPage(page, Constant.MAX_PAGE_DATA_NUM);

        //保存搜索词
        videoService.saveSearchRecord(searchWord);

        List<VideoVO> videos = videoService.queryAllVideo(searchWord,userID);
        PageInfo pageInfo = new PageInfo(videos);

        MyPage resultPage= new MyPage();
        setMyPage(resultPage, pageInfo);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("videos",videos);
        jsonObject.put("page",resultPage);

        return JSONResult.retOK(jsonObject);
    }

    @GetMapping("/queryMyLike")
    public JSONResult queryMyLike(Integer page, String userID){
        if(null == page){
            page = 1;
        }
        PageHelper.startPage(page, Constant.MAX_PAGE_DATA_NUM);
        List<VideoVO> videos = videoService.queryLikeVideo(userID);
        PageInfo pageInfo = new PageInfo(videos);

        MyPage resultPage= new MyPage();
        setMyPage(resultPage, pageInfo);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("videos",videos);
        jsonObject.put("page",resultPage);

        return JSONResult.retOK(jsonObject);
    }

    @GetMapping("/queryFollowerVideos")
    public JSONResult queryFollowerVideo(Integer page ,String userID){
        if(null == page){
            page = 1;
        }
        PageHelper.startPage(page, Constant.MAX_PAGE_DATA_NUM);
        List<VideoVO> videos = videoService.queryFollowerVideo(userID);
        PageInfo pageInfo = new PageInfo(videos);

        MyPage resultPage= new MyPage();
        setMyPage(resultPage, pageInfo);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("videos",videos);
        jsonObject.put("page",resultPage);

        return JSONResult.retOK(jsonObject);
    }


    @GetMapping("/queryHotWord")
    public JSONResult queryHotWord(){
        List<String> hotWords = videoService.queryHotWord(Constant.MAX_PAGE_DATA_NUM);
        return JSONResult.retOK(hotWords);
    }

    @GetMapping("/queryTipWord")
    public JSONResult queryTipWord(String content){
        List<String> tipWords = videoService.queryTipWord(content,Constant.MAX_PAGE_DATA_NUM);
        return JSONResult.retOK(tipWords);
    }

    @GetMapping("/getLikeStatus")
    public JSONResult getLikeStaus(String userID, String videoID){
        return JSONResult.retOK(videoService.queryIsLikeVideo(userID, videoID));
    }

    @PostMapping("/likeVideo")
    public JSONResult updateLikeStatus(String userID, String videoID, boolean isLike){
        if(videoService.updateLikeStatus(userID, videoID, isLike)){
            return JSONResult.retOK(null);
        }else{
            return JSONResult.errorMsg("输入的参数有误~！");
        }
    }

    @PostMapping("/commentVideo")
    public JSONResult commentVideo(@RequestBody Comment comment){
        comment = videoService.addComment(comment);
        if(null==comment){
            return new JSONResult(500,"评论添加出错！",null);
        }else{
            return JSONResult.retOK(null);
        }
    }
    @GetMapping("/queryComments")
    public JSONResult queryAllComments(String videoID, Integer page){
        if(null == page){
            page = 1;
        }
        PageHelper.startPage(page, Constant.MAX_PAGE_DATA_NUM);

        List<CommentVO> comments = videoService.queryAllComment(videoID);

        PageInfo pageInfo = new PageInfo(comments);

        MyPage resultPage= new MyPage();
        setMyPage(resultPage, pageInfo);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("page", resultPage);
        jsonObject.put("comments",comments);

        return JSONResult.retOK(jsonObject);
    }

    private void setMyPage(MyPage resultPage, PageInfo pageInfo){
        resultPage.setCurrentPage(pageInfo.getPageNum());
        resultPage.setPageSize(Constant.MAX_PAGE_DATA_NUM);
        resultPage.setTotalNum(pageInfo.getTotal());
        resultPage.setTotalPage(pageInfo.getPages());
    }



}
