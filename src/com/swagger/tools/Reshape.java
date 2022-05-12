package com.swagger.tools;

public class Reshape {
    public static void main(String[] args) {
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/up_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/up1.png", 25, 25, ImageUtils.IMAGE_TYPE_PNG);
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/down_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/down1.png", 25, 25, ImageUtils.IMAGE_TYPE_PNG);
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/left_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/left1.png", 25, 25, ImageUtils.IMAGE_TYPE_PNG);
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/right_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/right1.png", 25, 25, ImageUtils.IMAGE_TYPE_PNG);
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/food_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/food1.png", 25, 25, ImageUtils.IMAGE_TYPE_PNG);
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/body_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/body1.png", 25, 25, ImageUtils.IMAGE_TYPE_PNG);
        ImageUtils.scaleToFile("/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/header_source.png",
                "/Users/swaggerwei/Desktop/look4Job/SnakeGame/src/statics/header1.png", 850, 50, ImageUtils.IMAGE_TYPE_PNG);
    }
}
