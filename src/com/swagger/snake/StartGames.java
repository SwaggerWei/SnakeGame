package com.swagger.snake;

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {
        // 1 绘制一个静态窗口 JFrame
        JFrame jFrame = new JFrame("swagger-Java-贪吃蛇小游戏");
        // 设置页面大小
        jFrame.setBounds(10, 10, 900, 720);
        // 设置窗口是否可调整大小
        jFrame.setResizable(true);
        // 设置关闭事件,可以通过右上角叉叉进行关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 2 面板 JPanel 可以加入到JFrame
        jFrame.add(new GamePanel());


        // 设置窗口的可见性，这一步应该放到最后，不然画板中的内容不能生效
        jFrame.setVisible(true);
    }
}
