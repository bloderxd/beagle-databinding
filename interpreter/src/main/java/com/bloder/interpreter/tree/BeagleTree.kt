package com.bloder.interpreter.tree

sealed class Tree

data class Container(val children: List<Tree>) : Tree() {

    override fun toString(): String = "Container(children = listOf(${children}))"
}

data class Text(val text: String) : Tree() {

    override fun toString(): String = "Text(text = \"$text\")"
}