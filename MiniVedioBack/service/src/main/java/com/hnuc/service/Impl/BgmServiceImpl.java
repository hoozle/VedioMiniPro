package com.hnuc.service.Impl;

import com.hnuc.dao.BGMMapper;
import com.hnuc.pojo.BGM;
import com.hnuc.service.BgmService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BgmServiceImpl implements BgmService {

    @Autowired
    public BGMMapper bgmMapper;


    @Override
    public List<BGM> queryAllBgm() {
        return bgmMapper.selectAllBgm();
    }

    @Override
    public BGM queryBGMbyID(String bgmId) {
        if(StringUtils.isBlank(bgmId)){
            return null;
        }else{
            return bgmMapper.selectByPrimaryKey(bgmId);
        }
    }
}
