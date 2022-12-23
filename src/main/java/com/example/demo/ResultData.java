package com.example.demo;

public class ResultData<T> {
    private T value;
    private long durationMillis;

    public ResultData() {
    }

    public ResultData(T t, long durationMillis) {
        this.value = t;
        this.durationMillis = durationMillis;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public long getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
    }
}
