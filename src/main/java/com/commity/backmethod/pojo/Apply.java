package com.commity.backmethod.pojo;

public enum Apply {
    TISSUE("纸巾",0),//纸巾 0
    TOOTHPASTE("牙膏",1),//牙膏 1
    SHAMPOO("洗发液",2),//洗发液 2
    SHOWER("沐浴露",3),//沐浴露 3
    DISINFECTANT("消毒液",4),//消毒液 4
    ALCOHOL("酒精",5),//酒精 5
    COTTONSWAB("棉签",6),//棉签 6
    GANMAOLING("感冒灵",7),//感冒灵 7
    RADIXISATIDIS("板蓝根",8),//板蓝根 8
    IBUPROFEN("布洛芬",9),//布洛芬 9
    RICE("米",10),//米 10
    SALT("盐",11),//盐 11
    OIL("油",12),//油 12
    RADISH("萝卜",13),//萝卜 13
    CABBAGE("白菜",14),//白菜 14
    PEPPER("辣椒",15),//辣椒 15
    EGGPLANT("茄子",16); //茄子 16
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private Apply(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (Apply c : Apply.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    }
