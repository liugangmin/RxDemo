package com.example.a38633.rxdemo;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.functions.Func1;

/**
 * Created by 38633 on 2016/10/24.
 */

public class Main2 {
    public static void main(String[] args) {
        while (true) {
            final String[] letters = new String[]{"A","B","C","D"};
            Observable<String> letterSequence = Observable .interval(300, TimeUnit.MILLISECONDS)
                    .map(new Func1<Long, String>() {
                        @Override
                        public String call(Long position) {
                            return  letters[position.intValue()];
                        }
                    }).take(letters.length);
            Observable<Long> numberSequence = Observable.interval(500,TimeUnit.MILLISECONDS).take(5);
            Observable.merge(letterSequence,numberSequence)
                    .subscribe(new Observer<Serializable>() {
                        @Override
                        public void onCompleted() {
                        }

                        @Override
                        public void onError(Throwable e) {
                            System.out.println("Error:"+e.getMessage());
                        }

                        @Override
                        public void onNext(Serializable serializable) {
                            System.out.println(serializable.toString()+" 9");
                        }
                    });
        }


    }
}
