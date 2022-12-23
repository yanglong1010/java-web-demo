package com.example.demo;

public class ResultData<T> {
    private T t;
    private long durationMillis;

    public ResultData() {
    }

    public ResultData(T t, long durationMillis) {
        this.t = t;
        this.durationMillis = durationMillis;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
    }
}
