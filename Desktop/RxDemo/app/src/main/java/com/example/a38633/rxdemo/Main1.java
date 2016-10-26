package com.example.a38633.rxdemo;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by 38633 on 2016/10/24.
 */

public class Main1 {
    public static void main(String[] args) {
        Observable.just(1,2,3,4,5)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return "this is " + integer;
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });
    }
}
