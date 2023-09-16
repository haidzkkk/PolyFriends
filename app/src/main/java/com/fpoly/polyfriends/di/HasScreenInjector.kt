package com.fpoly.polyfriends.di

interface HasScreenInjector {
    // inject scope nhỏ k phải toàn app
    fun injector(): PolyConponent
}