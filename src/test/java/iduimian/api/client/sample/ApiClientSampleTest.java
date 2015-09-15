package iduimian.api.client.sample;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import iduimian.api.client.sample.dto.CreateLibRtnDto;
import iduimian.api.client.sample.dto.DeleteImgRtnDto;
import iduimian.api.client.sample.dto.DetectRtnDto;
import iduimian.api.client.sample.dto.FindImgRtnDto;
import iduimian.api.client.sample.dto.LibStatusRtnDto;
import iduimian.api.client.sample.dto.MatchRtnDto;
import iduimian.api.client.sample.dto.RegistImgRtnDto;
import iduimian.api.client.sample.dto.Score;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiClientSampleTest {
    private static Logger logger = LoggerFactory.getLogger(ApiClientSampleTest.class);
    private String libName = "testLib01";
    private ApiClientSample client;
    // 人员信息和样张id，此处简单使用map来保存.
    // 实际可以持久化到数据库或文件内
    private final Map<String, String> userInfo = new HashMap<String, String>();

    @Before
    public void setup() {
        libName = "testLib01";
        client = new ApiClientSample();
    }

    /**
     * 创建一个照片库
     */
    @Test
    public void test01_createLib() {
        // 创建一个照片库
        final CreateLibRtnDto dto = client.createLib(libName);
        logger.info("{}", dto);
    }

    /**
     * 查询照片库容量
     */
    @Test
    public void test02_getLibStatus() {
        // 创建一个照片库
        final LibStatusRtnDto dto = client.getLibStatus(libName);
        logger.debug("{}", dto);
        if (dto != null && dto.getResult().getValue() == 0) {
            logger.info("照片库{}内有{}张照片的特征文件, 共占用{}磁盘空间", libName, dto.getImg_count(), dto.getTotal_size());
        }
    }

    /**
     * 查询照片库容量
     */
    @Test
    public void test03_registImg() throws URISyntaxException {
        // 加入 4 张样张 zhourunfa_01.jpg
        final URL url = this.getClass().getClassLoader().getResource("testImages/zhourunfa_01.jpg");
        final URL url2 = this.getClass().getClassLoader().getResource("testImages/zhourunfa_02.jpg");
        final URL url3 = this.getClass().getClassLoader().getResource("testImages/zhangguorong_01.jpg");
        final URL url4 = this.getClass().getClassLoader().getResource("testImages/zhangguorong_02.jpg");
        RegistImgRtnDto dto = client.registImg(libName, new File(url.toURI()));
        // 保存人员信息和样张id
        userInfo.put(dto.getImg_id(), "周润发");
        dto = client.registImg(libName, new File(url2.toURI()));
        userInfo.put(dto.getImg_id(), "周润发");
        dto = client.registImg(libName, new File(url3.toURI()));
        userInfo.put(dto.getImg_id(), "张国荣");
        dto = client.registImg(libName, new File(url4.toURI()));
        userInfo.put(dto.getImg_id(), "张国荣");

        test02_getLibStatus();
    }

    /**
     * 查找相似的人
     */
    @Test
    public void test04_findImg() throws URISyntaxException {
        final URL url5 = this.getClass().getClassLoader().getResource("testImages/zhourunfa_03.jpg");
        final FindImgRtnDto dto = client.findImg(libName, new File(url5.toURI()));
        if (dto != null && dto.getScores() != null && dto.getScores().size() > 0) {
            for (final Score score : dto.getScores()) {
                System.out.println(score);
                if (userInfo.containsKey(score.getImg_id())) {
                    logger.info("照片{}中的人物可能是{}, 可能性为{}", "zhourunfa_03.jpg", userInfo.get(score.getImg_id()),
                            score.getScore());
                }
            }
        }
    }


    /**
     * 比较2张照片有多大的相似度
     */
    @Test
    public void test05_matchImg() throws URISyntaxException {
        final URL url = this.getClass().getClassLoader().getResource("testImages/zhourunfa_01.jpg");
        final URL url2 = this.getClass().getClassLoader().getResource("testImages/zhourunfa_02.jpg");
        final MatchRtnDto dto = client.matchImg(new File(url.toURI()), new File(url2.toURI()));
        logger.info("2张照片的相似度为 {}", dto.getScore());
    }

    /**
     * 检测照片中的头脸部位置
     */
    @Test
    public void test06_detectImg() throws URISyntaxException {
        // 检测照片中的头脸部位置
        final URL url2 = this.getClass().getClassLoader().getResource("testImages/zhourunfa_02.jpg");
        final DetectRtnDto dto = client.detectImg(new File(url2.toURI()));
        logger.info("{}", dto);
    }

    /**
     * 删除所有照片
     */
    @Test
    public void test07_deleteImg() throws URISyntaxException {

        // 删除所有照片
        for (final Entry<String, String> entry : userInfo.entrySet()) {
            final DeleteImgRtnDto dto = client.deleteImg(libName, entry.getKey());
            logger.info("{}", dto);
        }
        test02_getLibStatus();

    }

    /**
     * 删除照片库
     */
    @Test
    public void test09_deleteLib() throws URISyntaxException {

        // 删除照片库
        client.deleteLib(libName);

    }
}
