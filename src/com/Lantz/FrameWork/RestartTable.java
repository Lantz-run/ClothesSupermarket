package com.Lantz.FrameWork;

import java.util.Iterator;
import java.util.List;

public class RestartTable<T> implements Iterator<T>{

        private List collection;
        private int currentIndex;

        public RestartTable(List collection) {
            this.collection = collection;
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < collection.size();
        }

        @Override
        public T next() {
            if (hasNext()){
                T item = (T) collection.get(currentIndex);
                currentIndex++;
                return item;
            }
            // 如果已经遍历完了，重新开始
            currentIndex = 0;

            return next();
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }

        public void restart(){
            currentIndex = 0;
        }

}
