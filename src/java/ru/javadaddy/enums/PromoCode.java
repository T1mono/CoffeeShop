package ru.javadaddy.enums;

public enum PromoCode {
    WELCOME10("WELCOME10", 100);

    private final String code;

    private final  double discountValue;

    PromoCode(String code, double discountValue) {
        this.code = code;
        this.discountValue = discountValue;
    }

    public String getCode() {
        return code;
    }

    public double getDiscountValue() {
        return discountValue;
    }
}
