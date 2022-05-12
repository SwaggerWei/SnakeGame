package com.swagger.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener{

    // 定义一个蛇
    int length; // 蛇的长度
    int[] snakeX = new int[600];// 蛇的坐标X
    int[] snakeY = new int[500];// 蛇的坐标Y

    boolean isStart = false;// 游戏是否开始
    String direction = "R";// 蛇的方向

    Timer timer = new Timer(100, this); // 间隔100ms 触发一次

    // 定义一个食物
    int foodx;
    int foody;
    Random random = new Random();

    // 判断失败
    boolean isFail = false;

    // 游戏积分榜
    int score;


    // 构造函数
    public GamePanel(){
        init();

        // 获取键盘的监听事件
        this.setFocusable(true);// 键盘聚焦到游戏上
        this.addKeyListener(this);

        // 时间动起来
        timer.start();
    }

    // 初始化
    public void init(){
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100; // 蛇头坐标
        snakeX[1] = 75; snakeY[1] = 100; // 第一节身体坐标
        snakeX[2] = 50; snakeY[2] = 100; // 蛇头坐标

        foodx = 25 + 25 * random.nextInt(34);
        foody = 75 + 25 * random.nextInt(24);

        score = 0;
    }

    // 画板： 画界面、画蛇
    // Graphics：为一个画笔
    @Override
    protected void paintComponent(Graphics g) {

        // 1 绘制静态面板
        // 调用父类，达到清屏效果
        super.paintComponent(g);
        // 设置背景的颜色
        this.setBackground(Color.WHITE);
        // 绘制头部广告栏
        Data.header.paintIcon(this, g, 25, 11);
        // 绘制游戏区域
        g.fillRect(25, 75, 850, 600);

        // 2 画一条静态的小蛇
        // 画蛇头
        if (direction.equals("R")){
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (direction.equals("L")){
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (direction.equals("U")){
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        }else if (direction.equals("D")){
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        // 画蛇身体

        for (int i = 1; i < length; i++) {
            // 蛇的身体长度，通过length 参数来控制
            Data.body1.paintIcon(this, g, snakeX[i], snakeY[i]);
        }

//        if (direction.equals("R") || direction.equals("L")){
//            for (int i = 1; i < length; i++) {
//                // 蛇的身体长度，通过length 参数来控制
//                Data.body1.paintIcon(this, g, snakeX[i], snakeY[i]);
//            }
//        }else {
//            for (int i = 1; i < length; i++) {
//                // 蛇的身体长度，通过length 参数来控制
//                Data.body2.paintIcon(this, g, snakeX[i], snakeY[i]);
//            }
//        }


        String font = "微软雅黑"; // 字体类型

        // 3 画积分
        g.setColor(Color.WHITE); // 设置画笔的颜色
        g.setFont(new Font(font, Font.BOLD, 18));
        g.drawString("长度：" + length, 750, 30);
        g.drawString("分数：" + score, 750, 50);

        // 4 画一个食物
        Data.food.paintIcon(this, g, foodx, foody);

        // 5 游戏提示，是否开始
        if (isStart == false){
            // 画一个文字
            g.setColor(Color.WHITE); // 设置画笔的颜色
            g.setFont(new Font(font, Font.BOLD, 40));
            g.drawString("按下空格开始游戏", 300, 300);
        }

        // 6 失败提醒
        if (isFail == true){
            // 画一个文字
            g.setColor(Color.RED); // 设置画笔的颜色
            g.setFont(new Font(font, Font.BOLD, 40));
            g.drawString("游戏失败，按下空格重新开始", 200, 300);
        }




    }


    // 接受键盘输入
    @Override
    public void keyPressed(KeyEvent e) {
        // 键盘：按下（未释放）
        // 获取按下的键盘是哪一个键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE){ // 如果按下的是空格键

            if (isFail == true){
                isFail = false;
                init(); // 重新初始化游戏
            }else {
                isStart = !isStart;
            }
            // 刷新界面
            repaint();
        }


        // 键盘控制走向
        if (keyCode == KeyEvent.VK_LEFT){
            if (direction != "R"){direction = "L";}
        }else if (keyCode == KeyEvent.VK_RIGHT){
            if (direction != "L"){direction = "R";}
        }else if (keyCode == KeyEvent.VK_UP){
            if (direction != "D"){direction = "U";}
        }else if (keyCode == KeyEvent.VK_DOWN){
            if (direction != "U"){direction = "D";}
        }


    }

    // 定时器，监听时间 帧：执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        // 如果游戏处于开始状态, 并且游戏没有失败
        if (isStart && isFail == false){

            for (int i = length - 1; i > 0 ; i--) { // 身体移动
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            // 通过控制方向让头部移动
            if (direction == "R"){
                if (snakeX[0] > 825){snakeX[0] = 0;}// 边界判断
                snakeX[0] = snakeX[0] + 25; // 头部移动
            }else if (direction == "L"){
                if (snakeX[0] < 50){snakeX[0] = 825;}// 边界判断
                snakeX[0] = snakeX[0] - 25; // 头部移动
            }else if (direction == "U"){
                if (snakeY[0] < 100){snakeY[0] = 675;}// 边界判断
                snakeY[0] = snakeY[0] - 25; // 头部移动
            }else if (direction == "D"){
                if (snakeY[0] > 625){snakeY[0] = 75;}// 边界判断
                snakeY[0] = snakeY[0] + 25; // 头部移动
            }

            // 如果蛇头和食物的坐标重合，说明吃到了食物
            if (snakeX[0] == foodx && snakeY[0] == foody){
                // 蛇的长度+1
                length ++;
                score = score+10;

                // 重新生成食物
                // 如果重新生成的食物坐标和蛇身或者头部相重合，则重新生成
                boolean isFoodCoveredByBody = false;
                while (true){
                    // 重新生成食物坐标
                    foodx = 25 + 25 * random.nextInt(34);
                    foody = 75 + 25 * random.nextInt(24);
                    for (int i = 0; i < length; i++) {
                        if (foodx == snakeX[i] && foody == snakeY[i]){
                            isFoodCoveredByBody = true;
                        }
                    }
                    if (isFoodCoveredByBody  == true){
                        continue;
                    }else {
                        break;
                    }
                }




            }

            // 失败判断
            for (int i = 1; i < length; i++) {
                if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                    isFail = true;
                }
            }





            // 刷新界面
            this.repaint();
        }
        timer.start();// 时间动起来
    }




    @Override
    public void keyReleased(KeyEvent e) {
        // 键盘：弹起（释放某个键）
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // 键盘： 按下+弹起 -》敲击了一下键盘
    }
}
