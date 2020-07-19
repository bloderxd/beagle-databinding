package com.bloder.interpreter.visitor

import br.com.zup.beagle.android.components.layout.Screen
import com.bloder.interpreter.tree.Tree

interface BeagleTreeVisitor {
    fun visit(tree: Tree): Screen
}