package common;

public final class Constants {
    public static final String OUTPUT_PATH = "output/out_";
    public static final String REF_PATH = "ref/ref_test";
    public static final String FILE_EXTENSION = ".json";
    public static final Integer SMALL_TEST_POINTS = 2;
    public static final Integer BIG_TEST_POINTS = 3;
    public static final Integer TESTS_NUMBER = 25;
    public static final Integer MAXIMUM_ERROR_CHECKSTYLE = 30;
    public static final Integer CHECKSTYLE_POINTS = 10;
    public static final Integer TESTS_NUMBER_SMALL = 15;

    private Constants() {
        //constructor for checkstyle
    }

    //for i/o
    public static final String TESTS_PATH = "tests/";
    public static final String RESULT_PATH = "output";
    public static final String OUT_PATH = "output/out_";

    //Calculator constants
    public static final Double BABY_SCORE = 10d;
    public static final int BABY_AGE = 5;
    public static final int KID_AGE = 12;
    public static final int TEEN_AGE = 18;

    //for parsing JSON files
    public static final String NUMBER_OF_YEARS = "numberOfYears";
    public static final String SANTA_BUDGET = "santaBudget";
    public static final String INITIAL_DATA = "initialData";
    public static final String CHILDREN = "children";
    public static final String ID = "id";
    public static final String LAST_NAME = "lastName";
    public static final String FIRST_NAME = "firstName";
    public static final String AGE = "age";
    public static final String CITY = "city";
    public static final String NICE_SCORE = "niceScore";
    public static final String GIFTS_PREFERENCES = "giftsPreferences";
    public static final String SANTA_GIFT_LIST = "santaGiftsList";
    public static final String PRODUCT_NAME = "productName";
    public static final String PRICE = "price";
    public static final String CATEGORY = "category";
    public static final String ANNUAL_CHANGES = "annualChanges";
    public static final String NEW_SANTA_BUDGET = "newSantaBudget";
    public static final String NEW_GIFTS = "newGifts";
    public static final String NEW_CHILDREN = "newChildren";
    public static final String CHILDREN_UPDATES = "childrenUpdates";
}
