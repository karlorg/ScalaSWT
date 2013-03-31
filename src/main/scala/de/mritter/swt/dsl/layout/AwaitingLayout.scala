package de.mritter.swt.dsl.layout

import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.layout.FormLayout
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.RowLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Layout

// so this is kind of hackish. We construct composites with all available
// 'has-layout' traits mixed in, then wrap them in this class and use one
// of its methods to select a trait to keep, and drop the rest

class AwaitingLayout[C <: Composite] private[dsl] (
		constructor: Composite => C with HasFillLayout
                          with HasFormLayout
                          with HasGridLayout
                          with HasRowLayout) {

	private def createLayout[L <: Layout](layout: L)(setups: L => Unit*)(composite: Composite) = {
		composite.setLayout(layout)
		setups.foreach(_(layout))
	}
	
	def noLayout(n: Nothing*)(compSetups: C => Unit*)
                 (parent: Composite) = {
		val composite = constructor(parent)
		compSetups.foreach(_(composite))
	}

	def fillLayout(layoutSetups: FillLayout => Unit*)
                  (compSetups: C with HasFillLayout => Unit*)
                  (parent: Composite) = {
		val composite = constructor(parent)
		createLayout(new FillLayout())(layoutSetups: _*)(composite)
		compSetups.foreach(_(composite))
	}

	def formLayout(layoutSetups: FormLayout => Unit*)
                  (compSetups: C with HasFormLayout => Unit*)
                  (parent: Composite) = {
		val composite = constructor(parent)
		createLayout(new FormLayout())(layoutSetups: _*)(composite)
		compSetups.foreach(_(composite))
	}

	def gridLayout(layoutSetups: GridLayout => Unit*)
                  (compSetups: C with HasGridLayout => Unit*)
                  (parent: Composite) = {
		val composite = constructor(parent)
		createLayout(new GridLayout())(layoutSetups: _*)(composite)
		compSetups.foreach(_(composite))
	}

	def rowLayout(layoutSetups: RowLayout => Unit*)
                 (compSetups: C with HasRowLayout => Unit*)
                 (parent: Composite) = {
		val composite = constructor(parent)
		createLayout(new RowLayout())(layoutSetups: _*)(composite)
		compSetups.foreach(_(composite))
	}
}