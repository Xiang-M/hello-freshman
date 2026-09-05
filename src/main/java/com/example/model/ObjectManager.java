package com.example.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class ObjectManager {
    private List<DisplayObject> displayObjects;// 头像昵称
    private List<NumberStringObject> numberStringObjects;// 学号姓名
    private int displayedCount; // 已经展示的数量
    private int remainingCount; // 还未展示的数量

    public ObjectManager() {
        displayObjects = new ArrayList<>();
        numberStringObjects = new ArrayList<>();
        initializeObjects();
        displayedCount = 0;
        remainingCount = 33;
    }

    private void initializeObjects() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("objects.properties"));

            for (int i = 1; i <= 33; i++) {
                String image = props.getProperty("object." + i + ".image");
                String string1 = props.getProperty("object." + i + ".string1");
                String numberString = props.getProperty("object." + i + ".numberString");

                displayObjects.add(new DisplayObject(image, string1));
                numberStringObjects.add(new NumberStringObject(i, numberString));
            }
        } catch (IOException e) {
            // 如果配置文件不存在，使用默认值
            initializeDefaultObjects();
        }

    }

    private void initializeDefaultObjects() {
        // 初始化33个DisplayObject
        for (int i = 1; i <= 33; i++) {
            displayObjects.add(new DisplayObject(
                    "images/image" + i + ".jpg",
                    "默认字符串1 - " + i
            ));
            numberStringObjects.add(new NumberStringObject(i, "默认关联字符串 - " + i));
        }
        // 初始化33个NumberStringObject
        for (int i = 1; i <= 33; i++) {
            numberStringObjects.add(new NumberStringObject(
                    i,
                    "关联字符串 - " + i
            ));
        }
    }

    // 随机获取头像昵称
    public DisplayObject getRandomDisplayObject() {
        List<DisplayObject> notDisplayed = new ArrayList<>();
        for (DisplayObject obj : displayObjects) {
            if (!obj.isDisplayed()) {
                notDisplayed.add(obj);
            }
        }//候选范围：还没展示过的

        if (notDisplayed.isEmpty()) {
            return null;
        }

        Random random = new Random();
        DisplayObject selected = notDisplayed.get(random.nextInt(notDisplayed.size()));
        selected.setDisplayed(true);

        displayedCount++;
        remainingCount--;

        return selected;
    }

    // 随机获取学号姓名
    public NumberStringObject getRandomNumberStringObject() {
        List<NumberStringObject> notDisplayed = new ArrayList<>();
        for (NumberStringObject obj : numberStringObjects) {
            if (!obj.isDisplayed()) {
                notDisplayed.add(obj);
            }
        }

        if (notDisplayed.isEmpty()) {
            return null;
        }

        Random random = new Random();
        NumberStringObject selected = notDisplayed.get(random.nextInt(notDisplayed.size()));
        selected.setDisplayed(true);

        return selected;
    }

    public void resetAll() {
        for (DisplayObject obj : displayObjects) {
            obj.setDisplayed(false);
        }
        for (NumberStringObject obj : numberStringObjects) {
            obj.setDisplayed(false);
        }
        displayedCount = 0;
        remainingCount = 33;
    }

    // Getters
    public int getDisplayedCount() { return displayedCount; }
    public int getRemainingCount() { return remainingCount; }
}