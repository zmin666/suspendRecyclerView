package com.example.administrator.suspendrecyclerview;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static final int MODEL_COUNT = 60;

    public static List<StickyExampleModel> getData() {
        List<StickyExampleModel> stickyExampleModels = new ArrayList<>();

        for (int index = 0; index < MODEL_COUNT; index++) {
            if (index < 5) {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本1", "name" + index, "gender" + index, "profession" + index));
            } else if (index < 15) {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本2", "name" + index, "gender" + index, "profession" + index));
            } else if (index < 25) {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本3", "name" + index, "gender" + index, "profession" + index));
            } else if (index < 35) {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本4", "name" + index, "gender" + index, "profession" + index));
            } else if (index < 45) {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本5", "name" + index, "gender" + index, "profession" + index));
            } else if (index < 55) {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本6", "name" + index, "gender" + index, "profession" + index));
            } else {
                stickyExampleModels.add(new StickyExampleModel(
                        "吸顶文本7", "name" + index, "gender" + index, "profession" + index));
            }
        }

        return stickyExampleModels;
    }
}
