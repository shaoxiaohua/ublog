package com.ysm.ublog.shop.pojo;

public class Get_coupon {
    private t_coupon coupon;
    private int myhave;

    public Get_coupon() {
        this.myhave = 0;
    }

    public t_coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(t_coupon coupon) {
        this.coupon = coupon;
    }

    public int getMyhave() {
        return myhave;
    }

    public void setMyhave(int myhave) {
        this.myhave = myhave;
    }
}
