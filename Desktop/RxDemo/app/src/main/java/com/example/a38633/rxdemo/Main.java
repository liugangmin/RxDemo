package com.example.a38633.rxdemo;


import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by 38633 on 2016/10/24.
 */

public class Main {
    public static void main(String[] args) {
        Observable.create(new Observable.OnSubscribe<Integer>(){

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0;i<5;i++ ){
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("onComplect");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Item is " + integer);
            }
        });
    }
}
