package com.hnuc.service;

import com.hnuc.pojo.BGM;

import java.util.List;

public interface BgmService {

    /**
     * 查询所有的背景音乐
     * @return
     */
    public List<BGM> queryAllBgm();

    /**
     * 根据BGMID查询bgm
     * @param bgmId
     * @return
     */
    public BGM queryBGMbyID(String bgmId);
}
