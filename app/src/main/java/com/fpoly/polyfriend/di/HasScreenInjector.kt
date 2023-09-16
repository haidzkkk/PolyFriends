package com.fpoly.polyfriend.di

interface HasScreenInjector {
    // inject scope nhỏ k phải toàn app
    fun injector(): PolyConponent
}