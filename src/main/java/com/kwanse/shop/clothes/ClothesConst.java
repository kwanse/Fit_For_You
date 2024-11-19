package com.kwanse.shop.clothes;

public final class ClothesConst {

    public static final int MAX_TITLE_SIZE = 100;
    public static final int MIN_TITLE_SIZE = 1;
    public static final int MAX_IMAGE_SIZE = 50;
    public static final int MAX_CLOTHES_SIZE = 10;
    public static final int MAX_CLOTHES_COLOR = 10;

    public static final int CATEGORY_TOP_CODE = 1;
    public static final int CATEGORY_PANTS_CODE = 2;

    public static final String NOT_ENOUGH_STOCK = "Not Enough Stock";
    public static final String RANKED_CLOTHES_SUMMARY_CACHE = "rankingClothesCache";
    public static final String NORMAL_CLOTHES_SUMMARY_CACHE = "normalClothesCache";
    public static final String NORMAL_CLOTHES_DETAIL_CACHE = "normalClothesCache";

    public static final String REDIS_CLOTHES_KEY = "clothes:";

    private ClothesConst() {
    }
}
