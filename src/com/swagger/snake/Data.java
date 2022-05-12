package com.swagger.snake;

import javax.swing.*;
import java.net.URL;

// 存放外部数据
public class Data {
    // 头部图片 使用URL类，定位图片地址
    public static URL headerUrl = Data.class.getResource("/statics/header1.png");
    public static ImageIcon header = new ImageIcon(headerUrl);

//    // 头部图片
    public static URL upUrl = Data.class.getResource("/statics/up1.png");
    public static URL downUrl = Data.class.getResource("/statics/down1.png");
    public static URL leftUrl = Data.class.getResource("/statics/left1.png");
    public static URL rightUrl = Data.class.getResource("/statics/right1.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);

//    // 身体
    public static URL bodyUrl1 = Data.class.getResource("/statics/body1.png");
    public static ImageIcon body1 = new ImageIcon(bodyUrl1);

    //    // 食物
    public static URL foodUrl = Data.class.getResource("/statics/food1.png");
    public static ImageIcon food = new ImageIcon(foodUrl);


}
