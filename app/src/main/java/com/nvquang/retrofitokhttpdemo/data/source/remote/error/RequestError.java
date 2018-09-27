package com.nvquang.retrofitokhttpdemo.data.source.remote.error;

import android.support.annotation.NonNull;

import io.reactivex.functions.Consumer;

/**
 * Created by fs-sournary.
 * Date: 5/23/18.
 * Description:
 */

public abstract class RequestError implements Consumer<Throwable> {

    /**
     * Don't override this method.
     * Override {@link RequestError#onRequestError(BaseException)} instead
     */
    @Override
    public void accept(@NonNull Throwable throwable) throws Exception {
        if (throwable == null) {
            onRequestError(BaseException.toUnexpectedError(new Throwable("Unknown exception")));
            return;
        }
        if (throwable instanceof BaseException) {
            onRequestError((BaseException) throwable);
        } else {
            onRequestError(BaseException.toUnexpectedError(throwable));
        }
    }

    public abstract void onRequestError(BaseException error);
}
