package edu.orangecoastcollege.cs273.ltruong58.tipcalculator;

/**
 * Process information for restaurant bill.
 * @author ltruong58
 * Created by ltruong58 on 9/8/2016.
 */
public class RestaurantBill {
    public static final double RECOMMEND_TIP = 0.2;

    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;


    public RestaurantBill() {
        mAmount = 0.0;
        mTipPercent = RECOMMEND_TIP;
        mTipAmount = 0.0;
        mTotalAmount = 0.0;
    }
    public RestaurantBill(double mAmount, double mTipPercent) {
        this.mAmount = mAmount;
        this.mTipPercent = mTipPercent;
        recalculateAmount();
    }

    public double getAmount() {
        return mAmount;
    }

    public double getTipPercent() {
        return mTipPercent;
    }

    public double getTipAmount() {
        return mTipAmount;
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmount();
    }

    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalculateAmount();
    }

    private void recalculateAmount()
    {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }
}
