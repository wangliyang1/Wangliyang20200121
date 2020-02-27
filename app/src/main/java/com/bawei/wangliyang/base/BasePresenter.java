package com.bawei.wangliyang.base;

public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void actach(V view) {
        this.view = view;
    }

    public void detach(){
        view = null;
    }
}
