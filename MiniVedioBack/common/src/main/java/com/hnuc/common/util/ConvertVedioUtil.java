package com.hnuc.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertVedioUtil {

    @Value("D:/ffmpeg-20190117-aceb913-win64-static/bin/ffmpeg.exe")
    private String ffmpeg;

    public ConvertVedioUtil(String ffmpeg) {
        this.ffmpeg = ffmpeg;
    }

    public ConvertVedioUtil(){

    }

    public void mergeVedioBgm(String vedioInputPath,String bgmInputPath,String vedioOutputPath,double second) throws IOException {
        List<String> command = new ArrayList<String>();

        command.add(ffmpeg);

        command.add("-i");
        command.add(vedioInputPath);

        command.add("-i");
        command.add(bgmInputPath);

        command.add("-t");
        command.add(String.valueOf(second));

        command.add("-y");
        command.add(vedioOutputPath);

        createConvertProcess(command);

    }


    public void fetchVideoCover(String videoInputPath, String coverOutputPath) throws IOException {
        List<String> command = new ArrayList<String>();

        command.add(ffmpeg);
        // 指定截取第1秒
        command.add("-ss");
        command.add("00:00:01");

        command.add("-y");
        command.add("-i");
        command.add(videoInputPath);

        command.add("-vframes");
        command.add("1");

        command.add(coverOutputPath);

        createConvertProcess(command);
    }

    private void createConvertProcess(List<String> command) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        //防止创建的子线程的标准错误流和标准输出流的缓冲区buffer填满造成阻塞的问题，要对这两个流进行处理
        //这里采用将子进程所产生的任何错误输出由该对象的start()方法启动将与标准输出合并

        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(inputStreamReader);

        String line = "";

        while(null != (line = br.readLine())){

        }

        //关闭流
        if(null != br){
            br.close();
        }

        if(null != inputStreamReader){
            inputStreamReader.close();
        }

        if(null != inputStream){
            inputStream.close();
        }

    }

    public static void main(String[] args) {

        ConvertVedioUtil vedioUtil = new ConvertVedioUtil("D:\\ffmpeg-20190117-aceb913-win64-static\\bin\\ffmpeg.exe");
        try {
            vedioUtil.mergeVedioBgm("C:\\Users\\62509\\Desktop\\c4080d7e0e6a112682d029fbac147f4a.mp4","D:\\miniVedioData\\CityOfSky.mp3",
                    "C:\\Users\\62509\\Desktop\\merageVedio.mp4",15);
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {

        }

    }
}
