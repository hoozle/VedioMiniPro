package com.hnuc.service;


import com.hnuc.pojo.User;
import com.hnuc.pojo.UserReport;

public interface UserService {
	
	/**
	 * @Description: 判断用户名是否存在
	 */
	public boolean queryUsernameIsExist(String username);
	
	/**
	 * @Description: 保存用户(用户注册)
	 */
	public void saveUser(User user);
	
	/**
	 * @Description: 用户登录，根据用户名和密码查询用户
	 */
	public User queryUserForLogin(String username, String password);
	
	/**
	 * @Description: 用户修改信息
	 */
	public void updateUserInfo(User user);
	
	/**
	 * @Description: 查询用户信息
	 */
	public User queryUserInfo(String userId);
	
	/**
	 * @Description: 查询用户是否喜欢点赞视频
	 */
	public boolean isUserLikeVideo(String userId, String videoId);
	
	/**
	 * @Description: 增加用户和粉丝的关系
	 */
	public void saveUserFanRelation(String userId, String fanId);
	
	/**
	 * @Description: 删除用户和粉丝的关系
	 */
	public void deleteUserFanRelation(String userId, String fanId);
	
	/**
	 * @Description: 查询用户是否关注
	 */
	public boolean queryIfFollow(String userId, String fanId);
	
	/**
	 * @Description: 举报用户
	 */
	public void reportUser(UserReport userReport);
}
