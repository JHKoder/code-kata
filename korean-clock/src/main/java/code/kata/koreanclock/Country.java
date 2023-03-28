package code.kata.koreanclock;

public enum Country {
    KR("Asia/Seoul", "서울"),
    DE("CET", "덴마크"),
    HK("Asia/Hong_Kong", "홍콩"),
    NZ("NZ", "뉴질랜드"),
    US("US/Central", "미국 중부"),
    JP("Japan", "일본");

    private String code;
    private String name;

    Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public static Country findCode(String code) {
        return Country.valueOf(code);
    }

    public String getName() {
        return this.name;
    }
}
