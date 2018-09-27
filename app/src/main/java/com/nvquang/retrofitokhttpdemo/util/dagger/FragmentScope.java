package com.nvquang.retrofitokhttpdemo.util.dagger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by fs-sournary.
 * Date: 5/23/18.
 * Description:
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {
}
