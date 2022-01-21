package com.mytool.base.utils;

/**
 * @author duankd
 * @ClassName MediaType
 * @date 2021-02-24 17:42:01
 */
public enum MediaType {


    /**
     * 其他 文件类型（1-图片类 2-音乐类 3-视频类 4-文档类 为空不限文件类型）
     */
    Other(0, "其他"),
    /**
     * 图片类
     */
    Image(1, "图片类"),
    /**
     * 音乐类
     */
    Music(2, "音乐类"),
    /**
     * 视频类
     */
    Video(3, "视频类"),
    /**
     * 文档类
     */
    Doc(4, "文档类");

    MediaType(int value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    private int value;
    private String msg;

    public int getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 判断数值是否属于枚举类的值
     *
     * @param key
     * @return
     */
    public static boolean isExist(Integer key) {
        boolean result = false;
        for (MediaType m : MediaType.values()) {
            if (m.getValue() == key) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 判断数值是否属于枚举类的值
     *
     * @param key
     * @return
     */
    public static boolean isExist(Long key) {
        boolean result = false;
        if (key == null) {
            result = true;
        } else {
            for (MediaType m : MediaType.values()) {
                if (m.getValue() == key) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
