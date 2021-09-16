package com.example.roomapi.service;

public interface GunungListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
