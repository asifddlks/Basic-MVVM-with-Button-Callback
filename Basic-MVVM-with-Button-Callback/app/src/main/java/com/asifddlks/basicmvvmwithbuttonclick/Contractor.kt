package com.asifddlks.basicmvvmwithbuttonclick

//
// Created by Asif Ahmed on 15/3/22.
// Copyright (c) 2022 Techetron Ventures Ltd. All rights reserved.
//
interface Response {
    fun onResponse(text:String)
}
interface Callback{
    fun buttonClicked(view: String)
}