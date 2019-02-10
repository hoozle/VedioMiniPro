package com.hnuc.api;

import com.hnuc.common.util.Constant;
import com.hnuc.common.util.JSONResult;
import com.hnuc.pojo.User;
import com.hnuc.pojo.VO.UserVO;
import com.hnuc.service.UserService;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @GetMapping("/queryUser")
    public JSONResult queryUserByUserID(String userID, String fanID){
        if(StringUtils.isBlank(userID)){
            return JSONResult.errorMsg("用户ID不能为空！");
        }
        User user = userService.queryUserInfo(userID);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        userVO.setFollowing(userService.queryIfFollow(userID, fanID));

        if(null == user){
            return JSONResult.errorMsg("用户不存在！");
        }else{
            return JSONResult.retOK(userVO);
        }
    }

    @PostMapping("/uploadFace")
    public JSONResult upLoadFaceIcon(String userID,
                                     @RequestParam("file") MultipartFile[] files) throws IOException {
        if(StringUtils.isBlank(userID)){
            return JSONResult.errorMsg("用户ID不能为空！");
        }

        if(null == files || 0 == files.length ||
                StringUtils.isBlank(files[0].getOriginalFilename())){
            return JSONResult.errorMsg("上传的文件为空！");
        }
        //获得文件名
        String fileName = files[0].getOriginalFilename();
        //用户保存头像的相对路径
        String uploadPathDB = "/" + userID + "/faceIcon/"+ fileName;
        //头像的存储路径
        String realPath = Constant.USER_DATA_ROOT_PATH + uploadPathDB;

        //输入流
        InputStream in = null;
        //文件输出流
        OutputStream out = null;

        try {
            //创建文件
            File iconFile = new File(realPath);

            if((null == iconFile.getParentFile()) ||
                    (!iconFile.getParentFile().isDirectory())){
                iconFile.getParentFile().mkdirs();
            }

            //输入流
            in = files[0].getInputStream();
            //文件输出流
            out = new FileOutputStream(iconFile);

            //写文件
            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = in.read(buffer)) > 0){
                out.write(buffer);
            }

        }catch (Exception e){
            e.printStackTrace();
            return JSONResult.errorMsg("上传出错！");
        }finally {
            if(out != null)
            {
                out.flush();
                out.close();
            }
        }

        User user = new User();
        user.setId(userID);
        user.setFaceImage(uploadPathDB);
        userService.updateUserInfo(user);

        return JSONResult.retOK(uploadPathDB);
    }


    @PostMapping("/followUser")
    public JSONResult  followUser(String userID, String fanID, boolean follow){
        if(follow){
            userService.saveUserFanRelation(userID, fanID);
        }else{
            userService.deleteUserFanRelation(userID, fanID);
        }
        User user = userService.queryUserInfo(userID);

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("fansCounts",user.getFansCounts());
        jsonObject.put("isFollow",follow);
        return JSONResult.retOK(jsonObject);
    }
}