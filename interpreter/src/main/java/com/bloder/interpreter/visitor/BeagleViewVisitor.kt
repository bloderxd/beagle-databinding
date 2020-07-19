package com.bloder.interpreter.visitor

import android.view.View
import com.bloder.interpreter.tree.Tree

interface BeagleViewVisitor {
    fun visit(view: View): Tree
}